package servidor;

import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosDeEventos.VotoDeJugador;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IEventoSalirDePartida;
import observersServerCentralALogica.IEventoVotarParaIniciarPartida;

public class GestorMensajes {

    private static final Logger log = Logger.getLogger(GestorMensajes.class.getName());

    private IEventoCrearPartida IEventoCrearPartida;
    private IEventoSalirDePartida observerSalir;
    private IEventoAgregarJugadorAPartida observerAgregarJugador;
    private IEventoAcabarPartida observeracabarPartida;
    private IEventoVotarParaIniciarPartida observerVotar;

    public GestorMensajes() {
    }

    //Crear partida
    public void agregarObservadorCrearPartida(IEventoCrearPartida observador) {
        this.IEventoCrearPartida = observador;
    }

    public void eliminarObservadorCrearPartida() {
        this.IEventoCrearPartida = null;
    }

    public void notificarObservadoreCrearPartida(JugadorCrearPartidaDto jugador) {
        if (IEventoCrearPartida != null) {
            IEventoCrearPartida.crearPartida(jugador);
            log.log(Level.INFO, "Metodo:notificarObserverCrearPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //Salir de partida
    public void agregarObservadorSalirDePartida(IEventoSalirDePartida observador) {
        this.observerSalir = observador;
    }

    public void eliminarObservadorSalirDePartida() {
        this.observerSalir = null;
    }

    public void notificarObserverSalirDePartida(JugadorAEliminarDto jugador) {
        if (observerSalir != null) {
            observerSalir.salirDePartida(jugador);
            log.log(Level.INFO, "Metodo:notificarObserverSalirDePartida - Clase:GestorMensajes - Proyecto:Proyecto:Server de Server Central");
        }
    }

    //Agregar Jugador a partida
    public void agregarObservadorAgregarJugador(IEventoAgregarJugadorAPartida observador) {
        this.observerAgregarJugador = observador;
    }

    public void eliminarObservadorAgregarJugador() {
        this.observerAgregarJugador = null;
    }

    public void notificarObserverAgregarJugador(JugadorUnirseAPartidaDto jugador) {
        if (observerAgregarJugador != null) {
            observerAgregarJugador.agregarJugadorAPartida(jugador);
            log.log(Level.INFO, "Metodo:notificarObserverAgregarJugador - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //Iniciar partida
    public void agregarObservadorIniciarPartida(IEventoVotarParaIniciarPartida observador) {
        this.observerVotar = observador;
    }

    public void eliminarObservadorIniciarPartida() {
        this.observerVotar = null;
    }

    public void notificarObserverIniciarPartida(VotoDeJugador votoDeJugador) {
        if (observerVotar != null) {
            observerVotar.iniciarPartida(votoDeJugador);
            log.log(Level.INFO, "Metodo:notificarObserverIniciarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

    //Acabar partida
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador) {
        this.observeracabarPartida = observador;
    }

    public void eliminarObservadorAcabarPartida() {
        this.observeracabarPartida = null;
    }

    public void notificarObserverAcabarPartida(String codigo) {
        if (observeracabarPartida != null) {
            observeracabarPartida.acabarPartida(codigo);
            log.log(Level.INFO, "Metodo:notificarObserverAcabarPartida - Clase:GestorMensajes - Proyecto:Server de Server Central");
        }
    }

}
