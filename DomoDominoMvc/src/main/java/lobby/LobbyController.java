package lobby;

import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.VotoDeJugador;
import java.util.List;
import observers.IObserver;
import observersLogicaAServidorCentral.IEventoSalirDeLobby;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;

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
        
        lobbyView.agregarIEventoSalirDeLobby(new AccionRegresar());
        lobbyView.agregarIEventoVotarParaIniciarPartida(new AccionVotar());
        
    }
    
    public void regresarAlInicio(JugadorAEliminarDto jugador) {
        
    }
    
    public void votar(VotoDeJugador votoDeJugador) {
        
    }
    
    private class AccionRegresar implements IEventoSalirDeLobby {
        
        @Override
        public void salirDeLobby(JugadorAEliminarDto jugador) {
            
            regresarAlInicio(jugador);
        }
        
    }
    
    private class AccionVotar implements IEventoVotarParaIniciarPartida {
        
        @Override
        public void iniciarPartida(VotoDeJugador votoDeJugador) {
            
            votar(votoDeJugador);
        }
    }
}
