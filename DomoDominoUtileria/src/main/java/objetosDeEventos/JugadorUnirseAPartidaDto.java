/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosDeEventos;

/**
 *
 * @author tacot
 */
public class JugadorUnirseAPartidaDto extends JugadorConsulta {
    private static final long serialVersionUID = 1L;
    public JugadorUnirseAPartidaDto() {
    }

    public JugadorUnirseAPartidaDto(NodoDto nodo, String codigo, int avatar, String nombre) {
        super(nodo, codigo, avatar, nombre);
    }

}
