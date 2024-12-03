package observersLogicaAServidorCentral;

import eventos.JugadorAEliminarDto;

/**
 *
 * @author tacot
 */
public interface IEventoSalirDeLobby {
    public void salirDeLobby(JugadorAEliminarDto jugador);
}
