package eventos;

import java.io.Serializable;

/**
 *
 * @author Jesus Morales
 */
public class NodoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ip;
    private int puerto;
    private String nombre;
    private int avatar;

    public NodoDto(String ip, int puerto, String nombre, int avatar) {
        this.ip = ip;
        this.puerto = puerto;
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public NodoDto(String nombre, int avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
