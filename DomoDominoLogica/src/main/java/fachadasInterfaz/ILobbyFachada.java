package fachadasInterfaz;

import eventos.JugadorBase;
import eventos.IEventoSalirDeLobby;
import eventos.IEventoVotarParaIniciarPartida;

/**
 *
 * @author tacot
 */
public interface ILobbyFachada {
    public void agregarObservadorVotar(IEventoVotarParaIniciarPartida listener);
    
    public void agregarObservadorSalir(IEventoSalirDeLobby listener);

    public void actualizarLobby(JugadorBase jugadorBase);
}
