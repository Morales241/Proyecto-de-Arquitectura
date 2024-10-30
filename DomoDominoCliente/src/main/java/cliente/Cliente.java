package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private Socket socket;
    private BufferedReader lector;
    private PrintWriter escritor;
    private final GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(Cliente.class.getName());

    public Cliente(GestorMensajes gestorMensajes) {
        this.gestorMensajes = gestorMensajes;
    }

    public void conectarANodo(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            
            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            escritor = new PrintWriter(socket.getOutputStream(), true);
            
            iniciarReceptor(socket);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error en la clase Cliente, metodo conectarANodo: ", e.getMessage());
        }
    }

    public void iniciarReceptor(Socket nodo) {
        new Thread(new Receptor(nodo)).start();
    }

    public void enviarMensaje(String mensaje) {
        try {
            escritor.println(mensaje);
            log.info("Mensaje enviado: " + mensaje);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error en la clase Cliente, metodo enviar mensaje", e.getMessage());
        }
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
