package serverInterno;

import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.PonerFichaDto;
import eventos.SetUpDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IEventoIniciarPartida;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoSalirDePartida;


public class GestorMensajes {

     private static final Logger log = Logger.getLogger(GestorMensajes.class.getName());

     private IEventoIniciarPartida observerIniciar;
     private IEventoPonerFicha observerPoner;
     private IEventoTomarFichaDelPozo observerTomar;
     private IEventoPasarTurno observerPasar;
     private IEventoSalirDePartida observerSalir;

     public GestorMensajes() {
     }

     public void agregarObservadorIniciarPartida(IEventoIniciarPartida observador) {
          this.observerIniciar = observador;
     }

     public void eliminarObservadorIniciarPartida(IEventoIniciarPartida observador) {
          this.observerIniciar = null;
     }

     public void notificarObservadoreIniciarPartida(SetUpDto setup) {
          if (observerIniciar != null) {
               observerIniciar.iniciarPartida(setup);
               log.log(Level.INFO, "va a notificar esto: ", setup);
          }
     }

     public void agregarObservadorPonerFicha(IEventoPonerFicha observador) {
          this.observerPoner = observador;
     }

     public void eliminarObservadorPonerFicha(IEventoPonerFicha observador) {
          this.observerPoner = null;
     }

     public void notificarObserverPonerFicha(PonerFichaDto ponerFicha) {
          if (observerPoner != null) {
               observerPoner.ponerFicha(ponerFicha);
               log.log(Level.SEVERE, "Metodo:notificarObserverPonerFicha - Clase:GestorMensajes - Proyecto:ServerInterno");
          }
     }

     public void agregarObservadorTomarFicha(IEventoTomarFichaDelPozo observador) {
          this.observerTomar = observador;
     }

     public void eliminarObservadorTomarFicha(IEventoTomarFichaDelPozo observador) {
          this.observerTomar = null;
     }

     public void notificarObserverTomarFicha(FichaDto ficha) {
          if (observerTomar != null) {
               observerTomar.tomarFichaDelPozo(ficha);
               log.log(Level.SEVERE, "Metodo:notificarObserverTomarFicha - Clase:GestorMensajes - Proyecto:ServerInterno");
          }
     }

     public void agregarObservadorPasarTurno(IEventoPasarTurno observador) {
          this.observerPasar = observador;
     }

     public void eliminarObservadorPasarTurno(IEventoPasarTurno observador) {
          this.observerPasar = null;
     }

     public void notificarObserverPasarTurno() {
          if (observerPasar != null) {
               observerPasar.pasarTurno();
               log.log(Level.SEVERE, "Metodo:notificarObserverPasarTurno - Clase:GestorMensajes - Proyecto:ServerInterno");
          }
     }

     public void agregarObservadorSalirDePartida(IEventoSalirDePartida observador) {
          this.observerSalir = observador;
     }

     public void eliminarObservadorSalirDePartida(IEventoSalirDePartida observador) {
          this.observerSalir = null;
     }

     public void notificarObserverSalirDePartida(JugadorAEliminarDto jugador) {
          if (observerSalir != null) {
               observerSalir.salirDePartida(jugador);
               log.log(Level.SEVERE, "Metodo:notificarObserverSalirDePartida - Clase:GestorMensajes - Proyecto:ServerInterno");
          }
     }

}
