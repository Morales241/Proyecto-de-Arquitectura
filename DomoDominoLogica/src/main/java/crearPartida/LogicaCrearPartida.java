/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearPartida;

import eventos.JugadorCrearPartidaDto;
import eventos.NodoDto;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediador.IMediador;
import mediador.Mediador;

/**
 *
 * @author tacot
 */
public class LogicaCrearPartida implements ILogicaCrearPartida {

    private final IMediador mediador;
    private final IGestorDeComunicacionesFachada comunicaciones;

    public LogicaCrearPartida(IGestorDeComunicacionesFachada comunicacionesParametro) {
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
        try {

            String ip = InetAddress.getLocalHost().getHostAddress();
            ip = "192.168.100.11";
            jugador.setNodo(new NodoDto(ip, 8198));

            comunicaciones.conectarAServidorCentral("192.168.100.21", 8190);
        } catch (UnknownHostException ex) {
            Logger.getLogger(LogicaCrearPartida.class.getName()).log(Level.SEVERE, null, ex);
        }

        comunicaciones.enviarMensaje(jugador, "serverCentral");
    }

    public String generarCodigo() {

        String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();

        int posicion;

        String codigo = "";

        for (int i = 0; i < 4; i++) {

            posicion = random.nextInt(0, abecedario.length() - 1);

            codigo += abecedario.charAt(posicion);
        }

        return codigo;
    }

}
