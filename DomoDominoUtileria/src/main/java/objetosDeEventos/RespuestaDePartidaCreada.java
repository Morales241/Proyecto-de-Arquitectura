package objetosDeEventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class RespuestaDePartidaCreada implements Serializable {

    private static final long serialVersionUID = 1L;
    private String respuesta;
    private boolean llave;

    public RespuestaDePartidaCreada(String respuesta, boolean llave) {
        this.respuesta = respuesta;
        this.llave = llave;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isLlave() {
        return llave;
    }

    public void setLlave(boolean llave) {
        this.llave = llave;
    }

}
