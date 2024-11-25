package sereverCentral;

import cliente.Cliente;
import cliente.GestorDeComunicaciones;
import objetosDeEventos.JugadorAEliminarDto;
import objetosDeEventos.JugadorCrearPartidaDto;
import objetosDeEventos.JugadorUnirseAPartidaDto;
import objetosDeEventos.NodoDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosDeEventos.JugadorPartidaIniciada;
import objetosDeEventos.RespuestaDePartidaCreada;
import objetosDeEventos.RespuestaDeUnirseAPartida;
import objetosDeEventos.VotoDeJugador;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IEventoSalirDePartida;
import servidor.GestorMensajes;
import observersServerCentralALogica.IEventoVotarParaIniciarPartida;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final Map<String, List<JugadorPartidaIniciada>> infoPartidas;
    private final Map<String, Integer> votosParaComensarPartida;
    private final GestorDeComunicaciones comunicaciones;
    private final GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(ServerCentral.class.getName());

    public ServerCentral(GestorDeComunicaciones comunicacionesParametro) {
        infoPartidas = new HashMap<>();
        votosParaComensarPartida = new HashMap<>();
        this.comunicaciones = comunicacionesParametro;
        this.gestorMensajes = comunicaciones.getGestorMensajes();

        this.gestorMensajes.agregarObservadorCrearPartida(new AccionCrearPartida());
        this.gestorMensajes.agregarObservadorAgregarJugador(new AccionUnirseAPartida());
        this.gestorMensajes.agregarObservadorSalirDePartida(new AccionSalirDePartida());
//        this.gestorMensajes.agregarObservadorIniciarPartida(new AccionIniciarPartida());
        this.gestorMensajes.agregarObservadorAcabarPartida(new AccionAcabarParitda());

    }

    public void agregarPartida(JugadorCrearPartidaDto jugador) {

        List<JugadorPartidaIniciada> nodos = new ArrayList<>();
        try {
            nodos.add(new JugadorPartidaIniciada(jugador));

            this.infoPartidas.put(jugador.getCodigo(), nodos);
            this.votosParaComensarPartida.put(jugador.getCodigo(), 0);
            log.log(Level.INFO, "Método: agregarPartida - Clase: ServerCentral - Proyecto: Server Central");
            RespuestaDePartidaCreada respuestaDePartidaCreada = new RespuestaDePartidaCreada("Se a creado la partida exitosamente", true);

            mandarMensaje(respuestaDePartidaCreada, nodos);
        } catch (Exception ex) {
            RespuestaDePartidaCreada respuestaDePartidaCreada = new RespuestaDePartidaCreada("No se a creado la partida", false);

            mandarMensaje(respuestaDePartidaCreada, nodos);
        }
    }

    public void agregarJugadorPartida(JugadorUnirseAPartidaDto jugador) {
        List<JugadorPartidaIniciada> nodos = new ArrayList<>();

        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());

        if (seEncontroPartida) {

            nodos = infoPartidas.get(jugador.getCodigo());

            if (nodos.size() < 4) {
                infoPartidas.get(jugador.getCodigo()).add(new JugadorPartidaIniciada(jugador));

                RespuestaDeUnirseAPartida respuestaDeUnirseAPartida = new RespuestaDeUnirseAPartida("Se ha unido a una partida exitosamente", true);

                mandarMensaje(respuestaDeUnirseAPartida, nodos);
            } else {
                nodos.clear();

                nodos.add(new JugadorPartidaIniciada(jugador));

                RespuestaDeUnirseAPartida respuestaDeUnirseAPartida = new RespuestaDeUnirseAPartida("Partida llena", false);

                mandarMensaje(respuestaDeUnirseAPartida, nodos);

                log.log(Level.INFO, "Método: agregarJugadorPartida - Clase: ServerCentral - Proyecto: Server Central");
            }

        } else {
            nodos.add(new JugadorPartidaIniciada(jugador));

            RespuestaDeUnirseAPartida respuestaDeUnirseAPartida = new RespuestaDeUnirseAPartida("No se ha encontrado una partida", false);

            mandarMensaje(respuestaDeUnirseAPartida, nodos);
        }
    }

    public void sacarJugadorDePartida(JugadorAEliminarDto jugador) {

        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());

        List<NodoDto> nodos = new ArrayList<>();

        if (seEncontroPartida) {

            this.infoPartidas.get(jugador.getCodigo()).remove(jugador.getNodo());

        } else {
        }
    }

    public List<JugadorPartidaIniciada> informacionDePartidaPorCodigo(String codigo) {
        boolean seEncontroPartida = infoPartidas.containsKey(codigo);

        return seEncontroPartida ? infoPartidas.get(codigo) : new ArrayList<>();
    }

    public void acabarPartidaPorCodigo(String codigo) {
        infoPartidas.remove(codigo);
    }

    public void mandarMensaje(Object mensaje, List<JugadorPartidaIniciada> jugadores) {

        comunicaciones.enviarMensaje(mensaje, jugadores);
        log.log(Level.INFO, "Método: mandarMensaje - Clase: ServerCentral - Proyecto: Server Central");

    }

    public void mandarInfoDePartida(List<JugadorPartidaIniciada> jugadores) {
        List<JugadorPartidaIniciada> nodo = new ArrayList<>();
        nodo.add(jugadores.get(0));
        comunicaciones.enviarMensaje(jugadores, nodo);

    }

    public void votarParaIniciarPartida(VotoDeJugador votoDeJugador) {

        votosParaComensarPartida.replace(votoDeJugador.getCodigo(), votosParaComensarPartida.get(votoDeJugador.getCodigo()) + 1);

        int numeroDeJugadores = infoPartidas.get(votoDeJugador.getCodigo()).size();
        int votos = votosParaComensarPartida.get(votoDeJugador.getCodigo());

        if (votos == numeroDeJugadores) {
            mandarInfoDePartida(infoPartidas.get(votoDeJugador.getCodigo()));

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

    private class AccionIniciarPartida implements IEventoVotarParaIniciarPartida {

        @Override
        public void iniciarPartida(VotoDeJugador votoDeJugador) {
            votarParaIniciarPartida(votoDeJugador);
        }

    }

    private class AccionAcabarParitda implements IEventoAcabarPartida {

        @Override
        public void acabarPartida(String codigo) {
            acabarPartidaPorCodigo(codigo);

        }
    }

}
