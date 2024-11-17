package observersLogicaAServidorCentral;

import eventos.JugadorCrearPartidaDto;

/**
 *
 * @author tacot
 */
public interface IEventoCrearPartida {
    public void crearPartida(JugadorCrearPartidaDto jugador);
}
