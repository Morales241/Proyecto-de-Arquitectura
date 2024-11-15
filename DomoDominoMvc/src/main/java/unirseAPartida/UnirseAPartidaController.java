/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unirseAPartida;

import eventos.JugadorUnirseAPartidaDto;
import observers.IEventoAgregarJugadorAPartida;

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
}
