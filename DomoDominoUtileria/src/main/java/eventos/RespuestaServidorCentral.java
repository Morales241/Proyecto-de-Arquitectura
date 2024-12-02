package eventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class RespuestaServidorCentral implements Serializable{
    private static final long serialVersionUID = 1L;
    private String respuesta;

    public RespuestaServidorCentral(String respuesta) {
        this.respuesta = respuesta;
    }

    public RespuestaServidorCentral() {
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
