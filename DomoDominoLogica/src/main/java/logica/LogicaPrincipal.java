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
import dtos.ArregloDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.EventoAcabarPartidaDto;
import eventos.IniciarPartidaAdmin;
import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorSeUnioAPartida;
import eventos.JugadorUnirseAPartidaDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import eventos.RespuestaDeUnirseAPartida;
import eventos.RespuestaServidorCentral;
import eventos.SetUpDto;
import eventos.VotoDeJugador;
import fachadas.ArregloFachada;
import fachadas.AvisoFachada;
import fachadas.LobbyFachada;
import fachadasInterfaz.IAvisoFachada;
import fachadasInterfaz.ICrearPartidaFachada;
import fachadasInterfaz.IInicioFachada;
import fachadasInterfaz.ITableroFachada;
import fachadasInterfaz.IUnirseAPartidaFachada;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import gestorTurno.ILogicaGestorTurno;
import gestorTurno.LogicaGestorTurno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lobby.ILobbyLogica;
import lobby.LobbyLogica;
import mediador.Mediador;
import observers.IEventoPasarTurno;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IEventoIniciarPartida;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IObserver;
import unirseAPartida.ILogicaUnirseAPartida;
import unirseAPartida.LogicaUnirseAPartida;
import observers.IEventoAcabarPartida;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoValidarFichas;
import observersLogicaAServidorCentral.IEventoSalirDeLobby;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;
import observersServerCentralALogica.IEventoIniciarPartidaAdmin;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;
import observersServerCentralALogica.IEventoSeUnieronAtuPartida;
import tablero.ILogicaTablero;
import tablero.LogicaTablero;
import terminarPartida.ILogicaTerminarPartida;
import terminarPartida.LogicaTerminarPartida;

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
    private final ILogicaGestorTurno logicaTurnos;
    private final ILogicaTerminarPartida logicaTerminarPartida;
    private String nombre;
    private int avatar;
    private String codigo;
    private final ILogicaTablero logicaTablero;

    private InicializadorComunicaciones inicalizadorComunicaciones;
    private final IGestorDeComunicacionesFachada comunicaciones;

    private final IInicioFachada inicioFachada;
    private final ITableroFachada tableroFachada;
    private final ICrearPartidaFachada crearPartidaFachada;
    private final IAvisoFachada avisoFachada;
    private IUnirseAPartidaFachada unirsePartidaFachada;
    private final ILobbyLogica lobbyLogica;

    private InicializadorClases inicializadorClases;

    //poner variables de las fachadas que conectan a los modelos de los diferentes MVC
    public LogicaPrincipal() {
        mediador = Mediador.getInstancia();

        inicializarClases();

        comunicaciones = inicalizadorComunicaciones.getComunicaciones();

        lInicio = new LogicaInicio();

        IUnirsePartida = new LogicaUnirseAPartida(comunicaciones);

        lCrearPartida = new LogicaCrearPartida(comunicaciones);

        IPozo = new LogicaPozo();

        inicioFachada = inicializadorClases.getInicioFachada();

        crearPartidaFachada = inicializadorClases.getCrearPartidaFachada();

        tableroFachada = inicializadorClases.getTableroFachada();

        avisoFachada = inicializadorClases.getAvisoFachada();

        logicaAviso = new LogicaAviso((AvisoFachada) avisoFachada);

        lobbyLogica = new LobbyLogica((LobbyFachada) inicializadorClases.getLobbyFachada(), comunicaciones);

        logicaTurnos = new LogicaGestorTurno(comunicaciones, inicializadorClases.getTurnosFachada());

        logicaTerminarPartida = new LogicaTerminarPartida(comunicaciones);

        logicaTablero = new LogicaTablero(tableroFachada);

        IArreglo = new LogicaArreglo((ArregloFachada) inicializadorClases.getArregloFachada());

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
        logicaTablero.agregarIEventoPonerFicha(new AccionPonerFicha());
        logicaTablero.agregarIEventoTomarFIchaDelPozo(new AccionTomarFichaDelPozo());
        logicaTablero.agregarIEventoSalirDePartida(new AccionSalirDePartida());
        logicaTablero.agregarIEventoValidarFichas(new AccionValidarFicha());

        //agregar observers de comunicaciones
        comunicaciones.agregarObservadorAcabarPartida(new AccionAcabarPartida());
        comunicaciones.agregarObservadorFichaTomadaDelPozo(new AccionTomaronFichaDelPozo());
        comunicaciones.agregarObservadorIniciarPartida(new AccionSeInicioPartida());
        comunicaciones.agregarObservadorPasaronTurno(new AccionPasaronTurno());
        comunicaciones.agregarObservadorRespuestaCrearPartida(new AccionRecibirRespuestaCrearPartida());
        comunicaciones.agregarObservadorRespuestaUnirseAPartida(new AccionRecibirRespuestaUnirseAPartida());
//      comunicaciones.agregarObservadorSalioUnJugador(observador);
        comunicaciones.agregarObservadorIniciarPartidaAdmin(new AccionComenzarPartidaAdministrador());
        comunicaciones.agregarObservadorPusieronFicha(new AccionPusieronFicha());
        comunicaciones.agregarObservadorSalioUnJugador(new AccionJugadorSalioDePartida());
        comunicaciones.agregarObservadorSeUnieronAtuPartida(new AccionSeUnioJugadorAlaPartida());

        //agregar obserevers de lobby
        lobbyLogica.agregarObservadorSalir(new AccionCerrarLobby());
        lobbyLogica.agregarObservadorVotar(new AccionVotarParaIniciarPartida());
    }

    public void inicializarnos(String nombre, int avatar, String codigo) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.codigo = codigo;
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

    private class AccionValidarFicha implements IEventoValidarFichas {

        @Override
        public void validarFichas(List<FichaDto> fichas) {
            boolean posibleMovimiento = IArreglo.verificarPosiblesMovimientos(fichas);

            logicaTablero.enviarValidacionDeFichas(posibleMovimiento);
        }

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

            String codigo = lCrearPartida.crearPartida(jugador);
            inicializarnos(jugador.getNombre(), jugador.getAvatar(), jugador.getCodigo());
        }

    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {

            inicializarnos(jugador.getNombre(), jugador.getAvatar(), jugador.getCodigo());
            IUnirsePartida.unirseAPartida(jugador);
        }
    }

    //EN ESPERA
    private class AccionSalirDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {

        }
    }

    private class AccionPonerFicha implements IEventoPonerFicha {

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {

            boolean respuesta = IArreglo.colocarFicha(ponerFicha.getFicha(), ponerFicha.getExtremo(), ponerFicha.getDireccion());
            ArregloDto arreglo;

            if (respuesta) {
                arreglo = IArreglo.convertirEntidad(IArreglo.obtenerArreglo());

                JugadorDto jugador = ponerFicha.getJugador();

                jugador.getFichas().remove(ponerFicha.getFicha());

                logicaTablero.mandarArregloActualizado(arreglo);

                logicaTablero.mandarJugadorActualizado(jugador);

                logicaTurnos.pasarTurno();

                boolean seAcaboPartida = false;

                if (jugador.getFichas().size() == 0) {
                    seAcaboPartida = true;
                }

                ponerFicha.getCompañeros().forEach(compañero -> {

                    String nombre = compañero.getNombre();

                    comunicaciones.enviarMensaje(ponerFicha, nombre);

                });

                logicaTablero.avisarDePasoDeTurno(false);

                if (seAcaboPartida) {
                    acabarPartida(ponerFicha.getCompañeros());
                }
            }
        }
    }

    public void acabarPartida(List<JugadorBase> jugadoresBase) {

        jugadoresBase.forEach(compañero -> {

            String nombre = compañero.getNombre();

            EventoAcabarPartidaDto eventoAcabarPartidaDto = new EventoAcabarPartidaDto(codigo);

            comunicaciones.enviarMensaje(eventoAcabarPartidaDto, nombre);

        });

        comunicaciones.enviarMensaje(new EventoAcabarPartidaDto(codigo), "serverCentral");

        jugadoresBase.forEach(compañero -> {

            String nombre = compañero.getNombre();

            comunicaciones.cerrarComunicacionConNodo(nombre);

        });

        logicaAviso.mostrarAviso("Has ganado");
        mediador.mostrarPantallaConcreta("inicio");
    }

    private class AccionTomarFichaDelPozo implements IEventoPedirFichaAlPozo {

        @Override
        public void pedirFicha() {
            FichaDto fichaSacada = IPozo.sacarFicha();
            logicaTablero.enviarFichaDelPozo(fichaSacada);
            comunicaciones.enviarMensajesACompañeros(fichaSacada);
        }
    }

    private class AccionTomaronFichaDelPozo implements IEventoTomarFichaDelPozo {

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {
            IPozo.sacarFichaEspecifica(fichaSacada.getLado1(), fichaSacada.getLado2());
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

    public void limpiarCampos() {
        this.avatar = 1;
        this.codigo = "";
        this.nombre = "";
    }

    private class AccionCerrarLobby implements IEventoSalirDeLobby {

        @Override
        public void salirDeLobby(JugadorAEliminarDto jugador) {
            lobbyLogica.inicializarnos(nombre, avatar);
            lobbyLogica.salirDeLobby(jugador);
            limpiarCampos();
            mediador.mostrarPantallaConcreta("inicio");

        }
    }

    private class AccionVotarParaIniciarPartida implements IEventoVotarParaIniciarPartida {

        @Override
        public void iniciarPartida(VotoDeJugador votoDeJugador) {
            lobbyLogica.votarParaIniciarPartida(votoDeJugador);
        }
    }

    /*
        LEAN ESTO!!!
        A PARTIR DE AQUI CREEN CLASES PRIVADAS PARA QUE SE PROCECEN LOS EVENTOS 
        ENTRE LOS COMUNICACIONES Y LA LOGICA
     */
    //EN ESPERA
    private class AccionPasaronTurno implements IEventoPasarTurno {

        @Override
        public void pasarTurno(PasarTurno pasarTurno) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    private class AccionPusieronFicha implements IEventoPonerFicha {

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {
            IArreglo.colocarFicha(ponerFicha.getFicha(), ponerFicha.getExtremo(), ponerFicha.getDireccion());

            ArregloDto arreglo = IArreglo.convertirEntidad(IArreglo.obtenerArreglo());

            logicaTablero.mandarArregloActualizado(arreglo);

            logicaTurnos.pasarTurno();

            if (logicaTurnos.obtenerTurnoActual().equals(nombre)) {
                logicaTablero.avisarDePasoDeTurno(true);
            }
        }
    }

    private class AccionJugadorSalioDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    private class AccionSeInicioPartida implements IEventoIniciarPartida {

        @Override
        public void iniciarPartida(SetUpDto setUp) {

            setUp.getJugadoresDePartida().forEach(O -> comunicaciones.conectarAServidor(O));

            logicaTurnos.sincronizarTurnosConClaseExterna(setUp.getTurnos());

            boolean turno = false;

            if (logicaTurnos.obtenerTurnoActual().equals(nombre)) {
                turno = true;
            }

            List<FichaDto> fichas = setUp.getFichasSacadasDelPozo();

            IPozo.sacarFichasEspecificasPozo(fichas);

            ArregloDto arreglo = IArreglo.convertirEntidad(IArreglo.obtenerArreglo());

            JugadorDto jugadorDto = new JugadorDto(setUp.getNombre(), setUp.getAvatar(), setUp.getFichasDelJugador());

            logicaTablero.mandarDatosDeInicioDePartida(jugadorDto, arreglo, setUp.getJugadoresDePartida(), turno);

            mediador.mostrarPantallaConcreta("tablero");
            
            // si quieres eliminar elemina esto
                FichaDto fichaMulaMasAlta = null;
                int valorMulaMasAlta = -1;

                for (FichaDto ficha : jugadorDto.getFichas()) {
                    if (ficha.esMula() && ficha.getLado1() > valorMulaMasAlta) {
                        fichaMulaMasAlta = ficha;
                        valorMulaMasAlta = ficha.getLado1();
                    }
                }

                AccionPonerFicha accionPonerFicha = new AccionPonerFicha();
                PonerFichaDto fichaDto = new PonerFichaDto(fichaMulaMasAlta, true, "", jugadorDto);
                fichaDto.setCompañeros(setUp.getJugadoresDePartida());
                accionPonerFicha.ponerFicha(fichaDto);
                // si quieres eliminar elemina esto
        }

    }

    private class AccionAcabarPartida implements IEventoAcabarPartida {

        @Override
        public void acabarPartida(EventoAcabarPartidaDto codigo) {
            logicaTerminarPartida.acabarPartida(codigo);
            //aqui deberia ir un algoritmo de el puesto dependiendo de la lista
            logicaAviso.mostrarAviso("Se acabo la partida");

            mediador.MostrarAviso();

            mediador.mostrarPantallaConcreta("inicio");
        }

    }


    /*
        LEAN ESTO!!!
        A PARTIR DE AQUI CREEN CLASES PRIVADAS PARA QUE SE PROCECEN LOS EVENTOS 
        ENTRE EL SERVER CENTRAL Y LA LOGICA
     */
    private class AccionRecibirRespuestaCrearPartida implements IEventoRespuestaServidorCentral {

        @Override
        public void actualizar(RespuestaServidorCentral respuesta) {

            JugadorBase Yo = new JugadorBase(nombre, avatar);
            Yo.setCodigo(codigo);

            lobbyLogica.actualizarLobby(Yo);

            if (!respuesta.getKey()) {
                mediador.MostrarAviso();

            } else {

                mediador.mostrarPantallaConcreta("lobby");
            }

        }
    }

    private class AccionSeUnioJugadorAlaPartida implements IEventoSeUnieronAtuPartida {

        @Override
        public void avisarAJugadores(JugadorSeUnioAPartida jugadorSeUnioAPartida) {
            lobbyLogica.actualizarLobby(new JugadorBase(jugadorSeUnioAPartida.getNombre(), jugadorSeUnioAPartida.getAvatar()));
        }
    }

    private class AccionRecibirRespuestaUnirseAPartida implements IEventoRespuestaServidorCentral {

        @Override
        public void actualizar(RespuestaServidorCentral respuesta) {

            RespuestaDeUnirseAPartida jugadorAux = (RespuestaDeUnirseAPartida) respuesta;

            if (respuesta.getKey()) {

                JugadorBase Yo = new JugadorBase(nombre, avatar);
                Yo.setCodigo(codigo);

                lobbyLogica.actualizarLobby(Yo);

                jugadorAux.getJugadores().forEach(jugador -> {

                    if (!getNombre().equals(jugador.getNombre())) {
                        lobbyLogica.actualizarLobby(jugador);
                    }
                });

                mediador.mostrarPantallaConcreta("lobby");

            } else {

                logicaAviso.mostrarAviso(respuesta.getRespuesta());
            }
        }
    }

    private class AccionComenzarPartidaAdministrador implements IEventoIniciarPartidaAdmin {

        @Override
        public void iniciarPartida(IniciarPartidaAdmin partidaAdmin) {

            String miNombre = nombre;
            int miAvatar = avatar;

            Map<String, SetUpDto> jugadores = new HashMap<>();
            List<FichaDto> fichasSacasDelPozo = new ArrayList<>();
            int fichasDePartida = partidaAdmin.getFichasDePartida();
            List<JugadorDto> jugadorDtos = new ArrayList<>();
            List<JugadorBase> jugadoresPartida = partidaAdmin.getListaJugadores();

            jugadoresPartida.forEach(jugadorAux -> {
                if (!jugadorAux.getNombre().equals(miNombre)) {
                    comunicaciones.conectarAServidor(jugadorAux);
                }
            });

            jugadoresPartida.forEach(jugadorAux -> {
                String nombre = jugadorAux.getNombre();
                int avatar = jugadorAux.getAvatar();

                List<FichaDto> fichasDeJugador = IPozo.repartirFichas(fichasDePartida);
                SetUpDto setUpDto = new SetUpDto(nombre, avatar, new ArrayList<>(), fichasDeJugador, new ArrayList<>());

                List<JugadorBase> compañeros = new ArrayList<>();
                jugadoresPartida.forEach(jugadorAux2 -> {
                    if (!nombre.equals(jugadorAux2.getNombre())) {
                        compañeros.add(jugadorAux2);
                    }
                });

                setUpDto.setJugadoresDePartida(compañeros);
                fichasSacasDelPozo.addAll(fichasDeJugador);
                jugadores.put(nombre, setUpDto);
                jugadorDtos.add(new JugadorDto(nombre, avatar, fichasDeJugador));
            });
            

            logicaTurnos.inicializarTurnos(jugadorDtos);

            List<JugadorDto> ordenTurnos = logicaTurnos.obtenerOrdenDeTurnos();

            for (String nombre : jugadores.keySet()) {
                SetUpDto setUpDto = jugadores.get(nombre);
                setUpDto.setTurnos(ordenTurnos);
                setUpDto.setFichasSacadasDelPozo(fichasSacasDelPozo);

            }

            jugadores.forEach((nombre, setUp) -> {
                if (!nombre.equals(miNombre)) {
                    comunicaciones.enviarMensaje(setUp, nombre);
                }
            });

            SetUpDto yo = jugadores.get(miNombre);

            logicaTurnos.sincronizarTurnosConClaseExterna(yo.getTurnos());

            boolean turno = false;

            if (logicaTurnos.obtenerTurnoActual().equals(nombre)) {
                turno = true;
// si quieres eliminar elemina esto
                JugadorDto jugadorDto = new JugadorDto(yo.getNombre(), yo.getAvatar(), yo.getFichasDelJugador());
                FichaDto fichaMulaMasAlta = null;
                int valorMulaMasAlta = -1;

                for (FichaDto ficha : jugadorDto.getFichas()) {
                    if (ficha.esMula() && ficha.getLado1() > valorMulaMasAlta) {
                        fichaMulaMasAlta = ficha;
                        valorMulaMasAlta = ficha.getLado1();
                    }
                }

                AccionPonerFicha accionPonerFicha = new AccionPonerFicha();
                PonerFichaDto fichaDto = new PonerFichaDto(fichaMulaMasAlta, true, "", jugadorDto);
                fichaDto.setCompañeros(yo.getJugadoresDePartida());
                accionPonerFicha.ponerFicha(fichaDto);
                // si quieres eliminar elemina esto
            }

            ArregloDto arreglo = IArreglo.convertirEntidad(IArreglo.obtenerArreglo());

            JugadorDto jugadorDto = new JugadorDto(yo.getNombre(), yo.getAvatar(), yo.getFichasDelJugador());

            logicaTablero.mandarDatosDeInicioDePartida(jugadorDto, arreglo, yo.getJugadoresDePartida(), turno);

            mediador.mostrarPantallaConcreta("tablero");

        }
    }

    public String getNombre() {
        return nombre;
    }

}
