package Arreglo;

import Entidades.Arreglo;
import Entidades.Ficha;
import dtos.JugadorDto;

/**
 * Clase principal de Logica en la que inicia el juego
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class ArregloLogica {

    private JugadorDto jugador;
    private Arreglo arreglo;
    private int[][] tablero;

    public ArregloLogica() {
        this.tablero = arreglo.obtenerTablero();
    }

    public boolean colocarFichaHorizontal(Ficha ficha) {
        if (ficha.getLado1() == arreglo.getExtremoIzquierdo()) {
            tablero[arreglo.getExtremoIzquierdoFila()][arreglo.getExtremoIzquierdoColumna() - 1] = ficha.getLado1();
            tablero[arreglo.getExtremoIzquierdoFila()][arreglo.getExtremoIzquierdoColumna() - 2] = ficha.getLado2();
            arreglo.setExtremoIzquierdo(ficha.getLado2());
            arreglo.setExtremoIzquierdoColumna(arreglo.getExtremoIzquierdoColumna() - 2);
            return true;
        }
        if (ficha.getLado1() == arreglo.getExtremoDerecho()) {
            tablero[arreglo.getExtremoDerechoFila()][arreglo.getExtremoDerechoColumna() + 1] = ficha.getLado1();
            tablero[arreglo.getExtremoDerechoFila()][arreglo.getExtremoDerechoColumna() + 2] = ficha.getLado2();
            arreglo.setExtremoDerecho(ficha.getLado2());
            arreglo.setExtremoDerecho(arreglo.getExtremoDerechoColumna() + 2);
            return true;
        }
        if (ficha.getLado2() == arreglo.getExtremoIzquierdo()) {
            tablero[arreglo.getExtremoIzquierdoFila()][arreglo.getExtremoIzquierdoColumna() - 1] = ficha.getLado2();
            tablero[arreglo.getExtremoIzquierdoFila()][arreglo.getExtremoIzquierdoColumna() - 2] = ficha.getLado1();
            arreglo.setExtremoIzquierdo(ficha.getLado1());
            arreglo.setExtremoIzquierdoColumna(arreglo.getExtremoIzquierdoColumna() - 2);
            return true;
        }
        if (ficha.getLado2() == arreglo.getExtremoDerecho()) {
            tablero[arreglo.getExtremoDerechoFila()][arreglo.getExtremoDerechoColumna() + 1] = ficha.getLado2();
            tablero[arreglo.getExtremoDerechoFila()][arreglo.getExtremoDerechoColumna() + 2] = ficha.getLado1();
            arreglo.setExtremoDerecho(ficha.getLado1());
            arreglo.setExtremoDerecho(arreglo.getExtremoDerechoColumna() + 2);
            return true;
        }

        return false;
    }

}
