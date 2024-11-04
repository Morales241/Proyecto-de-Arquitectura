package eventos;

import dtos.FichaDto;
import dtos.JugadorDto;

/**
 *
 * @author tacot
 */
public class PonerFichaDto {
    private FichaDto ficha;
    private String extremo, direccion;
    private JugadorDto jugador;

    public PonerFichaDto() {
    }

     public PonerFichaDto(FichaDto ficha, String extremo, String direccion, JugadorDto jugador) {
          this.ficha = ficha;
          this.extremo = extremo;
          this.direccion = direccion;
          this.jugador = jugador;
     }

     public String getExtremo() {
          return extremo;
     }

     public void setExtremo(String extremo) {
          this.extremo = extremo;
     }

     public String getDireccion() {
          return direccion;
     }

     public void setDireccion(String direccion) {
          this.direccion = direccion;
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
