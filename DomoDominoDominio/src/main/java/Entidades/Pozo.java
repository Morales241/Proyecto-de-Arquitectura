package Entidades;

import Entidades.Ficha;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Monton de fichas sin repartir. Instancia unica porque hay un solo pozo por juego.
 */
public class Pozo {

     private static Pozo instancia; 
     private final ArrayList<Ficha> fichas;

     private Pozo() {
          fichas = new ArrayList<>();
     }

     public static Pozo obtenerInstancia() {
          if (instancia == null) {
               instancia = new Pozo();
          }
          return instancia;
     }

    public ArrayList<Ficha> obtenerFichas() {
          return fichas;
     }
    
}
