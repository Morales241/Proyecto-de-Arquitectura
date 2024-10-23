package serverInterno;

import cliente.Cliente;
import cliente.GestorMensajes;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    private ServerSocket serverSocket;
    private GestorConexiones GestorConexiones;
    private GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(Servidor.class.getName());

    public Servidor(int puerto, GestorConexiones GestorConexiones, GestorMensajes gestorMensajes) {
        this.GestorConexiones = GestorConexiones;
        this.gestorMensajes = gestorMensajes;
        try {
            serverSocket = new ServerSocket(puerto);
            
            log.log(Level.INFO, "El servidor se inicio en el puerto: ", puerto);
            
            new Thread(new Oyente()).start();
            
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error en la clase Servidor, metodo constructor: ", e.getMessage());
        }
    }

    private class Oyente implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Socket nodo = serverSocket.accept();
                    
                    GestorConexiones.agregarNodo(nodo);
                    
                    Cliente cliente = new Cliente(gestorMensajes);
                    
                    cliente.iniciarReceptor(nodo); 
                    
                    
                } catch (IOException e) {
                    log.log(Level.SEVERE, "Error en la clase Servirdor - Oyente, metodo run", e.getMessage());
                }
            }
        }
    }
}
