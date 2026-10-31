/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import fachadasInterfaz.ICrearPartidaFachada;
import crearPartida.CrearPartidaModel;
import eventos.IEventoCrearPartida;
import eventos.IEventoRegresar;

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
    public void agregarIEventoRegresar(IEventoRegresar listener) {
        crearMesaModel.agregarIEventoRegresar(listener);
        
    }
    
}
