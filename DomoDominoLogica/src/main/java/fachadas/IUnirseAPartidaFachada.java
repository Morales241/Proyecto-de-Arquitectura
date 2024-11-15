/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadas;

import observers.IEventoAgregarJugadorAPartida;
import observers.IObserver;

/**
 *
 * @author favel
 */
public interface IUnirseAPartidaFachada {
     
     public void agregarIEventoUnirseAPartida(IEventoAgregarJugadorAPartida listener);
     
     public void agregarIEventoRegresar(IObserver listener);
}
