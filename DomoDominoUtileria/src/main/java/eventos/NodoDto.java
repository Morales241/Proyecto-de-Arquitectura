package eventos;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Morales
 */
public class NodoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(NodoDto.class.getName());
    
    private String ip;
    private int puerto;

    public NodoDto() {
    }
    

    public NodoDto(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

   
}
