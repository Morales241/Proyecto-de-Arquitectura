package lobby;

import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.VotoDeJugador;
import observersLogicaAServidorCentral.IEventoSalirDeLobby;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;

/**
 *
 * @author tacot
 */
public interface ILobbyLogica {
    public void agregarObservadorVotar(IEventoVotarParaIniciarPartida listener);
    
    public void agregarObservadorSalir(IEventoSalirDeLobby listener);

    public void actualizarLobby(JugadorBase jugadorBase);
    
    public void inicializarnos(String nombre, int avatar);
    
    public void salirDeLobby(JugadorAEliminarDto jugadorAEliminarDto);
    
    public void votarParaIniciarPartida(VotoDeJugador votoDeJugador);
}
