/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadasInterfaz;

import observers.IObserver;

/**
 *
 * @author Jesus Morales
 */
public interface IAvisoFachada {
    public void agregarEventoCerrarPantalla(IObserver eventoCerrarPantalla);
    
    public void mostrarAviso(String aviso);
}
