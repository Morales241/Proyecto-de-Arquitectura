package pozo;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Pasar  A DOMINIO HEHHHE
 * Clase que representa el pozo
 * @author tacot
 */
public class Pozo {

    private final List<Ficha> fichas ;
    private int numeroFichasIniciales;
    
    /**
     * Constructor que inicializa la lista de fichas
     * 
     * @param numeroFichasIniciales
     */
    public Pozo(int numeroFichasIniciales) {
        fichas = new ArrayList<>();
        this.numeroFichasIniciales = numeroFichasIniciales;
        crearFichasPozo();
    }

    /**
     * Metodo que agrega al pozo la lista de 28 fichas 
     */
    private void crearFichasPozo() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                //en presentacion se le debe dar su refernecia de imagen
                String rutaImagen = String.format("/imgPartidaFichas/ficha%d_%d.png", i, j);
                Ficha ficha = new Ficha(i, j, rutaImagen);
                fichas.add(ficha);
            }
        }
    }

    /**
     * MMetodo que retorna una ficha al azar y elimina la ficha del pozo
     * @return Ficha al azar del pozo
     */
    public Ficha sacarFicha() {
        Random random = new Random();

        int posicion;

        Ficha ficha = null;

        if (!pozoVacío()) {
            posicion = random.nextInt(0, fichas.size());

            ficha = fichas.get(posicion);
            fichas.remove(posicion);
        }
        
        return ficha;
    }

    /**
     * Metodo que regresa una lista de fichas al azar del pozo
     * @return Lista con las fichas  al azar del pozo
     */
    public List<Ficha> repartirFichas(){
        List<Ficha> fichasARepartir = new ArrayList<>();
        
        for (int i = 0; i < numeroFichasIniciales; i++) {
            fichasARepartir.add(sacarFicha());
        }
        
        return fichasARepartir;
    }
    
    /**
     * Metodo que nos dice si el pozo esta vacío
     * @return true si el pozo esta vacío, false si contiene fichas
     */
    public boolean pozoVacío() {
        return fichas.isEmpty();
    }
    
    /**
     * Metodo para recibir fichas y agregarlas al pozo
     * @param fichasJugador lista de fichas de una jugador que se desconecte de la partida
     */
    public void recibirFichas(List<Ficha> fichasJugador){
        
        for (Ficha ficha : fichasJugador) {
            fichas.add(ficha);
        }
    }
}
