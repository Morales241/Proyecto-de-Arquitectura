/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearPartida;

import cliente.GestorDeComunicaciones;
import eventos.JugadorCrearPartidaDto;
import mediador.IMediador;
import mediador.Mediador;

/**
 *
 * @author tacot
 */
public class LogicaCrearPartida implements ILogicaCrearPartida{

    private final IMediador mediador;
    private GestorDeComunicaciones comunicaciones; 

    public LogicaCrearPartida(GestorDeComunicaciones comunicacionesParametro) {
        this.mediador = Mediador.getInstancia();
        this.comunicaciones = comunicacionesParametro;
    }
    
    @Override
    public void regresarAlInicio() {
        String nombrePantalla = "inicio";
        mediador.mostrarPantallaConcreta(nombrePantalla);
    }

    @Override
    public void crearPartida(JugadorCrearPartidaDto jugador) {
        System.out.println("se va a crear la partida");
        //cambiar la ip por las diferentes redes
        comunicaciones.conectarAServidor("10.202.67.95", 8090);
        comunicaciones.enviarMensaje(jugador);
    }
    
}
