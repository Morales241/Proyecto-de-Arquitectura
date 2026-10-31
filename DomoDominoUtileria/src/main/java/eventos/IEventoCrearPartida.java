package eventos;

import eventos.JugadorCrearPartidaDto;

/**
 *
 * @author tacot
 */
public interface IEventoCrearPartida {
    public void crearPartida(JugadorCrearPartidaDto jugador);
}
