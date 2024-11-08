/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sereverCentral;

import cliente.Cliente;
import servidor.GestorMensajes;
import servidor.Servidor;

/**
 *
 * @author tacot
 */
public class ArrancarServidorCentral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorMensajes gestorMensajes = new GestorMensajes();
        Servidor server = new Servidor(8091, gestorMensajes);
        Cliente cliente = new Cliente(server);
        ServerCentral serverCentral = new ServerCentral(cliente, gestorMensajes);
        
    }
    
}
