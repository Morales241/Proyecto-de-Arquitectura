package eventos;

import java.util.List;

/**
 *
 * @author tacot
 */
public class RespuestaDeUnirseAPartida extends RespuestaServidorCentral{
    private static final long serialVersionUID = 1L;

    private JugadorBase jugadorBase;
    private List<JugadorBase> jugadores;
    
    public RespuestaDeUnirseAPartida() {
    }

    public RespuestaDeUnirseAPartida(JugadorBase jugadorBase, String respuesta, Boolean key) {
        super(respuesta, key);
        this.jugadorBase = jugadorBase;
    }

    public RespuestaDeUnirseAPartida(JugadorBase jugadorBase) {
        this.jugadorBase = jugadorBase;
    }

    public JugadorBase getJugadorBase() {
        return jugadorBase;
    }

    public void setJugadorBase(JugadorBase jugadorBase) {
        this.jugadorBase = jugadorBase;
    }

    public List<JugadorBase> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorBase> jugadores) {
        this.jugadores = jugadores;
    }

    
    
}
