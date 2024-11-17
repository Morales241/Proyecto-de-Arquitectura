package logica;

import Inicializador.InicializadorClases;
import Inicializador.InicializadorComunicaciones;
import Inicio.ILogicaInicio;
import Inicio.LogicaInicio;
import cliente.LogicaCliente;
import crearPartida.ILogicaCrearPartida;
import crearPartida.LogicaCrearPartida;
import dtos.FichaDto;
import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import eventos.PonerFichaDto;
import eventos.SetUpDto;
import fachadas.ICrearPartidaFachada;
import fachadas.IInicioFachada;
import fachadas.IUnirseAPartidaFachada;
import mediador.Mediador;
import observers.IEventoAgregarJugadorAPartida;
import observers.IEventoCrearPartida;
import observers.IEventoIniciarPartida;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IObserver;
import serializables.Jugador;
import unirseAPartida.ILogicaUnirseAPartida;
import unirseAPartida.LogicaUnirseAPartida;

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
    private final IInicioFachada iFachada;
    private final InicializadorComunicaciones comunicaciones;
    private final ICrearPartidaFachada crearPartidaFachada;
    private final IUnirseAPartidaFachada unirsePartidaFachada;
    private final InicializadorClases inicializadorClases;
    //poner variables de las fachadas que conectan a los modelos de los diferentes MVC

    public LogicaPrincipal() {
        mediador = Mediador.getInstancia();
        
        inicializadorClases = new InicializadorClases();
        
        inicializadorClases.InicializarClases();
        
        comunicaciones = new InicializadorComunicaciones();
        
        comunicaciones.inicializarClasesComunicaciones();
       
        lInicio = new LogicaInicio();
        
        lCrearPartida = new LogicaCrearPartida(comunicaciones.getComunicaciones());
        IUnirsePartida = new LogicaUnirseAPartida(comunicaciones.getComunicaciones());
        
        iFachada = inicializadorClases.getInicioFachada();
        
        iFachada.agregarIObserverCrearPartida(new AccionCambiarDePantallaCrearPartida());
        iFachada.agregarIObserverUnirseAPartida(new AccionCambiarDePantallaUnirseAPartida());
        
        crearPartidaFachada = inicializadorClases.getCrearPartidaFachada();
        crearPartidaFachada.agregarIEventoCrearPartida(new AccionCrearPartida());
        crearPartidaFachada.agregarIEventoRegresar(new AccionRegresarAlInicio());
        
        unirsePartidaFachada = inicializadorClases.getUnirseAPartidaFachada();
        unirsePartidaFachada.agregarIEventoUnirseAPartida(new AccionUnirseAPartida());
        unirsePartidaFachada.agregarIEventoRegresar(new AccionRegresarAlInicio());
        
    }

    //se va a cambiar el nombre de este metodo
    public void iniciarJuego() {

        mediador.mostrarPantallaConcreta("inicio");

    }

    private class AccionCrearPartida implements IEventoCrearPartida {

        @Override
        public void crearPartida(JugadorCrearPartidaDto jugador) {
            crearNuevaPartida(jugador);
        }

    }

    public void crearNuevaPartida(JugadorCrearPartidaDto jugador) {
        lCrearPartida.crearPartida(jugador);
    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {
             IUnirsePartida.unirseAPartida(jugador);
        }
    }

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

        }
    }

    private class AccionTomarFichaDelPozo implements IEventoTomarFichaDelPozo {

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {

        }
    }

    private class AccionElejirFicha {

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
    
    private class AccionRegresarAlInicio implements IObserver {

        @Override
        public void actualizar() {
           lInicio.regresarAlInicio();
        }
    }
    
}
