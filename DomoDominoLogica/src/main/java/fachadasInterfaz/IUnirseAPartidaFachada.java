/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadasInterfaz;

import eventos.IEventoAgregarJugadorAPartida;
import eventos.IEventoRegresar;

/**
 *
 * @author favel
 */
public interface IUnirseAPartidaFachada {
     
     public void agregarIEventoUnirseAPartida(IEventoAgregarJugadorAPartida listener);
     
     public void agregarIEventoRegresar(IEventoRegresar listener);
}
