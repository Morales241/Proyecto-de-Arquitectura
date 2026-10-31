package fachadas;

import eventos.JugadorBase;
import fachadasInterfaz.ILobbyFachada;
import lobby.LobbyModel;
import eventos.IEventoSalirDeLobby;
import eventos.IEventoVotarParaIniciarPartida;

/**
 *
 * @author tacot
 */
public class LobbyFachada implements ILobbyFachada {
    private final LobbyModel lobbyModel;

    public LobbyFachada(LobbyModel lobbyModel ) {
        this.lobbyModel = lobbyModel;
    }
    
    @Override
    public void agregarObservadorVotar(IEventoVotarParaIniciarPartida listener){
        lobbyModel.agregarIEventoObserverVotar(listener);
    }
    
    @Override
    public void agregarObservadorSalir(IEventoSalirDeLobby listener){
        lobbyModel.agregarIEventoObserverSalirLobby(listener);
    }
    
    @Override
    public void actualizarLobby(JugadorBase jugadorBase){
    lobbyModel.ejecutarAccionObserverActualizarLobby(jugadorBase);
    }

}
