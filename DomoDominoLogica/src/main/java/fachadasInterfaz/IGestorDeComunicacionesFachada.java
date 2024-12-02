package fachadasInterfaz;

import fachadas.GestorDeComunicacionesFachada;
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
public interface IGestorDeComunicacionesFachada {
    
    public void crearServidor(int puerto);
    public GestorDeComunicacionesFachada getInstancia();
    public void conectarAServidor(String ip, int puerto);
    public void enviarMensaje(Object mensaje);
    public void agregarObservadorAcabarPartida(IEventoAcabarPartida observador);
    public void agregarObservadorSalioUnJugador(IEventoSalirDePartida observador);
    public void agregarObservadorIniciarPartida(IEventoIniciarPartida observador);
    public void agregarObservadorPusieronFicha(IEventoPonerFicha observador);
    public void agregarObservadorPasaronTurno(IEventoPasarTurno observador);
    public void agregarObservadorFichaTomadaDelPozo(IEventoTomarFichaDelPozo observador);
    public void agregarObservadorRespuestaCrearPartida(IEventoRespuestaServidorCentral observador);
    public void agregarObservadorRespuestaUnirseAPartida(IEventoRespuestaServidorCentral observador);
}
