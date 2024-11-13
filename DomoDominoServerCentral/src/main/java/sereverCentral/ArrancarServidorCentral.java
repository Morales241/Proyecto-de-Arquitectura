/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sereverCentral;

import cliente.Cliente;
import eventos.JugadorCrearPartidaDto;
import servidor.GestorMensajes;
import servidor.Servidor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tacot
 */
public class ArrancarServidorCentral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        boolean llave = true;
        GestorMensajes gestorMensajes = new GestorMensajes();
        Servidor server = new Servidor(8091, gestorMensajes);
        Cliente cliente = new Cliente();
        ServerCentral serverCentral = new ServerCentral(cliente, gestorMensajes);
        System.out.println("192.168.100.11");
        while (llave) {
            llave = tec.nextBoolean();
            System.out.println(llave);
        }
        System.out.println("se va a conectar");
        cliente.conectarAServidor("192.168.100.21", 8070);

        while (!llave) {
            llave = tec.nextBoolean();
            System.out.println(llave);
        }
        System.out.println("va a mandar algo");
        cliente.enviarMensaje(new JugadorCrearPartidaDto("2", "3", 1));

    }

}
