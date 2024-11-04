package eventos;

import dtos.FichaDto;
import dtos.JugadorDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class SetUpDto {
    private final Object[][] fichasDeLosJugadores;
    private List<JugadorDto> ordenDeJugadoresEnPartida;

    public SetUpDto() {
        this.fichasDeLosJugadores  = new Object[3][2];
        this.ordenDeJugadoresEnPartida = new ArrayList<>();
    }

    public List<FichaDto> getFichasDeJugador(JugadorDto jugador){
        List<FichaDto> fichasDeJugador;
        
        for (int i = 0; i < 3; i++) {
            
        }
        
        return null;
    }
    
    
    
    public List<JugadorDto> getOrdenDeJugadoresEnPartida() {
        return ordenDeJugadoresEnPartida;
    }

    public void setOrdenDeJugadoresEnPartida(List<JugadorDto> ordenDeJugadoresEnPartida) {
        this.ordenDeJugadoresEnPartida = ordenDeJugadoresEnPartida;
    }
    
    
}
