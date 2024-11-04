package eventos;

import dtos.FichaDto;
import dtos.JugadorDto;

/**
 *
 * @author tacot
 */
public class PonerFichaDto {
    private FichaDto ficha;
    private JugadorDto jugador;

    public PonerFichaDto() {
    }

    public PonerFichaDto(FichaDto ficha, JugadorDto jugador) {
        this.ficha = ficha;
        this.jugador = jugador;
    }

    public FichaDto getFicha() {
        return ficha;
    }

    public void setFicha(FichaDto ficha) {
        this.ficha = ficha;
    }

    public JugadorDto getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDto jugador) {
        this.jugador = jugador;
    }
    
    
}
