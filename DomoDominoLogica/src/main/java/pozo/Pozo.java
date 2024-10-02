package pozo;

import com.mycompany.domodominopersistencia.Ficha;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
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
    }

    /**
     * Metodo que agrega al pozo la lista de 28 fichas 
     */
    public void crearFichasPozo() {

        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {

                fichas.add(new Ficha(i, j));

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
        List<Ficha> fichasJugador = new ArrayList<>();
        
        for (int i = 0; i < numeroFichasIniciales; i++) {
            fichasJugador.add(sacarFicha());
        }
        
        return fichasJugador;
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
