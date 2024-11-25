package objetosDeEventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class JugadorAEliminarDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private NodoDto nodo;
    private String codigo;

    public JugadorAEliminarDto(NodoDto nodo, String codigo) {
        this.nodo = nodo;
        this.codigo = codigo;
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
    
}
