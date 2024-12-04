/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import eventos.JugadorBase;
import eventos.NodoDto;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoAcabarPartida;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoIniciarPartida;
import observersServerCentralALogica.IEventoRespuestaServidorCentral;
import observersServerCentralALogica.IEventoSeUnieronAtuPartida;
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
    
    public void conectarAServidor(JugadorBase jugadorBase) {
        cliente.conectarAServidor(jugadorBase.getNombre(), jugadorBase.getNodo());
    }
    
    public void conectarAServidorCentral(String ip, int puerto) {
        cliente.conectarAServidor("serverCentral", new NodoDto(ip, puerto));
    }
    
    public void enviarMensaje(Object mensaje, String nombre) {
        cliente.enviarMensaje(mensaje, nombre);
    }
    
    public void agregarObservadorRespuestaCrearPartida(IEventoRespuestaServidorCentral observador) {
        gestorMensajes.agregarObservadorRespuestaCrearPartida(observador);
    }
    
    public void agregarObservadorRespuestaUnirseAPartida(IEventoRespuestaServidorCentral observador) {
        gestorMensajes.agregarObservadorRespuestaUnirseAPartida(observador);
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
    
    public void agregarObservadorSeUnieronAtuPartida(IEventoSeUnieronAtuPartida observador) {
        gestorMensajes.agregarObservadorSeUnieronAtuPartida(observador);
    }
    
}
