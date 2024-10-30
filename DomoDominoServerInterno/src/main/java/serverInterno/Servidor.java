package serverInterno;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import serializables.Jugada;

public class Servidor {
    private ServerSocket serverSocket;
    private DataInputStream lector;
    private GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(Servidor.class.getName());

    public Servidor(int puerto, GestorMensajes gestorMensajes) {
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
                    
                    //agregar al server central
                    
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
                lector = new DataInputStream (nodo.getInputStream());
            } catch (IOException e) {
                log.log(Level.SEVERE, "Error en la clase Cliente - Receptor, metodo constructor", e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                Jugada judadaRecibida;
                while ((judadaRecibida = obtenerMensaje()) != null) {
                    gestorMensajes.notificarObservadores(judadaRecibida);
                    log.log(Level.INFO, "Mensaje recibido: ", judadaRecibida);
                }
            } catch (IOException ex) {
                log.log(Level.SEVERE, "Error en la clase Cliente - Receptor, metodo run:", ex.getMessage());
            }
        }
        
        public Jugada obtenerMensaje() throws IOException {
            
            int tamano = lector.readInt();
            
            byte[] bytesJugada = new byte[tamano];
            
            lector.readFully(bytesJugada);
            
            String jsonJugada = pasarAString(bytesJugada);
             
            Jugada jugadaRecibida = desSerializarJugada(jsonJugada);
            
            return jugadaRecibida;
        }
        
        public String pasarAString(byte[] bites){
        
            String jsonJugada = new String(bites);
            
            return jsonJugada;
        }
        
        public Jugada desSerializarJugada(String json){
            
            Gson gson = new Gson();
            
            Jugada judadaRecibida = gson.fromJson(json, Jugada.class);
        
            return judadaRecibida;
        }
    }
}
