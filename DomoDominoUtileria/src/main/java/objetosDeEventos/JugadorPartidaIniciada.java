
package objetosDeEventos;

import dtos.FichaDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public class JugadorPartidaIniciada extends JugadorConsulta{
    private static final long serialVersionUID = 1L;
    private List<FichaDto> fichas;

    public JugadorPartidaIniciada(NodoDto nodo, String codigo, int avatar, String nombre) {
        super(nodo, codigo, avatar, nombre);
    }

    public JugadorPartidaIniciada(JugadorCrearPartidaDto jugadorCrearPartidaDto) {
    super(jugadorCrearPartidaDto.getNodo(),jugadorCrearPartidaDto.getCodigo(), jugadorCrearPartidaDto.getAvatar(), jugadorCrearPartidaDto.getNombre());
        
    }
    
    public JugadorPartidaIniciada(JugadorUnirseAPartidaDto jugadorUnirseAPartidaDto) {
    super(jugadorUnirseAPartidaDto.getNodo(),jugadorUnirseAPartidaDto.getCodigo(), jugadorUnirseAPartidaDto.getAvatar(), jugadorUnirseAPartidaDto.getNombre());
        
    }
    
    public List<FichaDto> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaDto> fichas) {
        this.fichas = fichas;
    }
    
    
    
}
