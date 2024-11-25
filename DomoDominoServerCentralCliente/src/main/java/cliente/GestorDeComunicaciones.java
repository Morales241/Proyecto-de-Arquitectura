package cliente;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosDeEventos.JugadorPartidaIniciada;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observersLogicaAServidorCentral.IEventoIniciarPartidaServerCentral;
import observers.IEventoSalirDePartida;
import observersServerCentralALogica.IEventoRespuestaDeCreacionDePartida;
import servidor.GestorMensajes;
import servidor.Servidor;

/**
 *
 * @author tacot
 */
public class GestorDeComunicaciones {

    private final Cliente cliente;
    private Servidor servidor;
    private final GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(GestorDeComunicaciones.class.getName());

    public GestorDeComunicaciones() {
        gestorMensajes = new GestorMensajes();
        cliente = new Cliente();
    }

    public void crearServidor(int puerto) {
        servidor = new Servidor(puerto, gestorMensajes);
    }

    private void conectarAServidor(String ip, int puerto) {
        cliente.conectarAServidor(ip, puerto);
    }

    public void enviarMensaje(Object mensaje, List<JugadorPartidaIniciada> jugadores) {

        jugadores.forEach(Jugador -> {
            conectarAServidor(Jugador.getNodo().getIp(), Jugador.getNodo().getPuerto());
            cliente.enviarMensaje(mensaje);
            cerrarConexion();
        });
        
        log.log(Level.INFO, "mensaje mandado metodo: enviarMensaje clase:GestorDeComunicaciones");
    }

    private void cerrarConexion() {
        cliente.cerrarConexion();
    }

    public void agregarObservadorCrearPartida(IEventoCrearPartida observador) {
        gestorMensajes.agregarObservadorCrearPartida(observador);
    }

    public void agregarObservadorAgregarJugador(IEventoAgregarJugadorAPartida observador) {
        gestorMensajes.agregarObservadorAgregarJugador(observador);
    }

    public void agregarObservadorIniciarPartida(IEventoIniciarPartidaServerCentral observador) {
        gestorMensajes.agregarObservadorIniciarPartida(observador);
    }

    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador) {
        gestorMensajes.agregarObservadorAcabarPartida(observador);
    }

    public void agregarObservadorSalirDePartida(IEventoSalirDePartida observador) {
        gestorMensajes.agregarObservadorSalirDePartida(observador);
    }
    
    public GestorMensajes getGestorMensajes() {
        return gestorMensajes;
    }

}
