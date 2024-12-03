package eventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class RespuestaServidorCentral implements Serializable{
    private static final long serialVersionUID = 1L;
    private String respuesta;
    private Boolean key;

    public RespuestaServidorCentral(String respuesta, Boolean key) {
        this.respuesta = respuesta;
        this.key = key;
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
