/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unirseAPartida;

import objetosDeEventos.JugadorUnirseAPartidaDto;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class UnirseAPartidaController {
    
     private final UnirseAPartidaModel unirseAPartidaModel;
     private final UnirseAPartidaView unirseAPartidaView;
     

     public UnirseAPartidaController(UnirseAPartidaModel unirseAPartidaModel, UnirseAPartidaView unirseAPartidaView) {
          this.unirseAPartidaModel = unirseAPartidaModel;
          this.unirseAPartidaView = unirseAPartidaView;
          this.unirseAPartidaView.agregarIEventoRegresar(new accionRegresar());
         this.unirseAPartidaView.agregarIEventoUnirseAPartida(new accionUnirseAPartida());
     }
     
     public void validarNombre(JugadorUnirseAPartidaDto jugador) {
          unirseAPartidaModel.validarNombre(jugador);
     }
     
     public void regresar() {
          unirseAPartidaModel.ejecutarAccionRegresar();
     }
     
     private class accionUnirseAPartida implements IEventoAgregarJugadorAPartida {

          @Override
          public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {
              validarNombre(jugador);
          }
          
     }
     
     private class accionRegresar implements IObserver{

        @Override
        public void actualizar() {
            regresar();
        }
    }
     
     
}
