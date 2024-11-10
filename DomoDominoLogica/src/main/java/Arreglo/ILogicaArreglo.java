/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Arreglo;

import Entidades.Ficha;
import java.util.List;

public interface ILogicaArreglo {
    
    public int[][] obtenerTablero();

    public boolean estaVacio(int fila, int columna);
    
    public boolean verificarPosiblesMovimientos(List<Ficha> fichasJugador);
    
    public boolean colocarFicha(Ficha ficha, boolean extremo, String direccion);
    
    public boolean colocarFichaIzquierda(Ficha ficha, boolean extremo);
    
    public boolean colocarFichaDerecha(Ficha ficha, boolean extremo);
    
    public boolean colocarFichaArriba(Ficha ficha, boolean extremo);
    
    public boolean colocarFichaAbajo(Ficha ficha, boolean extremo);
    
    public void actualizarExtremos(boolean extremo, int numExtremo, int columna, int fila);
    
    public void actualizarExtremoIzquierdo(int numExtremo, int columna, int fila);
    
    public void actualizarExtremoDerecho(int numExtremo, int columna, int fila);
}

