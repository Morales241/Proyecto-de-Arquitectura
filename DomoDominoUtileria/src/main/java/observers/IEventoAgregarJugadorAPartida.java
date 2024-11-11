package observers;

import eventos.JugadorUnirseAPartidaDto;

/**
 *
 * @author tacot
 */
public interface IEventoAgregarJugadorAPartida {
    public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador);
}
