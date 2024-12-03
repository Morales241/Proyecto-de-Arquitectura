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
    private String mensaje;
    private int jugadores;

    public AvisoModel() {
    }

    public void agregarEventoAviso(IEventoAviso eventoAviso) {
        this.eventoAviso = eventoAviso;
    }
    
    public void notificarEventoAviso(String mensaje){
        if (eventoAviso != null) {
            
            eventoAviso.notificarAlUsuario(mensaje);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
