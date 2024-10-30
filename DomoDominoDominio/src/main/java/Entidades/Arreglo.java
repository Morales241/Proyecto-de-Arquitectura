package Entidades;

import Entidades.Ficha;
import java.util.List;

/**
 *
 * @author favel
 */
public class Arreglo {

     private int[][] tablero;
     private int extremoIzquierdo, extremoDerecha;
     private int extremo1Columna, extremo1Fila;
     private int extremo2Columna, extremo2Fila;

     public Arreglo(int ancho, int alto) {
          tablero = new int[ancho][alto];
          reiniciarTablero();
          extremo1Columna = ancho / 2;
          extremo1Fila = alto / 2;
          extremo2Columna = ancho / 2;
          extremo2Fila = alto / 2;
     }

     public boolean estaVacio(int fila, int columna) {
          return tablero[fila][columna] == -1;
     }

     /**
      * Verifica si el jugador tiene alguna ficha que coincida con los extremos.
      * Si no tiene fichas válidas, muestra un mensaje de aviso.
      *
      * @param fichasJugador Lista de fichas del jugador.
      * @return true si el jugador tiene fichas válidas, false en caso
      * contrario.
      */
     public boolean verificarPosiblesMovimientos(List<Ficha> fichasJugador) {
          for (Ficha ficha : fichasJugador) {

               if (ficha.getLado1() == extremoIzquierdo || ficha.getLado2() == extremoIzquierdo
                       || ficha.getLado1() == extremoDerecha || ficha.getLado2() == extremoDerecha) {
                    return true;
               }
          }
          return false;
     }

     public boolean colocarFichaExtremoIzquierdo(Ficha ficha, String direccion) {

          //fichas mulas
          if (ficha.esMula()) {
               switch (direccion) {
                    case "izquierda":
                         colocarFichaExtremoIzquierdoMulaHaciaIzquierda(ficha);
                         break;
                    case "arriba":
                         colocarFichaExtremoIzquierdoMulaHaciaArriba(ficha);
                         break;
                    case "derecha":
                         colocarFichaExtremoIzquierdoMulaHaciaDerecha(ficha);
                         break;
                    case "abajo":
                         colocarFichaExtremoIzquierdoMulaHaciaAbajo(ficha);
                         break;
               }
          }

          if (ficha.getLado1() == extremoIzquierdo) {
               switch (direccion){
                    case "izquierda":
                         colocarFichaExtremoIzquierdoLado1HaciaIzquierda(ficha);
                         break;
                    case "arriba":
                         colocarFichaExtremoIzquierdoLado1HaciaArriba(ficha);
                         break;
                    case "derecha":
                         colocarFichaExtremoIzquierdoLado1HaciaDerecha(ficha);
                         break;
                    case "abajo":
                         colocarFichaExtremoIzquierdoLado1HaciaAbajo(ficha);
                         break;
               }
          }
          
          if (ficha.getLado2() == extremoIzquierdo) {
               switch (direccion){
                    case "izquierda":
                         colocarFichaExtremoIzquierdoLado2HaciaIzquierda(ficha);
                         break;
                    case "arriba":
                         colocarFichaExtremoIzquierdoLado2HaciaArriba(ficha);
                         break;
                    case "derecha":
                         colocarFichaExtremoIzquierdoLado2HaciaDerecha(ficha);
                         break;
                    case "abajo":
                         colocarFichaExtremoIzquierdoLado2HaciaAbajo(ficha);
                         break;
               }
          }
          
          return false;
     }

     public boolean colocarFichaExtremoIzquierdoMulaHaciaIzquierda(Ficha ficha) {
          if (ficha.getLado1() == extremoIzquierdo && extremo1Columna - 3 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1) {
               System.out.println("Izquierda: Mula hacia la izquierda");
               tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
               extremoIzquierdo = ficha.getLado2();
               extremo1Columna -= 1;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoMulaHaciaArriba(Ficha ficha) {
          if (ficha.getLado1() == extremoIzquierdo && extremo1Fila - 3 < tablero.length && tablero[extremo1Fila - 1][extremo1Columna] == -1) {
               System.out.println("Izquierda: Mula hacia arriba");
               tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
               extremoIzquierdo = ficha.getLado2();
               extremo1Fila -= 1;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoMulaHaciaDerecha(Ficha ficha) {
          if (ficha.getLado1() == extremoIzquierdo && extremo1Columna + 3 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1) {
                    System.out.println("Izquierda: Mula hacia la derecha");
                    tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado1();
                    extremoIzquierdo = ficha.getLado2();
                    extremo1Columna += 1;
                    return true;
               }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoMulaHaciaAbajo(Ficha ficha){
          if (ficha.getLado1() == extremoIzquierdo && extremo1Fila + 3 > 0 && tablero[extremo1Fila + 1][extremo1Columna] == -1) {
                    System.out.println("Izquierda: Mula hacia abajo");
                    tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado1();
                    extremoIzquierdo = ficha.getLado2();
                    extremo1Fila += 1;
                    return true;
               }
          return false;
     }
     
     public boolean colocarFichaExtremoIzquierdoLado1HaciaIzquierda(Ficha ficha){
          if (extremo1Columna - 2 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1 && tablero[extremo1Fila][extremo1Columna - 2] == -1) {
               System.out.println("Izquierda: Horizontal hacia la izquierda");
               tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado1();
               tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado2();
               extremoIzquierdo = ficha.getLado2();
               extremo1Columna -= 2;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoLado1HaciaArriba(Ficha ficha){
          if (extremo1Fila - 2 < tablero.length && tablero[extremo1Fila - 1][extremo1Columna] == -1 && tablero[extremo1Fila - 2][extremo1Columna] == -1) {
               System.out.println("Izquierda: vertical hacia arriba");
               tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado1();
               tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado2();
               extremoIzquierdo = ficha.getLado2();
               extremo1Fila -= 2;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoLado1HaciaDerecha(Ficha ficha){
          if (extremo1Columna + 2 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1 && tablero[extremo1Fila][extremo1Columna + 2] == -1) {
               System.out.println("Izquierda: horizontal hacia la derecha");
               tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado1();
               tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado2();
               extremoIzquierdo = ficha.getLado2();
               extremo1Columna += 2;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoLado1HaciaAbajo(Ficha ficha){
          if (extremo1Fila + 2 > 0 && tablero[extremo1Fila + 1][extremo1Columna] == -1 && tablero[extremo1Fila + 2][extremo1Columna] == -1) {
               System.out.println("Izquierda: vertical hacia abajo");
               tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado1();
               tablero[extremo1Fila + 2][extremo1Columna] = ficha.getLado2();
               extremoIzquierdo = ficha.getLado2();
               extremo1Fila += 2;
               return true;
          }
          return false;
     }
     
     public boolean colocarFichaExtremoIzquierdoLado2HaciaIzquierda(Ficha ficha){
          if (extremo1Columna - 2 > 0 && tablero[extremo1Fila][extremo1Columna - 1] == -1 && tablero[extremo1Fila][extremo1Columna - 2] == -1) {
               System.out.println("Izquierda: Horizontal hacia la izquierda");
               tablero[extremo1Fila][extremo1Columna - 1] = ficha.getLado2();
               tablero[extremo1Fila][extremo1Columna - 2] = ficha.getLado1();
               extremoIzquierdo = ficha.getLado1();
               extremo1Columna -= 2;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoLado2HaciaArriba(Ficha ficha){
          if (ficha.getLado2() == extremoIzquierdo && extremo1Fila - 2 < tablero.length && tablero[extremo1Fila - 1][extremo1Columna] == -1 && tablero[extremo1Fila - 2][extremo1Columna] == -1) {
               System.out.println("Izquierda: vertical hacia arriba");
               tablero[extremo1Fila - 1][extremo1Columna] = ficha.getLado2();
               tablero[extremo1Fila - 2][extremo1Columna] = ficha.getLado1();
               extremoIzquierdo = ficha.getLado1();
               extremo1Fila -= 2;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoLado2HaciaDerecha(Ficha ficha){
          if (ficha.getLado2() == extremoIzquierdo && extremo1Columna + 2 < tablero[0].length && tablero[extremo1Fila][extremo1Columna + 1] == -1 && tablero[extremo1Fila][extremo1Columna + 2] == -1) {
               System.out.println("Izquierda: horizontal hacia la derecha");
               tablero[extremo1Fila][extremo1Columna + 1] = ficha.getLado2();
               tablero[extremo1Fila][extremo1Columna + 2] = ficha.getLado1();
               extremoIzquierdo = ficha.getLado1();
               extremo1Columna += 2;
               return true;
          }
          return false;
     }
     public boolean colocarFichaExtremoIzquierdoLado2HaciaAbajo(Ficha ficha){
          if (ficha.getLado2() == extremoIzquierdo && extremo1Fila + 2 > 0 && tablero[extremo1Fila + 1][extremo1Columna] == -1 && tablero[extremo1Fila + 2][extremo1Columna] == -1) {
               System.out.println("Izquierda: vertical hacia abajo");
               tablero[extremo1Fila + 1][extremo1Columna] = ficha.getLado2();
               tablero[extremo1Fila + 2][extremo1Columna] = ficha.getLado1();
               extremoIzquierdo = ficha.getLado1();
               extremo1Fila += 2;
               return true;
          }
          return false;
     }
     
     public boolean colocarFichaExtremoDerecho(Ficha ficha, String direccion) {

          return false;
     }
     
     

     public int obtenerFicha(int fila, int columna) {
          return tablero[fila][columna];
     }

     public void reiniciarTablero() {
          for (int i = 0; i < tablero.length; i++) {
               for (int j = 0; j < tablero[i].length; j++) {
                    tablero[i][j] = 0;
               }
          }
     }

     public int[][] obtenerTablero() {
          return tablero;
     }

     public int getExtremo1() {
          return extremoIzquierdo;
     }

     public void setExtremo1(int extremoIzquierdo) {
          this.extremoIzquierdo = extremoIzquierdo;
     }

     public int getExtremo2() {
          return extremoDerecha;
     }

     public void setExtremo2(int extremoDerecha) {
          this.extremoDerecha = extremoDerecha;
     }
}
