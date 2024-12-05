/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadasInterfaz;

import Entidades.Arreglo;
import Entidades.Ficha;
import dtos.FichaDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IArregloFachada {

    public int[][] obtenerTablero();

    public boolean estaVacio(int fila, int columna);

    public Arreglo obtenerArreglo();

    public boolean verificarPosiblesMovimientos(List<FichaDto> fichasJugador);

    public boolean colocarFicha(FichaDto ficha, boolean extremo, String direccion);

    public boolean colocarFichaIzquierda(FichaDto ficha, boolean extremo);

    public boolean colocarFichaDerecha(FichaDto ficha, boolean extremo);

    public boolean colocarFichaArriba(FichaDto ficha, boolean extremo);

    public boolean colocarFichaAbajo(FichaDto ficha, boolean extremo);

    public void actualizarExtremos(boolean extremo, int numExtremo, int columna, int fila);

    public void actualizarExtremoIzquierdo(int numExtremo, int columna, int fila);

    public void actualizarExtremoDerecho(int numExtremo, int columna, int fila);
}
