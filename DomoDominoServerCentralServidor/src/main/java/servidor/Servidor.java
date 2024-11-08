package servidor;

import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private ServerSocket serverSocket;
    private ObjectInputStream lector;
    private GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(Servidor.class.getName());

    public Servidor(int puerto, GestorMensajes gestorMensajes) {
        this.gestorMensajes = gestorMensajes;
        try {
            serverSocket = new ServerSocket(puerto);

            log.log(Level.INFO, "El servidor se inicio en el puerto: " + puerto, puerto);

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
                lector = new ObjectInputStream(nodo.getInputStream());
            } catch (IOException e) {
               log.log(Level.SEVERE, "Metodo:Receptor - Clase:Servidor - Proyecto:Server de Server Central");
            }
        }

        @Override
        public void run() {
            Object mensajeRecibido = null;
            
            while ((mensajeRecibido = obtenerMensaje()) != null) {
                
                if (mensajeRecibido instanceof JugadorCrearPartidaDto jugadorCrearPartidaDto) {
                    gestorMensajes.notificarObservadoreCrearPartida(jugadorCrearPartidaDto);
                    
                }
                if (mensajeRecibido instanceof JugadorUnirseAPartidaDto jugadorUnirseAPartidaDto) {
                   gestorMensajes.notificarObserverAgregarJugador(jugadorUnirseAPartidaDto);
                
                }if (mensajeRecibido instanceof JugadorAEliminarDto jugadorAEliminarDto) {
                   gestorMensajes.notificarObserverSalirDePartida(jugadorAEliminarDto);
                } else {
                    
                }
               log.log(Level.INFO, "Metodo:run - Clase:Servidor - Proyecto:Server de Server Central");
            }
        }

        public Object obtenerMensaje() {
            Object mensaje = null;
            try {
                mensaje = lector.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return mensaje;
        }
    }
}
