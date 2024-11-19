/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aviso;

import observers.IEventoAviso;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class AvisoModel {
    
    private IEventoAviso eventoAviso;
    private IObserver eventoCerrarPantalla;

    public AvisoModel() {
    }

    public void agregarEventoAviso(IEventoAviso eventoAviso) {
        this.eventoAviso = eventoAviso;
    }
    
    public void notificarEventoAviso(int numAviso){
        if (eventoAviso != null) {
            
            eventoAviso.notificarAlUsuario(numAviso);
            
        }
    }

    public void agregarEventoCerrarPantalla(IObserver eventoCerrarPantalla) {
        this.eventoCerrarPantalla = eventoCerrarPantalla;
    }
    
    public void notificarEventoCerrarPantalla(){
        if (eventoCerrarPantalla != null) {
            
            eventoCerrarPantalla.actualizar();
            
        }
    }
}
