/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import fachadasInterfaz.IUnirseAPartidaFachada;
import eventos.IEventoAgregarJugadorAPartida;
import eventos.IEventoRegresar;
import unirseAPartida.UnirseAPartidaModel;

/**
 *
 * @author favel
 */
public class UnirseAPartidaFachada implements IUnirseAPartidaFachada {

     private final UnirseAPartidaModel unirseAPartidaModel;

     public UnirseAPartidaFachada(UnirseAPartidaModel unirseAPartidaModel) {
          this.unirseAPartidaModel = unirseAPartidaModel;
     }
     
     @Override
     public void agregarIEventoUnirseAPartida(IEventoAgregarJugadorAPartida listener) {
           this.unirseAPartidaModel.agregarIEventoUnirseAPartida(listener);
     }

     @Override
     public void agregarIEventoRegresar(IEventoRegresar listener) {
          unirseAPartidaModel.agregarIEventoRegresar(listener);
     }
     
}