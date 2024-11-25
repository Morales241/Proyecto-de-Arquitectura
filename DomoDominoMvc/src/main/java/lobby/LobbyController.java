package lobby;

import dtos.JugadorDto;
import java.util.List;
import observers.IObserver;

/**
 * Controlador del lobby
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LobbyController {
 
    private final LobbyModel lobbyModel;
    private final LobbyView lobbyView;

    public LobbyController(LobbyModel lobbyModel, LobbyView lobbyView) {
        this.lobbyModel = lobbyModel;
        this.lobbyView = lobbyView;

        lobbyModel.agregarIEventoActualizarLista(new ActualizarLista());
        lobbyView.agregarIEventoIniciarPartida(new IniciarPartida());
    }

    public void agregarJugador(JugadorDto jugador) {
        lobbyModel.agregarJugador(jugador);
    }

    private class ActualizarLista implements IObserver {
        @Override
        public void actualizar() {
            List<JugadorDto> jugadores = lobbyModel.getJugadores();
            lobbyView.mostrarJugadores(jugadores);
        }
    }

    private class IniciarPartida implements IObserver {
        @Override
        public void actualizar() {
            lobbyModel.iniciarPartida();
            System.out.println("Partida iniciada");
        }
    }
}