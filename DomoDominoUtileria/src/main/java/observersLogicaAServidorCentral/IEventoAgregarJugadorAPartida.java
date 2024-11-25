package observersLogicaAServidorCentral;

import objetosDeEventos.JugadorUnirseAPartidaDto;

/**
 *
 * @author tacot
 */
public interface IEventoAgregarJugadorAPartida {
    public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador);
}
