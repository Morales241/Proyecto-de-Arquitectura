
package objetosDeEventos;

/**
 *
 * @author tacot
 */
public class JugadorCrearPartidaDto extends JugadorConsulta{
    private static final long serialVersionUID = 1L;
    private int cantidadFichas;
    public JugadorCrearPartidaDto() {
    }

    public JugadorCrearPartidaDto(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    public JugadorCrearPartidaDto(int cantidadFichas, NodoDto nodo, String codigo, int avatar, String nombre) {
        super(nodo, codigo, avatar, nombre);
        this.cantidadFichas = cantidadFichas;
    }

    public int getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }
}
