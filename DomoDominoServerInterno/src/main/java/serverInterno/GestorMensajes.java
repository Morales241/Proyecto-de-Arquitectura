package serverInterno;

import dtos.FichaDto;
import eventos.JugadorAEliminarDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import eventos.RespuestaServidorCentral;
import eventos.SetUpDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersServerCentralALogica.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;

public class GestorMensajes {

    private static final Logger log = Logger.getLogger(GestorMensajes.class.getName());

    private IEventoTomarFichaDelPozo observerTomarFichaDelPozo;
    private IEventoPasarTurno observerpasaronTurno;
    private IEventoPonerFicha observerPucieronFicha;
    private IEventoSalirDePartida observerSalioJugador;
    private IEventoIniciarPartida observeriniciarPartida;
    private IEventoAcabarPartida observerAcabarPartida;
    private IEventoRespuestaServidorCentral observerCentral;
    

    public GestorMensajes() {
    }

    //Tomaron ficha del pozo
    public void agregarObservadorFichaTomadaDelPozo(IEventoTomarFichaDelPozo observador) {
        this.observerTomarFichaDelPozo = observador;
    }

    public void eliminarObservadorFichaTomadaDelPozo() {
        this.observerTomarFichaDelPozo = null;
    }

    public void notificarObservadorFichaTomadaDelPozo(FichaDto ficha) {
        if (observerTomarFichaDelPozo != null) {
            observerTomarFichaDelPozo.tomarFichaDelPozo(ficha);
            log.log(Level.INFO, "Metodo:notificarObserverTomarFichaDelPozo - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //Pasaron turno
    public void agregarObservadorPasaronTurno(IEventoPasarTurno observador) {
        this.observerpasaronTurno = observador;
    }

    public void eliminarObservadorPasaronTurno() {
        this.observerpasaronTurno = null;
    }

    public void notificarObservadorPasaronTurno() {
        if (observerpasaronTurno != null) {
            observerpasaronTurno.pasarTurno(new PasarTurno());
            log.log(Level.INFO, "Metodo:notificarObserverPasaronTurno - Clase:GestorMensajes - Proyecto:Proyecto:Server de Server Central");
        }
    }

    //pucieron ficha
    public void agregarObservadorPucieronFicha(IEventoPonerFicha observador) {
        this.observerPucieronFicha = observador;
    }

    public void eliminarObservadorPucieronFicha() {
        this.observerPucieronFicha = null;
    }

    public void notificarObservadorPucieronFicha(PonerFichaDto jugador) {
        if (observerPucieronFicha != null) {
            observerPucieronFicha.ponerFicha(jugador);
            log.log(Level.INFO, "Metodo:notificarObserverPucieronFicha - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //Iniciar partida
    public void agregarObservadorIniciarPartida(IEventoIniciarPartida observador) {
        this.observeriniciarPartida = observador;
    }

    public void eliminarObservadorIniciarPartida() {
        this.observeriniciarPartida = null;
    }

    public void notificarObserverIniciarPartida(SetUpDto setUp) {
        if (observeriniciarPartida != null) {
            observeriniciarPartida.iniciarPartida(setUp);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //Salio un jgador de partida
    public void agregarObservadorSalioUnJugador(IEventoSalirDePartida observador) {
        this.observerSalioJugador = observador;
    }

    public void eliminarObservadorSalioUnJugador() {
        this.observerSalioJugador = null;
    }

    public void notificarObservadorSalioUnJugador(JugadorAEliminarDto jugador) {
        if (observerSalioJugador != null) {
            observerSalioJugador.salirDePartida(jugador);
            log.log(Level.INFO, "Metodo:notificarObserverSalioUnJugador - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    
    //Iniciar partida
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador) {
        this.observerAcabarPartida = observador;
    }

    public void eliminarObservadorAcabarPartida() {
        this.observerAcabarPartida = null;
    }

    public void notificarObservadorAcabarPartida(String codigo) {
        if (observerAcabarPartida != null) {
            observerAcabarPartida.acabarPartida(codigo);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }
    
    //Iniciar partida
    public void agregarObservadorRespuestaDelServidorCentral(IEventoRespuestaServidorCentral observador) {
        this.observerCentral = observador;
    }

    public void eliminarObservadorRespuestaDelServidorCentral() {
        this.observerCentral = null;
    }

    public void notificarObserverRespuestaDelServidorCentral(RespuestaServidorCentral respuesta) {
        if (observerCentral != null) {
            observerCentral.actualizar(respuesta);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }
}
