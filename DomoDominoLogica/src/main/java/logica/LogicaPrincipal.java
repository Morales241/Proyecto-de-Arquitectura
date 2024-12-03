package logica;

import Arreglo.ILogicaArreglo;
import Arreglo.LogicaArreglo;
import Aviso.ILogicaAviso;
import Aviso.LogicaAviso;
import Inicializador.InicializadorClases;
import Inicializador.InicializadorComunicaciones;
import Inicio.ILogicaInicio;
import Inicio.LogicaInicio;
import Pozo.ILogicaPozo;
import Pozo.LogicaPozo;
import crearPartida.ILogicaCrearPartida;
import crearPartida.LogicaCrearPartida;
import dtos.FichaDto;
import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import eventos.RespuestaServidorCentral;
import eventos.SetUpDto;
import fachadas.AvisoFachada;
import fachadasInterfaz.IAvisoFachada;
import fachadasInterfaz.ICrearPartidaFachada;
import fachadasInterfaz.IInicioFachada;
import fachadasInterfaz.ITableroFachada;
import fachadasInterfaz.IUnirseAPartidaFachada;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import mediador.Mediador;
import observers.IEventoPasarTurno;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observersServerCentralALogica.IEventoIniciarPartida;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IObserver;
import unirseAPartida.ILogicaUnirseAPartida;
import unirseAPartida.LogicaUnirseAPartida;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;

/**
 * Clase de logica principal que se encarga el flujo
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LogicaPrincipal {

    private final Mediador mediador;

    private final ILogicaInicio lInicio;
    private final ILogicaCrearPartida lCrearPartida;
    private final ILogicaUnirseAPartida IUnirsePartida;
    private final ILogicaArreglo IArreglo;
    private final ILogicaPozo IPozo;
    private final ILogicaAviso logicaAviso;

    private InicializadorComunicaciones inicalizadorComunicaciones;
    private final IGestorDeComunicacionesFachada comunicaciones;

    private final IInicioFachada inicioFachada;
    private final ITableroFachada tableroFachada;
    private final ICrearPartidaFachada crearPartidaFachada;
    private final IAvisoFachada avisoFachada;
    private IUnirseAPartidaFachada unirsePartidaFachada;

    private InicializadorClases inicializadorClases;

    //poner variables de las fachadas que conectan a los modelos de los diferentes MVC
    public LogicaPrincipal() {
        mediador = Mediador.getInstancia();

        inicializarClases();

        comunicaciones = inicalizadorComunicaciones.getComunicaciones();

        lInicio = new LogicaInicio();

        IUnirsePartida = new LogicaUnirseAPartida(comunicaciones);

        lCrearPartida = new LogicaCrearPartida(comunicaciones);

        IArreglo = new LogicaArreglo();

        IPozo = new LogicaPozo();

        inicioFachada = inicializadorClases.getInicioFachada();

        crearPartidaFachada = inicializadorClases.getCrearPartidaFachada();

        tableroFachada = inicializadorClases.getTableroFachada();
        
        avisoFachada = inicializadorClases.getAvisoFachada();
        
        logicaAviso = new LogicaAviso((AvisoFachada) avisoFachada);

        agregarObservers();

    }

    public void inicializarClases() {
        inicializadorClases = new InicializadorClases();
        
        inicializadorClases.InicializarClases();

        inicalizadorComunicaciones = new InicializadorComunicaciones();

        inicalizadorComunicaciones.inicializarClasesComunicaciones();
    }

    public void agregarObservers() {
        //agregar observers de fachadas
        inicioFachada.agregarIObserverCrearPartida(new AccionCambiarDePantallaCrearPartida());
        inicioFachada.agregarIObserverUnirseAPartida(new AccionCambiarDePantallaUnirseAPartida());

        //agregar observers de aviso
        avisoFachada.agregarEventoCerrarPantalla(new AccionCerrarAviso());
        
        //agregar observers de crear partida
        crearPartidaFachada.agregarIEventoCrearPartida(new AccionCrearPartida());
        crearPartidaFachada.agregarIEventoRegresar(new AccionRegresarAlInicio());

        unirsePartidaFachada = inicializadorClases.getUnirseAPartidaFachada();
        unirsePartidaFachada.agregarIEventoUnirseAPartida(new AccionUnirseAPartida());
        unirsePartidaFachada.agregarIEventoRegresar(new AccionRegresarAlInicio());

        //agregar observer del tablero
        tableroFachada.agregarIEventoPonerFicha(new AccionPonerFicha());
        tableroFachada.agregarIEventoTomarFIchaDelPozo(new AccionTomarFichaDelPozo());
        tableroFachada.agregarIEventoPasarTurno(new AccionPasaronTurno());
        tableroFachada.agregarIEventoSalirDePartida(new AccionSalirDePartida());

        //agregar observers de comunicaciones
        comunicaciones.agregarObservadorAcabarPartida(new AccionAcabarPartida());
        comunicaciones.agregarObservadorFichaTomadaDelPozo(new AccionTomaronFichaDelPozo());
        comunicaciones.agregarObservadorIniciarPartida(new AccionSeInicioPartida());
        comunicaciones.agregarObservadorPasaronTurno(new AccionPasaronTurno());
        comunicaciones.agregarObservadorRespuestaCrearPartida(new AccionRecibirRespuestaCrearPartida());
        comunicaciones.agregarObservadorRespuestaUnirseAPartida(new AccionRecibirRespuestaUnirseAPartida());
        
//        comunicaciones.agregarObservadorPucieronFicha(new AccionPucieronFicha());
        
        comunicaciones.agregarObservadorSalioUnJugador(new AccionJugadorSaioDePartida());
    }

    /*
        LEAN ESTO!!!
        A PARTIR DE AQUI CREEN CLASES PRIVADAS PARA QUE SE PROCECEN LOS EVENTOS 
        ENTRE LOS MVC Y LA LOGICA
     */
    //LISTAS
    public void iniciarJuego() {

        mediador.mostrarPantallaConcreta("inicio");

    }

    private class AccionRegresarAlInicio implements IObserver {

        @Override
        public void actualizar() {
            lInicio.regresarAlInicio();
        }
    }
    
    private class AccionCambiarDePantallaCrearPartida implements IObserver {

        @Override
        public void actualizar() {
            lInicio.crearPartida();
        }
    }

    private class AccionCambiarDePantallaUnirseAPartida implements IObserver {

        @Override
        public void actualizar() {
            lInicio.unirseAPartida();
        }
    }

    private class AccionCrearPartida implements IEventoCrearPartida {

        @Override
        public void crearPartida(JugadorCrearPartidaDto jugador) {
            lCrearPartida.crearPartida(jugador);
        }

    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {
            IUnirsePartida.unirseAPartida(jugador);
        }
    }

    //EN ESPERA
    private class AccionIniciarPartida implements IEventoIniciarPartida {

        @Override
        public void iniciarPartida(SetUpDto setUp) {

        }
    }

    private class AccionSalirDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {

        }
    }

    private class AccionPonerFicha implements IEventoPonerFicha {

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {
            IArreglo.colocarFicha(ponerFicha.getFicha(), ponerFicha.getExtremo(), ponerFicha.getDireccion());
        }
    }

    private class AccionTomarFichaDelPozo implements IEventoTomarFichaDelPozo {

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {
            IPozo.sacarFicha();
        }
    }

    private class AccionElejirFicha {

    }
    
    private class AccionCerrarAviso implements IObserver {

        @Override
        public void actualizar() {
            logicaAviso.cerrarAviso();
        }

    }

    
    
    /*
        LEAN ESTO!!!
        A PARTIR DE AQUI CREEN CLASES PRIVADAS PARA QUE SE PROCECEN LOS EVENTOS 
        ENTRE LOS COMUNICACIONES Y LA LOGICA
     */
    //EN ESPERA
    private class AccionTomaronFichaDelPozo implements IEventoTomarFichaDelPozo {

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private class AccionPasaronTurno implements IEventoPasarTurno {

        @Override
        public void pasarTurno(PasarTurno pasarTurno) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private class AccionPucieronFicha implements IEventoPonerFicha {

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private class AccionJugadorSaioDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private class AccionSeInicioPartida implements IEventoIniciarPartida {

        @Override
        public void iniciarPartida(SetUpDto setUp) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private class AccionAcabarPartida implements IEventoAcabarPartida {

        @Override
        public void acabarPartida(String codigo) {
            System.out.println(codigo);
        }

    }

  

    /*
        LEAN ESTO!!!
        A PARTIR DE AQUI CREEN CLASES PRIVADAS PARA QUE SE PROCECEN LOS EVENTOS 
        ENTRE EL SERVER CENTRAL Y LA LOGICA
     */
    private class AccionRecibirRespuestaCrearPartida implements IEventoRespuestaServidorCentral{

        @Override
        public void actualizar(RespuestaServidorCentral respuesta) {
            
            logicaAviso.mostrarAviso(respuesta.getRespuesta());
            if(respuesta.getKey()){
                mediador.mostrarPantallaConcreta("lobby");
            }
            
        }
    }
    
    private class AccionRecibirRespuestaUnirseAPartida implements IEventoRespuestaServidorCentral{

        @Override
        public void actualizar(RespuestaServidorCentral respuesta) {
            
            logicaAviso.mostrarAviso(respuesta.getRespuesta());
            if(respuesta.getKey()){
                mediador.mostrarPantallaConcreta("lobby");
            }
        }
    }
}
