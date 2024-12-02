package eventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class JugadorBase implements Serializable {

    private static final long serialVersionUID = 1L;
    private NodoDto nodo;
    private String codigo;
    private String nombre;
    private int avatar;

    public JugadorBase(NodoDto nodo, String codigo, String nombre, int avatar) {
        this.nodo = nodo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public JugadorBase() {
    }

    public NodoDto getNodo() {
        return nodo;
    }

    public void setNodo(NodoDto nodo) {
        this.nodo = nodo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

}
