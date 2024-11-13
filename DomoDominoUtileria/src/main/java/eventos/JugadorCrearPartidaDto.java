/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

/**
 *
 * @author tacot
 */
public class JugadorCrearPartidaDto extends JugadorConsulta{
    private static final long serialVersionUID = 1L;
    private int cantidadFichas;
    public JugadorCrearPartidaDto() {
    }

    public JugadorCrearPartidaDto(int cantidadFichas, NodoDto nodo, String codigo) {
        super(nodo, codigo);
        this.cantidadFichas = cantidadFichas;
    }

    public int getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }
}
