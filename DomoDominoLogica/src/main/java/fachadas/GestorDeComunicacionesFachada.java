package fachadas;

import cliente.GestorDeComunicaciones;
import eventos.JugadorBase;
import eventos.NodoDto;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoAcabarPartida;
import observers.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoIniciarPartidaAdmin;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;
import observersServerCentralALogica.IEventoSeUnieronAtuPartida;

/**
 * Fachada
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class GestorDeComunicacionesFachada implements IGestorDeComunicacionesFachada {

    private static GestorDeComunicacionesFachada instancia;
    private final GestorDeComunicaciones comunicaciones;
    
    public GestorDeComunicacionesFachada() {
        this.comunicaciones = new GestorDeComunicaciones();
    }
    
    @Override
    public GestorDeComunicacionesFachada getInstancia() {
        if (instancia == null) {
            synchronized (GestorDeComunicacionesFachada.class) {
                if (instancia == null) {
                    instancia = new GestorDeComunicacionesFachada();
                }
            }
        }
        return instancia;
    }
    
    @Override
    public void crearServidor(int puerto) {
        comunicaciones.crearServidor(puerto);
    }
    
    @Override
    public void conectarAServidor(JugadorBase jugadorBase) {
        comunicaciones.conectarAServidor(jugadorBase);
    }
    
    @Override
    public void enviarMensaje(Object mensaje, String nombre) {
        comunicaciones.enviarMensaje(mensaje, nombre);
    }
    
    @Override
    public void agregarObservadorRespuestaCrearPartida(IEventoRespuestaServidorCentral observador) {
        comunicaciones.agregarObservadorRespuestaCrearPartida(observador);
    }
    
    @Override
    public void agregarObservadorRespuestaUnirseAPartida(IEventoRespuestaServidorCentral observador) {
        comunicaciones.agregarObservadorRespuestaUnirseAPartida(observador);
    }
    
    @Override
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador) {
        comunicaciones.agregarObservadorAcabarPartida(observador);
    }
    
    @Override
    public void agregarObservadorSalioUnJugador(IEventoSalirDePartida observador) {
        comunicaciones.agregarObservadorSalioUnJugador(observador);
    }
    
    @Override
    public void agregarObservadorIniciarPartida(IEventoIniciarPartida observador) {
        comunicaciones.agregarObservadorIniciarPartida(observador);
    }
    
    @Override
    public void agregarObservadorPusieronFicha(IEventoPonerFicha observador) {
        comunicaciones.agregarObservadorPucieronFicha(observador);
    }
    
    @Override
    public void agregarObservadorPasaronTurno(IEventoPasarTurno observador) {
        comunicaciones.agregarObservadorPasaronTurno(observador);
    }
    
    @Override
    public void agregarObservadorFichaTomadaDelPozo(IEventoTomarFichaDelPozo observador) {
        comunicaciones.agregarObservadorFichaTomadaDelPozo(observador);
    }
    
    @Override
    public void conectarAServidorCentral(String ip, int puerto) {
        comunicaciones.conectarAServidorCentral(ip, puerto);
    }
    
    @Override
    public void agregarObservadorSeUnieronAtuPartida(IEventoSeUnieronAtuPartida observador) {
        comunicaciones.agregarObservadorSeUnieronAtuPartida(observador);
    }

    @Override
    public void agregarObservadorIniciarPartidaAdmin(IEventoIniciarPartidaAdmin observador) {
        comunicaciones.agregarObservadorIniciarPartidaAdmin(observador);
    }

    @Override
    public void enviarMensajesACompañeros(Object mensaje) {
        comunicaciones.enviarMensajesACompañeros(mensaje);
    }
    
}
