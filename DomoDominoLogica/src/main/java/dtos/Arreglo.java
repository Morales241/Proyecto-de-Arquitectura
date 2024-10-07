/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import pozo.Ficha;

/**
 *
 * @author favel
 */
public class Arreglo {

    private int[][] tablero;

    public Arreglo() {
        tablero = new int[17][30];
        reiniciarTablero();
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == 0; 
    }

        public boolean colocarFichaHorizontal(Ficha ficha, int fila, int columna) {
        if (estaVacio(fila, columna) && estaVacio(fila, columna + 1)) {
            tablero[fila][columna] = ficha.getLado1(); 
            tablero[fila][columna + 1] = ficha.getLado2(); 
            return true;
        }
        return false;
    }
    
    public boolean colocarFichaVertical(Ficha ficha, int fila, int columna) {
        if (estaVacio(fila, columna) && estaVacio(fila, columna + 1)) {
            tablero[fila][columna] = ficha.getLado1(); 
            tablero[fila + 1][columna] = ficha.getLado2(); 
            return true;
        }
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
}
