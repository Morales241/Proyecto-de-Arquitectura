/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearPartida;

import cliente.Cliente;
import eventos.JugadorCrearPartidaDto;
import mediador.IMediador;
import mediador.Mediador;

/**
 *
 * @author tacot
 */
public class LogicaCrearPartida implements ILogicaCrearPartida{

    private final IMediador mediador;
    private Cliente cliente; 

    public LogicaCrearPartida() {
        this.mediador = Mediador.getInstancia();
    }
    
    @Override
    public void regresarAlInicio() {
        String nombrePantalla = "inicio";
        mediador.mostrarPantallaConcreta(nombrePantalla);
    }

    @Override
    public void crearPartida(JugadorCrearPartidaDto jugador) {
        System.out.println("se va a crear la partida");
        //cliente.conectarANodo("", 0);
        //cliente.mandarMensaje();
    }
    
}
