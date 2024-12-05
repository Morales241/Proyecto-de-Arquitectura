package Entidades;

import Entidades.Ficha;

/**
 *
 * @author favel
 */
public class Arreglo {

    private int[][] tablero;
    private int extremoIzquierdo, extremoDerecha;
    private int extremo1Columna, extremo1Fila;
    private int extremo2Columna, extremo2Fila;

    private static Arreglo instanciaUnica;

    public Arreglo() {
        tablero = new int[10][10];
        reiniciarTablero();
        extremo1Columna = 5;
        extremo1Fila = 5;
        extremo2Columna = 5;
        extremo2Fila = 5;
    }

    public static Arreglo getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Arreglo();
        }
        return instanciaUnica;
    }

    public void reiniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = -1;
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

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
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
