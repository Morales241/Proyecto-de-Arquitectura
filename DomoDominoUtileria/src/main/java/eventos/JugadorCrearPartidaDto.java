package eventos;
/**
 *
 * @author tacot
 */
public class JugadorCrearPartidaDto extends JugadorBase {

    private static final long serialVersionUID = 1L;
    private int fichasIniciales;

    public JugadorCrearPartidaDto(int fichasIniciales, NodoDto nodo, String codigo, String nombre, int avatar) {
        super(nodo, codigo, nombre, avatar);
        this.fichasIniciales = fichasIniciales;
    }

}
