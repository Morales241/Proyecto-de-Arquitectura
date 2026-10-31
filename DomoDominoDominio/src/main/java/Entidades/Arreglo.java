package Entidades;

import Entidades.Ficha;

/**
 *
 * @author favel
 */
/**
 * Tablero del juego: matriz de Fichas con cursores a los 2 extremos.
 * Una celda en null esta vacia; cada partida usa su propia instancia.
 */
public class Arreglo {

    private Ficha[][] tablero;
    private int extremoIzquierdo, extremoDerecha;
    private int extremo1Columna, extremo1Fila;
    private int extremo2Columna, extremo2Fila;

    public Arreglo() {
        tablero = new Ficha[10][10];
        reiniciarTablero();
        extremo1Columna = 5;
        extremo1Fila = 5;
        extremo2Columna = 5;
        extremo2Fila = 5;
    }

    public void reiniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = null;
            }
        }
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

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }

    public int getExtremoIzquierdo() {
        return extremoIzquierdo;
    }

    public void setExtremoIzquierdo(int extremoIzquierdo) {
        this.extremoIzquierdo = extremoIzquierdo;
    }

    public int getExtremoDerecha() {
        return extremoDerecha;
    }

    public void setExtremoDerecha(int extremoDerecha) {
        this.extremoDerecha = extremoDerecha;
    }

    public int getExtremo1Columna() {
        return extremo1Columna;
    }

    public void setExtremo1Columna(int extremo1Columna) {
        this.extremo1Columna = extremo1Columna;
    }

    public int getExtremo1Fila() {
        return extremo1Fila;
    }

    public void setExtremo1Fila(int extremo1Fila) {
        this.extremo1Fila = extremo1Fila;
    }

    public int getExtremo2Columna() {
        return extremo2Columna;
    }

    public void setExtremo2Columna(int extremo2Columna) {
        this.extremo2Columna = extremo2Columna;
    }

    public int getExtremo2Fila() {
        return extremo2Fila;
    }

    public void setExtremo2Fila(int extremo2Fila) {
        this.extremo2Fila = extremo2Fila;
    }

}
