/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unirseAPartida;

import eventos.JugadorUnirseAPartidaDto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class UnirseAPartidaModel {
    
     private IEventoAgregarJugadorAPartida observerUniserAPartida;
     private IObserver observerNombreInvalido;
     private IObserver observerRegresar;

     public UnirseAPartidaModel() {
     }
     
     public void validarNombre(JugadorUnirseAPartidaDto jugador) {
           Pattern validacion = Pattern.compile("^[A-Za-z0-9_]{3,15}$");

        Matcher match = validacion.matcher(jugador.getNodo().getNombre());
        if (match.matches()) {
            
            ejecutarAccionUnirseAPartida(jugador);
            
        }else{
        
            ejecutarAccionNombreInvalido();
        }
     }
     
     public void agregarIEventoNombreInvalido(IObserver listener) {
          this.observerNombreInvalido = listener;
     }
     
     public void ejecutarAccionNombreInvalido() {
          if (observerNombreInvalido != null) {
               observerNombreInvalido.actualizar();
          }
     }
     
     public void agregarIEventoRegresar(IObserver listener) {
          this.observerRegresar = listener;
     }
     
     public void ejecutarAccionRegresar() {
          if (observerRegresar != null) {
               observerRegresar.actualizar();
          }
     }
     
     public void agregarIEventoUnirseAPartida(IEventoAgregarJugadorAPartida listener ) {
          this.observerUniserAPartida = listener;
     }
     
     public void ejecutarAccionUnirseAPartida (JugadorUnirseAPartidaDto jugador) {
          if (observerUniserAPartida != null) {
               observerUniserAPartida.agregarJugadorAPartida(jugador);
          }
     }
     
}
