package observersLogicaAServidorCentral;

import objetosDeEventos.JugadorCrearPartidaDto;

/**
 *
 * @author tacot
 */
public interface IEventoCrearPartida {
    public void crearPartida(JugadorCrearPartidaDto jugador);
}
