package dtos;

import dtos.FichaDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author favel
 */

public class JugadorDto {
    private String nombre;
    private final List<FichaDto> fichas; 
   private int numeroFichasIniciales = 7;
    public JugadorDto(String nombre) {
        this.nombre = nombre;
        this.fichas = new ArrayList<>();
        crearFichasPozo();
        System.out.println(fichas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<FichaDto> getFichas() {
        return fichas;
    }

    public void agregarFicha(FichaDto ficha) {
        this.fichas.add(ficha);
    }

    public void agregarFichas(List<FichaDto> fichas) {
        this.fichas.addAll(fichas);
    }

    public void mostrarFichas() {
        for (FichaDto ficha : fichas) {
            System.out.println(ficha);
        }
    }
      /**
       * Método que agrega al pozo la lista de 28 fichas
       */
      private void crearFichasPozo() {
            for (int i = 0; i <= 6; i++) {
                  for (int j = i; j <= 6; j++) {                      
                              FichaDto ficha = new FichaDto(i, j);
                              fichas.add(ficha);                            
                        }
                  }
            }
      
    /**
     * MMetodo que retorna una ficha al azar y elimina la ficha del pozo
     * @return Ficha al azar del pozo
     */
    public FichaDto sacarFicha() {
        Random random = new Random();

        int posicion;

        FichaDto ficha = null;

        if (!pozoVacío()) {
            posicion = random.nextInt(0, fichas.size());
            System.out.println(posicion);
            ficha = fichas.get(posicion);
            System.out.println(ficha);
            fichas.remove(posicion);
        }
        
        return ficha;
    }
     
  public List<FichaDto> repartirFichas(){
    List<FichaDto> fichasARepartir = new ArrayList<>();

    // Repartir primero la ficha mula
    fichasARepartir.add(sacarFichaMula());

    // Repartir las 6 fichas restantes
    for (int i = 0; i < numeroFichasIniciales - 1; i++) {  // Restar 1 porque ya se repartió la mula
        fichasARepartir.add(sacarFicha());
    }

    // Verificar las fichas repartidas
    for (FichaDto ficha : fichasARepartir) {
        System.out.println(ficha); // Esto debería mostrar información sobre cada ficha
    }

    return fichasARepartir;
}


    public FichaDto sacarFichaMula() {
    

        int posicion;

        FichaDto ficha = null;

        if (!pozoVacío()) {
            posicion =27;
            System.out.println(posicion);
            ficha = fichas.get(posicion);
            System.out.println(ficha);
            fichas.remove(posicion);
        }
        
        return ficha;
    }
    /**
     * Metodo que nos dice si el pozo esta vacío
     * @return true si el pozo esta vacío, false si contiene fichas
     */
    public boolean pozoVacío() {
        return fichas.isEmpty();
    }
   
}
