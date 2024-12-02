package fachadas;

import cliente.GestorDeComunicaciones;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersServerCentralALogica.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;

/**
 * Fachada
 * 
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class GestorDeComunicacionesFachada implements IGestorDeComunicacionesFachada{
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
    public void conectarAServidor(String ip, int puerto) {
        comunicaciones.conectarAServidor(ip, puerto);
    }

    @Override
    public void enviarMensaje(Object mensaje) {
        comunicaciones.enviarMensaje(mensaje);
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
 
}
