package Arreglo;

import Entidades.Arreglo;
import Entidades.Ficha;
import dtos.ArregloDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import fachadas.ArregloFachada;
import java.util.List;

/**
 * Clase principal de Logica en la que inicia el juego
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LogicaArreglo implements ILogicaArreglo {

    private final ArregloFachada arregloFachada;

    public LogicaArreglo(ArregloFachada arregloFachada) {
        this.arregloFachada = arregloFachada;
    }

    @Override
    public int[][] obtenerTablero() {
        return arregloFachada.obtenerTablero();
    }

    @Override
    public boolean estaVacio(int fila, int columna) {
        return arregloFachada.estaVacio(fila, columna);
    }

    @Override
    public boolean verificarPosiblesMovimientos(List<FichaDto> fichasJugador) {
        return arregloFachada.verificarPosiblesMovimientos(fichasJugador);
    }

    @Override
    public boolean colocarFicha(FichaDto ficha, boolean extremo, String direccion) {
        return arregloFachada.colocarFicha(ficha, extremo, direccion);
    }

    @Override
    public boolean colocarFichaIzquierda(FichaDto ficha, boolean extremo) {
        return arregloFachada.colocarFichaIzquierda(ficha, extremo);
    }

    @Override
    public boolean colocarFichaDerecha(FichaDto ficha, boolean extremo) {
        return arregloFachada.colocarFichaDerecha(ficha, extremo);
    }

    @Override
    public boolean colocarFichaArriba(FichaDto ficha, boolean extremo) {
        return arregloFachada.colocarFichaArriba(ficha, extremo);
    }

    @Override
    public boolean colocarFichaAbajo(FichaDto ficha, boolean extremo) {
        return arregloFachada.colocarFichaAbajo(ficha, extremo);
    }

    @Override
    public void actualizarExtremos(boolean extremo, int numExtremo, int columna, int fila) {
        arregloFachada.actualizarExtremoDerecho(numExtremo, columna, fila);
    }

    @Override
    public void actualizarExtremoIzquierdo(int numExtremo, int columna, int fila) {
        arregloFachada.actualizarExtremoIzquierdo(numExtremo, columna, fila);
    }

    @Override
    public void actualizarExtremoDerecho(int numExtremo, int columna, int fila) {
        arregloFachada.actualizarExtremoDerecho(numExtremo, columna, fila);
    }

    @Override
    public ArregloDto convertirEntidad(Arreglo arreglo) {
        return new ArregloDto(
            arreglo.getTablero(),
            arreglo.getExtremoIzquierdo(),
            arreglo.getExtremoDerecha(),
            arreglo.getExtremo1Columna(),
            arreglo.getExtremo1Fila(),
            arreglo.getExtremo2Columna(),
            arreglo.getExtremo2Fila()
        );
    }

    @Override
    public Arreglo obtenerArreglo() {
        return arregloFachada.obtenerArreglo();
    }
}
