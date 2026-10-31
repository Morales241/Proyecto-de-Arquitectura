/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import aviso.AvisoModel;
import fachadasInterfaz.IAvisoFachada;
import eventos.IEventoCerrarAviso;

/**
 *
 * @author Jesus Morales
 */
public class AvisoFachada implements IAvisoFachada{

    private final AvisoModel avisoModel;

    public AvisoFachada(AvisoModel aModel) {
        this.avisoModel = aModel;
    }
    
    @Override
    public void agregarEventoCerrarPantalla(IEventoCerrarAviso eventoCerrarPantalla) {
        avisoModel.agregarEventoCerrarPantalla(eventoCerrarPantalla);
    }

    @Override
    public void mostrarAviso(String aviso) {
        avisoModel.notificarEventoAviso(aviso);
        
    }
    
}
