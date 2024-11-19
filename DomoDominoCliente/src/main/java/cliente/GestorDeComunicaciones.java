/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observersLogicaAServidorCentral.IEventoIniciarPartidaServerCentral;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observersServerCentralALogica.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;
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
    
    public void agregarObservadorRespuestaDelServidorCentral(IEventoRespuestaServidorCentral observador) {
        gestorMensajes.agregarObservadorRespuestaDelServidorCentral(observador);
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
