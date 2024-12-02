package sereverCentral;

import cliente.GestorDeComunicaciones;
import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import eventos.NodoDto;
import eventos.RespuestaServidorCentral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IEventoSalirDePartida;
import servidor.GestorMensajes;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final Map<String, List<NodoDto>> infoPartidas;
    private final GestorDeComunicaciones comunicaciones;
    private final GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(ServerCentral.class.getName());

    public ServerCentral(GestorDeComunicaciones comunicacionesParametro) {
        infoPartidas = new HashMap<>();
        this.comunicaciones = comunicacionesParametro;
        this.gestorMensajes = comunicaciones.getGestorMensajes();

        this.gestorMensajes.agregarObservadorCrearPartida(new AccionCrearPartida());
        this.gestorMensajes.agregarObservadorAgregarJugador(new AccionUnirseAPartida());
        this.gestorMensajes.agregarObservadorSalirDePartida(new AccionSalirDePartida());
        this.gestorMensajes.agregarObservadorIniciarPartida(new AccionVotarParaIniciarPartida());
        this.gestorMensajes.agregarObservadorAcabarPartida(new AccionAcabarParitda());

    }

    public void agregarPartida(JugadorCrearPartidaDto jugador) {

        List<NodoDto> nodos = new ArrayList<>();
        try {
            nodos.add(jugador.getNodo());
            this.infoPartidas.put(jugador.getCodigo(), nodos);

            log.log(Level.INFO, "Método: agregarPartida - Clase: ServerCentral - Proyecto: Server Central");
            comunicaciones.conectarAServidor(jugador.getNodo().getIp(), jugador.getNodo().getPuerto());
            
//            mandarMensaje(, nodos);
        } catch (Exception ex) {
//            mandarMensaje("la partida no fue creada debido a un error", nodos);
        }
    }

    public void agregarJugadorPartida(JugadorUnirseAPartidaDto jugador) {
        List<NodoDto> nodos = new ArrayList<>();
        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());

        if (seEncontroPartida) {

            nodos = infoPartidas.get(jugador.getCodigo());

            if (nodos.size() < 4) {
                infoPartidas.get(jugador.getCodigo()).add(jugador.getNodo());

            } else {
                nodos.clear();
                nodos.add(jugador.getNodo());
//                mandarMensaje("No se encontro partida, el codigo es incorrecto", nodos);
                log.log(Level.INFO, "Método: agregarJugadorPartida - Clase: ServerCentral - Proyecto: Server Central");
            }

        } else {
            nodos.add(jugador.getNodo());
//            mandarMensaje("No se encontro partida, el codigo es incorrecto", nodos);
        }
    }

    public void sacarJugadorDePartida(JugadorAEliminarDto jugador) {

        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());

        List<NodoDto> nodos = new ArrayList<>();

        if (seEncontroPartida) {

            this.infoPartidas.get(jugador.getCodigo()).remove(jugador.getNodo());

            //enviar mensaje
        } else {
//        enviar mensaje de que la partida no se encontro
        }
    }

    public List<NodoDto> informacionDePartidaPorCodigo(String codigo) {
        boolean seEncontroPartida = infoPartidas.containsKey(codigo);

        return seEncontroPartida ? infoPartidas.get(codigo) : new ArrayList<>();
    }

    public void acabarPartidaPorCodigo(String codigo) {
        infoPartidas.remove(codigo);
    }

    public void mandarMensaje(Object mensaje, List<NodoDto> jugadores) {
        for (NodoDto jugador : jugadores) {
            comunicaciones.enviarMensaje(mensaje);
            log.log(Level.INFO, "Método: mandarMensaje - Clase: ServerCentral - Proyecto: Server Central");
        }
    }

    public void mandarInfoDePartida(List<NodoDto> jugadores) {

        for (NodoDto jugador : jugadores) {
            comunicaciones.enviarMensaje(jugador);
        }

    }

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
        public void iniciarPartida(String codigo) {
            List<NodoDto> jugadores = informacionDePartidaPorCodigo(codigo);
            mandarInfoDePartida(jugadores);
        }

    }

    private class AccionAcabarParitda implements IEventoAcabarPartida {

        @Override
        public void acabarPartida(String codigo) {
            acabarPartidaPorCodigo(codigo);

        }
    }
}
