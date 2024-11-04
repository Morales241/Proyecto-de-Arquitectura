
package Entidades;

import Entidades.Ficha;

/**
 *
 * @author favel
 */
public class Arreglo {

    private int[][] tablero;
    private int extremoIzquierdo, extremoDerecho;
    private int extremoIzquierdoColumna, extremoIzquierdoFila;
    private int extremoDerechoColumna, extremoDerechoFila;

    public Arreglo() {
        tablero = new int[17][30];
        reiniciarTablero();
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == 0; 
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

    public int getExtremoIzquierdo() {
        return extremoIzquierdo;
    }

    public void setExtremoIzquierdo(int extremoIzquierdo) {
        this.extremoIzquierdo = extremoIzquierdo;
    }

    public int getExtremoDerecho() {
        return extremoDerecho;
    }

    public void setExtremoDerecho(int extremoDerecha) {
        this.extremoDerecho = extremoDerecha;
    }

    public int getExtremoIzquierdoColumna() {
        return extremoIzquierdoColumna;
    }

    public void setExtremoIzquierdoColumna(int extremoIzquierdoColumna) {
        this.extremoIzquierdoColumna = extremoIzquierdoColumna;
    }

    public int getExtremoIzquierdoFila() {
        return extremoIzquierdoFila;
    }

    public void setExtremoIzquierdoFila(int extremoIzquierdoFila) {
        this.extremoIzquierdoFila = extremoIzquierdoFila;
    }

    public int getExtremoDerechoColumna() {
        return extremoDerechoColumna;
    }

    public void setExtremoDerechoColumna(int extremoDerechoColumna) {
        this.extremoDerechoColumna = extremoDerechoColumna;
    }

    public int getExtremoDerechoFila() {
        return extremoDerechoFila;
    }

    public void setExtremoDerechoFila(int extremoDerechoFila) {
        this.extremoDerechoFila = extremoDerechoFila;
    }
    
    
}
