package fachadasInterfaz;

import eventos.JugadorBase;
import eventos.IEventoPasarTurno;
import eventos.IEventoPonerFicha;
import eventos.IEventoSalirDePartida;
import eventos.IEventoTomarFichaDelPozo;
import eventos.IEventoAcabarPartida;
import eventos.IEventoIniciarPartida;
import eventos.IEventoIniciarPartidaAdmin;
import eventos.IEventoRespuestaServidorCentral;
import eventos.IEventoSeUnieronAtuPartida;

/**
 * Fachada
 * 
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public interface IGestorDeComunicacionesFachada {
    
    public void crearServidor(int puerto);
    public IGestorDeComunicacionesFachada getInstancia();
    public void conectarAServidor(JugadorBase jugadorBase);
    public void enviarMensaje(Object mensaje, String nombre);
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador);
    public void agregarObservadorSalioUnJugador(IEventoSalirDePartida observador);
    public void agregarObservadorIniciarPartida(IEventoIniciarPartida observador);
    public void agregarObservadorPusieronFicha(IEventoPonerFicha observador);
    public void agregarObservadorPasaronTurno(IEventoPasarTurno observador);
    public void agregarObservadorFichaTomadaDelPozo(IEventoTomarFichaDelPozo observador);
    public void agregarObservadorRespuestaCrearPartida(IEventoRespuestaServidorCentral observador);
    public void agregarObservadorRespuestaUnirseAPartida(IEventoRespuestaServidorCentral observador);
    public void conectarAServidorCentral(String ip, int puerto);
    public void agregarObservadorSeUnieronAtuPartida(IEventoSeUnieronAtuPartida observador);
    public void agregarObservadorIniciarPartidaAdmin(IEventoIniciarPartidaAdmin observador);
    public void enviarMensajesACompañeros(Object mensaje);
    public void cerrarComunicacionConNodo(String nombre);
}
