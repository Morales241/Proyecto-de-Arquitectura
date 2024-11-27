/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadasInterfaz;

import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public interface ICrearPartidaFachada {
    
    public void agregarIEventoCrearPartida(IEventoCrearPartida listener);
    
     public void agregarIEventoRegresar(IObserver listener);
}
