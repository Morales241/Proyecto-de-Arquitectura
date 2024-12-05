package eventos;

import dtos.FichaDto;
import dtos.JugadorDto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tacot
 */
public class PonerFichaDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private FichaDto ficha;
    private boolean extremo;
    private int columna;
    private int Fila;
    private String direccion;
    private JugadorDto jugador;
    private List<JugadorBase> compañeros;

    public PonerFichaDto() {
    }

     public PonerFichaDto(FichaDto ficha, boolean extremo, String direccion, JugadorDto jugador) {
          this.ficha = ficha;
          this.extremo = extremo;
          this.direccion = direccion;
          this.jugador = jugador;
     }

     public PonerFichaDto(FichaDto ficha, boolean extremo, String direccion) {
          this.ficha = ficha;
          this.extremo = extremo;
          this.direccion = direccion;
     }

    public List<JugadorBase> getCompañeros() {
        return compañeros;
    }

    public void setCompañeros(List<JugadorBase> compañeros) {
        this.compañeros = compañeros;
    }
   
     public boolean getExtremo() {
          return extremo;
     }

     public void setExtremo(boolean extremo) {
          this.extremo = extremo;
     }

     public String getDireccion() {
          return direccion;
     }

     public void setDireccion(String direccion) {
          this.direccion = direccion;
     }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
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
