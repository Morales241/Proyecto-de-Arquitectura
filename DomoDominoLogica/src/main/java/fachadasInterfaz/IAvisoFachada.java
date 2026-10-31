/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadasInterfaz;

import eventos.IEventoCerrarAviso;

/**
 *
 * @author Jesus Morales
 */
public interface IAvisoFachada {
    public void agregarEventoCerrarPantalla(IEventoCerrarAviso eventoCerrarPantalla);
    
    public void mostrarAviso(String aviso);
}
