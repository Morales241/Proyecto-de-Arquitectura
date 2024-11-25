package objetosDeEventos;

import dtos.FichaDto;
import dtos.JugadorDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class SetUpDto {
    private List<JugadorDto> ordenDeJugadoresEnPartida;
    private final FichaDto[][] fichasDeLosJugadores;

    public SetUpDto() {
        this.fichasDeLosJugadores  = new FichaDto[3][7];
        this.ordenDeJugadoresEnPartida = new ArrayList<>();
    }

    public List<FichaDto> getFichasDeJugador(JugadorDto jugador){
        
        List<FichaDto> fichasDeJugador = new ArrayList<>();
        
        int posicionJugador = ordenDeJugadoresEnPartida.indexOf(jugador);
        
        for (int i = 0; i < 7; i++) {
            fichasDeJugador.add(fichasDeLosJugadores[posicionJugador][i]);
        }
        
        return fichasDeJugador;
    }
    
    public List<JugadorDto> getOrdenDeJugadoresEnPartida() {
        return ordenDeJugadoresEnPartida;
    }

    public void setOrdenDeJugadoresEnPartida(List<JugadorDto> ordenDeJugadoresEnPartida) {
        this.ordenDeJugadoresEnPartida = ordenDeJugadoresEnPartida;
    }
    
}
