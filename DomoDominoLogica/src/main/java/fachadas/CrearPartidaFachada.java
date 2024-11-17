/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import crearPartida.CrearPartidaModel;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class CrearPartidaFachada implements ICrearPartidaFachada {

    private final CrearPartidaModel crearMesaModel;

    public CrearPartidaFachada(CrearPartidaModel crearMesaModel) {
        this.crearMesaModel = crearMesaModel;
    }
    
    
    @Override
    public void agregarIEventoCrearPartida(IEventoCrearPartida listener) {
        this.crearMesaModel.agregarIEventoCrearPartida(listener);
    }

    @Override
    public void agregarIEventoRegresar(IObserver listener) {
        crearMesaModel.agregarIEventoRegresar(listener);
        
    }
    
}
