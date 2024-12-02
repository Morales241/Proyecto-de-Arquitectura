/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unirseAPartida;

import eventos.JugadorUnirseAPartidaDto;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediador.IMediador;
import mediador.Mediador;

/**
 *
 * @author favel
 */
public class LogicaUnirseAPartida implements ILogicaUnirseAPartida {

     private final IMediador mediador;
     private IGestorDeComunicacionesFachada comunicaciones;

     public LogicaUnirseAPartida(IGestorDeComunicacionesFachada comunicaciones) {
          this.mediador = Mediador.getInstancia();
          this.comunicaciones = comunicaciones;
     }
     
     @Override
     public void regresarAInicio() {
         String nombrePantalla = "inicio";
         mediador.mostrarPantallaConcreta(nombrePantalla);
     }

     @Override
     public void unirseAPartida(JugadorUnirseAPartidaDto jugador) {
          System.out.println("se va a unir a la partida");
          
          try {
               comunicaciones.conectarAServidor(InetAddress.getLocalHost().getHostAddress(), 8090);
          } catch (UnknownHostException ex) {
               Logger.getLogger(LogicaUnirseAPartida.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          comunicaciones.enviarMensaje(jugador);
     }
     
}
