package lobby;

import dtos.JugadorDto;
import java.util.ArrayList;
import java.util.List;
import observers.IObserver;

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
    
    private final List<JugadorDto> jugadores;
    private IObserver observerActualizarLista;
    private IObserver observerIniciarPartida;

    public LobbyModel() {
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(JugadorDto jugador) {
        jugadores.add(jugador);
        notificarActualizarLista();
    }

    public void iniciarPartida() {
        if (observerIniciarPartida != null) {
            observerIniciarPartida.actualizar();
        }
    }

    public void agregarIEventoActualizarLista(IObserver listener) {
        this.observerActualizarLista = listener;
    }

    public void agregarIEventoIniciarPartida(IObserver listener) {
        this.observerIniciarPartida = listener;
    }

    private void notificarActualizarLista() {
        if (observerActualizarLista != null) {
            observerActualizarLista.actualizar();
        }
    }

    public List<JugadorDto> getJugadores() {
        return jugadores;
    }
}
