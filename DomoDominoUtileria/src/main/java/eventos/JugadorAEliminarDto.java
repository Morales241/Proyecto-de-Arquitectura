package eventos;

/**
 *
 * @author tacot
 */
public class JugadorAEliminarDto extends JugadorBase{
    private static final long serialVersionUID = 1L;

    public JugadorAEliminarDto() {
    }

    public JugadorAEliminarDto(String nombre, int avatar) {
        super(nombre, avatar);
    }
    
    public JugadorAEliminarDto(NodoDto nodo, String codigo, String nombre, int avatar) {
        super(nodo, codigo, nombre, avatar);
    }
    
}
