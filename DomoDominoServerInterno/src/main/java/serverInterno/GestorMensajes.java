package serverInterno;

import dtos.FichaDto;
import eventos.EventoAcabarPartidaDto;
import eventos.IniciarPartidaAdmin;
import eventos.JugadorAEliminarDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import eventos.RespuestaDePartidaCreada;
import eventos.RespuestaDeUnirseAPartida;
import eventos.RespuestaServidorCentral;
import eventos.SetUpDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoAcabarPartida;
import observers.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoIniciarPartidaAdmin;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;

public class GestorMensajes {

    private static final Logger log = Logger.getLogger(GestorMensajes.class.getName());

    private IEventoTomarFichaDelPozo observerTomarFichaDelPozo;
    private IEventoPasarTurno observerpasaronTurno;
    private IEventoPonerFicha observerPucieronFicha;
    private IEventoSalirDePartida observerSalioJugador;
    private IEventoIniciarPartida observeriniciarPartida;
    private IEventoAcabarPartida observerAcabarPartida;
    private IEventoRespuestaServidorCentral observerRespuestaCrearP;
    private IEventoRespuestaServidorCentral observerRespuestaUnirseP;
    private IEventoIniciarPartidaAdmin observerIniciarPartidaAdmin;

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

    //acabar partida
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador) {
        this.observerAcabarPartida = observador;
    }

    public void eliminarObservadorAcabarPartida() {
        this.observerAcabarPartida = null;
    }

    public void notificarObservadorAcabarPartida(EventoAcabarPartidaDto acabarPartidaDto) {
        if (observerAcabarPartida != null) {
            observerAcabarPartida.acabarPartida(acabarPartidaDto);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //respuesta del server central crear partida
    public void agregarObservadorRespuestaCrearPartida(IEventoRespuestaServidorCentral observador) {
        this.observerRespuestaCrearP = observador;
    }

    public void eliminarObservadorRespuestaCrearPartida() {
        this.observerRespuestaCrearP = null;
    }

    public void notificarObserverRespuestaCrearPartida(RespuestaDePartidaCreada respuesta) {
        if (observerRespuestaCrearP != null) {
            observerRespuestaCrearP.actualizar(respuesta);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //respuesta del server central unirse a partida
    public void agregarObservadorRespuestaUnirseAPartida(IEventoRespuestaServidorCentral observador) {
        this.observerRespuestaUnirseP = observador;
    }

    public void eliminarObservadorRespuestaUnirseAPartida() {
        this.observerRespuestaUnirseP = null;
    }

    public void notificarObserverRespuestaUnirseAPartida(RespuestaDeUnirseAPartida respuesta) {
        if (observerRespuestaUnirseP != null) {
            observerRespuestaUnirseP.actualizar(respuesta);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    public void procesarRespuestaDelServidorCentral(RespuestaServidorCentral respuesta) {

        switch (respuesta) {
            case RespuestaDePartidaCreada respuestaDePartidaCreada -> notificarObserverRespuestaCrearPartida(respuestaDePartidaCreada);
            case RespuestaDeUnirseAPartida respuestaDeUnirseAPartida -> notificarObserverRespuestaUnirseAPartida(respuestaDeUnirseAPartida);
            default -> {
            }
        }

    }

    //Iniciar Partida (solo el admin de la partida hace esto)
    public void agregarObservadorIniciarPartidaAdmin(IEventoIniciarPartidaAdmin observador) {
        this.observerIniciarPartidaAdmin = observador;
    }

    public void eliminarObservadorIniciarPartidaAdmin() {
        this.observerIniciarPartidaAdmin = null;
    }

    public void notificarObserverIniciarPartidaAdmin(IniciarPartidaAdmin partidaAdmin) {
        if (observerIniciarPartidaAdmin != null) {
            observerIniciarPartidaAdmin.iniciarPartida(partidaAdmin);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }
    
}
