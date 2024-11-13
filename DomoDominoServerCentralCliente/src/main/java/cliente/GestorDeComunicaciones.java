/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import observers.IEventoAcabarPartida;
import observers.IEventoAgregarJugadorAPartida;
import observers.IEventoCrearPartida;
import observers.IEventoIniciarPartidaServerCentral;
import observers.IEventoSalirDePartida;
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

    public GestorDeComunicaciones(GestorMensajes gMensajes) {
        gestorMensajes = gMensajes;
        cliente = new Cliente();
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

}