package Entidades;

import Entidades.Ficha;

/**
 *
 * @author favel
 */
public class Arreglo {

    private int[][] tablero;

    public Arreglo(int ancho, int alto) {
        tablero = new int[ancho][alto];
        reiniciarTablero();
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == 0;
    }

//    //Esto no va aqui
//    public boolean colocarFichaHorizontal(Ficha ficha, int fila, int columna) {
//        if (ficha.esMula()) {
//            if (estaVacio(fila, columna)) {
//                tablero[fila][columna] = ficha.getLado1();
//                return true;
//            }
//        } else {
//            if (estaVacio(fila, columna) && estaVacio(fila, columna + 1)) {
//                tablero[fila][columna] = ficha.getLado1();
//                tablero[fila][columna + 1] = ficha.getLado2();
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //Este tampoco va aqui
//    public boolean colocarFichaVertical(Ficha ficha, int fila, int columna) {
//        if (ficha.esMula()) {
//            if (estaVacio(fila, columna)) {
//                tablero[fila][columna] = ficha.getLado1();
//                return true;
//            }
//        } else {
//            if (estaVacio(fila, columna) && estaVacio(fila, columna + 1)) {
//                tablero[fila][columna] = ficha.getLado1();
//                tablero[fila + 1][columna] = ficha.getLado2();
//                return true;
//            }
//        }
//        return false;
//    }

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
