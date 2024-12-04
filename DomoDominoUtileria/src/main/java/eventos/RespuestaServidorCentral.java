package eventos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tacot
 */
public class RespuestaServidorCentral implements Serializable{
    private static final long serialVersionUID = 1L;
    private String respuesta;
    private Boolean key;
    private List<JugadorBase> jugadores;

    public RespuestaServidorCentral(String respuesta, Boolean key) {
        this.respuesta = respuesta;
        this.key = key;
    }

    public List<JugadorBase> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorBase> jugadores) {
        this.jugadores = jugadores;
    }

    public RespuestaServidorCentral() {
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getKey() {
        return key;
    }

    public void setKey(Boolean key) {
        this.key = key;
    }
}
