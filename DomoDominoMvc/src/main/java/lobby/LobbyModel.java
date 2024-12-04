package lobby;

import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.VotoDeJugador;
import java.util.ArrayList;
import java.util.List;
import observers.IEventoActualizarLobby;
import observers.IObserver;
import observersLogicaAServidorCentral.IEventoSalirDeLobby;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;

/**
 * Modelo del lobby
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LobbyModel {

    private final String[] rutasAvatares = {
        "/imgPartidaFichas/avatar1.png",
        "/imgPartidaFichas/avatar2.png",
        "/imgPartidaFichas/avatar3.png",
        "/imgPartidaFichas/avatar4.png"
    };

    private final List<JugadorBase> jugadores;
    private IEventoSalirDeLobby observerSalirLobby;
    private IEventoVotarParaIniciarPartida observerVotar;
    private IEventoActualizarLobby observerActualizarLobby;

    public LobbyModel() {
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(JugadorBase jugador) {
        jugadores.add(jugador);
        ejecutarAccionObserverActualizarLobby(jugador);
    }

    public void agregarIEventoObserverSalirLobby(IEventoSalirDeLobby listener) {
        this.observerSalirLobby = listener;
    }

    public void ejecutarAccionObserverSalirLobby(JugadorAEliminarDto jugador) {
        if (observerSalirLobby != null) {
            observerSalirLobby.salirDeLobby(jugador);
        }
    }

    public void agregarIEventoObserverVotar(IEventoVotarParaIniciarPartida listener) {
        this.observerVotar = listener;
    }

    public void ejecutarAccionObserverVotar(VotoDeJugador votoDeJugador) {
        if (observerVotar != null) {
            observerVotar.iniciarPartida(votoDeJugador);
        }
    }

    public void agregarIEventoObserverActualizarLobby(IEventoActualizarLobby listener) {
        this.observerActualizarLobby = listener;
    }

    public void ejecutarAccionObserverActualizarLobby(JugadorBase jugadorBase) {
        if (observerActualizarLobby != null) {
            observerActualizarLobby.actualizar(jugadorBase);
        }
    }

    public List<JugadorBase> getJugadores() {
        return jugadores;
    }
}
