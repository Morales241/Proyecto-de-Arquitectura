/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sereverCentral;

import cliente.Cliente;
import cliente.GestorDeComunicaciones;
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

        try {
            Scanner tec = new Scanner(System.in);
            boolean llave = true;
            GestorDeComunicaciones comunicaciones = new GestorDeComunicaciones();
            ServerCentral server = new ServerCentral(comunicaciones);
            comunicaciones.crearServidor(8090);
            
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            while (llave) {
                llave = tec.nextBoolean();
                System.out.println(llave);
            }
            System.out.println("se va a conectar");
            comunicaciones.conectarAServidor("192.168.100.21", 8097);
            
            while (!llave) {
                llave = tec.nextBoolean();
                System.out.println(llave);
            }
            System.out.println("va a mandar algo");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ArrancarServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
