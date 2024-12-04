package sereverCentral;

import cliente.GestorDeComunicaciones;
import eventos.EventoAcabarPartidaDto;
import eventos.IniciarPartidaAdmin;
import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorSeUnioAPartida;
import eventos.JugadorUnirseAPartidaDto;
import eventos.NodoDto;
import eventos.RespuestaDePartidaCreada;
import eventos.RespuestaDeUnirseAPartida;
import eventos.VotoDeJugador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;
import servidor.GestorMensajes;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final Map<String, List<JugadorBase>> infoPartidas;
    private final Map<String, Integer> VotosParaInciarPartidas;
    private final GestorDeComunicaciones comunicaciones;
    private final GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(ServerCentral.class.getName());

    public ServerCentral(GestorDeComunicaciones comunicacionesParametro) {
        this.infoPartidas = new HashMap<>();
        this.VotosParaInciarPartidas = new HashMap<>();
        this.comunicaciones = comunicacionesParametro;
        this.gestorMensajes = comunicaciones.getGestorMensajes();
        this.gestorMensajes.agregarObservadorCrearPartida(new AccionCrearPartida());
        this.gestorMensajes.agregarObservadorAgregarJugador(new AccionUnirseAPartida());
        this.gestorMensajes.agregarObservadorSalirDePartida(new AccionSalirDePartida());
        this.gestorMensajes.agregarObservadorIniciarPartida(new AccionVotarParaIniciarPartida());
        this.gestorMensajes.agregarObservadorAcabarPartida(new AccionAcabarParitda());

    }

    public void agregarPartida(JugadorCrearPartidaDto jugador) {

        List<JugadorBase> nodos = new ArrayList<>();
        conectarJugadorAlServer(jugador);
        try {
            nodos.add(jugador);

            this.infoPartidas.put(jugador.getCodigo(), nodos);

            this.VotosParaInciarPartidas.put(jugador.getCodigo(), 1);

            log.log(Level.INFO, "Método: agregarPartida - Clase: ServerCentral - Proyecto: Server Central");

            mandarMensaje(new RespuestaDePartidaCreada("Se creo la partida exitosamente", true), jugador.getNombre());

        } catch (Exception ex) {
            mandarMensaje(new RespuestaDePartidaCreada("No se pudo crear la partida", false), jugador.getNombre());
            cerrarConexionConNodo(jugador.getNombre());
        }
    }

    public void agregarJugadorPartida(JugadorUnirseAPartidaDto jugador) {
        log.log(Level.INFO, "Método: agregarJugadorPartida - Clase: ServerCentral - Proyecto: Server Central");

        List<JugadorBase> nodos = new ArrayList<>();

        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());

        conectarJugadorAlServer(jugador);

        RespuestaDeUnirseAPartida respuesta;

        if (seEncontroPartida) {

            nodos = infoPartidas.get(jugador.getCodigo());

            if (nodos.size() < 4) {
                infoPartidas.get(jugador.getCodigo()).add(jugador);

                int numJugadores = VotosParaInciarPartidas.get(jugador.getCodigo());

                this.VotosParaInciarPartidas.replace(jugador.getCodigo(), numJugadores++);

                JugadorBase jugadorBase = new JugadorBase(jugador.getNombre(), jugador.getAvatar());

                jugadorBase.setCodigo(jugador.getCodigo());

                respuesta = new RespuestaDeUnirseAPartida(jugadorBase, "Se ha unido a una partida", true);

                List<JugadorBase> jugadores = informacionDePartidaPorCodigo(jugador.getCodigo());

                respuesta.setJugadores(jugadores);
              
                jugadores.forEach(jugadorMensaje -> {
                    
                    if (jugador.getNombre().equals(jugadorMensaje.getNombre())) {
                        
                        mandarMensaje(respuesta, jugadorMensaje.getNombre());
                        
                    }else{
                        JugadorSeUnioAPartida jugadorSeUnioAPartida = new JugadorSeUnioAPartida(jugadorMensaje.getNombre(), jugadorMensaje.getAvatar()); 
                        
                        mandarMensaje(jugadorSeUnioAPartida, jugadorMensaje.getNombre());
                    }
                    
                });

            } else {
                nodos.clear();

                JugadorBase jugadorBase = new JugadorBase(jugador.getNombre(), jugador.getAvatar());

                respuesta = new RespuestaDeUnirseAPartida(jugadorBase, "La partida ya esta llena", false);

                mandarMensaje(respuesta, jugador.getNombre());

                cerrarConexionConNodo(jugador.getNombre());
            }

        } else {

            JugadorBase jugadorBase = new JugadorBase(jugador.getNombre(), jugador.getAvatar());

            respuesta = new RespuestaDeUnirseAPartida(jugadorBase, "No se encontro la partida", false);

            mandarMensaje(respuesta, jugador.getNombre());

            cerrarConexionConNodo(jugador.getNombre());
        }
    }

    public void sacarJugadorDePartida(JugadorAEliminarDto jugador) {

        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());

        List<NodoDto> nodos = new ArrayList<>();

        RespuestaDeUnirseAPartida respuesta;

        if (seEncontroPartida) {

            this.infoPartidas.get(jugador.getCodigo()).remove(jugador.getNodo());

            if (infoPartidas.get(jugador.getCodigo()).size() == 1) {
                acabarPartidaPorCodigo(jugador.getCodigo());
            }

            JugadorBase jugadorBase = new JugadorBase(jugador.getNombre(), jugador.getAvatar());

            jugadorBase.setCodigo(jugador.getCodigo());

            respuesta = new RespuestaDeUnirseAPartida(jugadorBase, "Saliste de la partida exitosamente", true);

            mandarMensaje(respuesta, jugador.getNombre());

            cerrarConexionConNodo(jugador.getNombre());
        } else {
            JugadorBase jugadorBase = new JugadorBase(jugador.getNombre(), jugador.getAvatar());

            respuesta = new RespuestaDeUnirseAPartida(jugadorBase, "No se encontro la partida", false);

            mandarMensaje(respuesta, jugador.getNombre());

            cerrarConexionConNodo(jugador.getNombre());
        }
    }

    public List<JugadorBase> informacionDePartidaPorCodigo(String codigo) {
        boolean seEncontroPartida = infoPartidas.containsKey(codigo);

        return seEncontroPartida ? infoPartidas.get(codigo) : new ArrayList<>();
    }

    public void acabarPartidaPorCodigo(String codigo) {
        log.log(Level.INFO, "Método: acabarPartidaPorCodigo - Clase: ServerCentral - Proyecto: Server Central");

        infoPartidas.get(codigo).forEach(nodo -> {
            cerrarConexionConNodo(nodo.getNombre());
        });

        infoPartidas.remove(codigo);
    }

    public void mandarMensaje(Object mensaje, String nombre) {
        log.log(Level.INFO, "Método: mandarMensaje - Clase: ServerCentral - Proyecto: Server Central");

        comunicaciones.enviarMensaje(mensaje, nombre);

    }

    public void cerrarConexionConNodo(String nombre) {
        log.log(Level.INFO, "Método: cerrarConexionConNodo - Clase: ServerCentral - Proyecto: Server Central");

        comunicaciones.cerrarConexionConNodo(nombre);
    }

    public void conectarJugadorAlServer(JugadorBase jugador) {
        log.log(Level.INFO, "Método: conectarJugadorAlServer - Clase: ServerCentral - Proyecto: Server Central");

        comunicaciones.conectarAServidor(jugador);
    }

    public void mandarInfoParaIniciarPartida(String codigo) {

        log.log(Level.INFO, "Método: mandarInfoDePartida - Clase: ServerCentral - Proyecto: Server Central");

        IniciarPartidaAdmin infoAdmin = new IniciarPartidaAdmin(infoPartidas.get(codigo));

        String nombreAdmin = infoPartidas.get(codigo).get(0).getNombre();

        mandarMensaje(infoAdmin, nombreAdmin);

    }

    public void votarParaInciarPartida(String codigo) {
        int numeroJugadores = infoPartidas.get(codigo).size();

        int numeroVotos = VotosParaInciarPartidas.get(codigo);

        numeroVotos++;

        VotosParaInciarPartidas.replace(codigo, numeroVotos);

        if (numeroJugadores >= numeroVotos && numeroVotos != 1 && numeroJugadores != 1) {
            mandarInfoParaIniciarPartida(codigo);
        }
    }

    //CLASES PRIVADAS
    private class AccionCrearPartida implements IEventoCrearPartida {

        @Override
        public void crearPartida(JugadorCrearPartidaDto jugador) {

            agregarPartida(jugador);
        }

    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {
            agregarJugadorPartida(jugador);
        }
    }

    private class AccionSalirDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {
            sacarJugadorDePartida(jugador);
        }
    }

    private class AccionVotarParaIniciarPartida implements IEventoVotarParaIniciarPartida {

        @Override
        public void iniciarPartida(VotoDeJugador votoDeJugador) {
            votarParaInciarPartida(votoDeJugador.getCodigo());
        }
    }

    private class AccionAcabarParitda implements IEventoAcabarPartida {

        @Override
        public void acabarPartida(EventoAcabarPartidaDto acabarPartidaDto) {
            acabarPartidaPorCodigo(acabarPartidaDto.getCodigo());
        }
    }
}
