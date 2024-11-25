package cliente;

import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoRespuestaDeCreacionDePartida;
import observersServerCentralALogica.IEventoRespuestaDeUnirseAPartida;
import serverInterno.GestorMensajes;
import serverInterno.Servidor;

/**
 *
 * @author tacot
 */
public class GestorDeComunicaciones {
    
    private final Cliente cliente;
    private Servidor servidor;
    private final GestorMensajes gestorMensajes;
    
    public GestorDeComunicaciones() {
        cliente = new Cliente();
        gestorMensajes = new GestorMensajes();
    }
    
    public void crearServidor(int puerto) {
        servidor = new Servidor(puerto, gestorMensajes);
    }
    
    public void conectarAServidor(String ip, int puerto) {
        cliente.conectarAServidor(ip, puerto);
    }
    
    public void enviarMensaje(Object mensaje) {
        cliente.enviarMensaje(mensaje);
    }
    
    public void agregarObservadorRespuestaDeCrearPartida(IEventoRespuestaDeCreacionDePartida observador) {
        gestorMensajes.agregarObservadorRespuestaDeCrearPartida(observador);
    }
    
    public void agregarObservadorRespuestaDeUnirseAPartida(IEventoRespuestaDeUnirseAPartida observador) {
        gestorMensajes.agregarObservadorRespuestaDeUnirseAPartida(observador);
    }
    
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador) {
        gestorMensajes.agregarObservadorAcabarPartida(observador);
    }
    
    public void agregarObservadorSalioUnJugador(IEventoSalirDePartida observador) {
        gestorMensajes.agregarObservadorSalioUnJugador(observador);
    }
    
    public void agregarObservadorIniciarPartida(IEventoIniciarPartida observador) {
        gestorMensajes.agregarObservadorIniciarPartida(observador);
    }
    
    public void agregarObservadorPucieronFicha(IEventoPonerFicha observador) {
        gestorMensajes.agregarObservadorPucieronFicha(observador);
    }
    
    public void agregarObservadorPasaronTurno(IEventoPasarTurno observador) {
        gestorMensajes.agregarObservadorPasaronTurno(observador);
    }
    
    public void agregarObservadorFichaTomadaDelPozo(IEventoTomarFichaDelPozo observador) {
        gestorMensajes.agregarObservadorFichaTomadaDelPozo(observador);
    }
    
}
