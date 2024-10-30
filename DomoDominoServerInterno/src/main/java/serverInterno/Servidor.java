package serverInterno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    private ServerSocket serverSocket;
    private BufferedReader lector;
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
                    
                    iniciarReceptor(nodo); 
                    
                } catch (IOException e) {
                    log.log(Level.SEVERE, "Error en la clase Servirdor - Oyente, metodo run", e.getMessage());
                }
            }
        }
    }
    
    public void iniciarReceptor(Socket nodo) {
        new Thread(new Receptor(nodo)).start();
    }
    
    private class Receptor implements Runnable {

        private Socket nodo;

        public Receptor(Socket nodo) {
            this.nodo = nodo;
            try {
                lector = new BufferedReader(new InputStreamReader(nodo.getInputStream()));
            } catch (IOException e) {
                log.log(Level.SEVERE, "Error en la clase Cliente - Receptor, metodo constructor", e.getMessage());
            }
        }

        public String obtenerMensaje() throws IOException {
            return lector.readLine();
        }

        @Override
        public void run() {
            try {
                String mensaje;
                while ((mensaje = obtenerMensaje()) != null) {
                    gestorMensajes.notificarObservadores(mensaje);
                    log.info("Mensaje recibido: " + mensaje);
                }
            } catch (IOException ex) {
                log.log(Level.SEVERE, "Error en la clase Cliente - Receptor, metodo run:", ex.getMessage());
            }
        }
    }
}
