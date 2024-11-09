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

    private ObjectInputStream lector;
    private ServerSocket serverSocket;

    private GestorMensajes gestorMensajes;
    private static final Logger log = Logger.getLogger(Servidor.class.getName());

    public Servidor(int puerto, GestorMensajes gestorMensajes) {
        this.gestorMensajes = gestorMensajes;
        try {
            serverSocket = new ServerSocket(puerto);
            log.log(Level.INFO, "El servidor se inició en el puerto: " + puerto);

            new Thread(new Oyente()).start();

        } catch (IOException e) {
            log.log(Level.SEVERE, "Error en la clase Servidor, método constructor: ", e);
        }
    }

    private class Oyente implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Socket nodo = serverSocket.accept();
                    log.log(Level.INFO, "Se agregó nuevo nodo: " + nodo.getInetAddress().getHostAddress());
                    iniciarReceptor(nodo);

                } catch (IOException e) {
                    log.log(Level.SEVERE, "Error en la clase Servidor - Oyente, método run", e);
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
        }

        @Override
        public void run() {
            Object mensajeRecibido = null;

            while ((mensajeRecibido = obtenerMensaje()) != null) {
                switch (mensajeRecibido) {
                    
                    case JugadorCrearPartidaDto jugadorCrearPartidaDto ->
                        gestorMensajes.notificarObservadoreCrearPartida(jugadorCrearPartidaDto);
                    
                    case JugadorUnirseAPartidaDto jugadorUnirseAPartidaDto ->
                        gestorMensajes.notificarObserverAgregarJugador(jugadorUnirseAPartidaDto);
                    
                    case JugadorAEliminarDto jugadorAEliminarDto ->
                        gestorMensajes.notificarObserverSalirDePartida(jugadorAEliminarDto);
                    
                    default ->
                        log.log(Level.INFO, "Tipo de mensaje no reconocido");
                }
                log.log(Level.INFO, "Método: run - Clase: Servidor - Proyecto: Server de Server Central");
            }
        }

        public Object obtenerMensaje() {
            Object mensaje = null;
            try (ObjectInputStream lector = new ObjectInputStream(nodo.getInputStream())){
                mensaje = lector.readObject();
                log.log(Level.INFO, "Llegó un mensaje");
            } catch (IOException | ClassNotFoundException ex) {
                log.log(Level.SEVERE, "Error al leer el mensaje", ex);
            }
            return mensaje;
            
            
        }
    }

    public void setLector(ObjectInputStream lector) {
        this.lector = lector;
    }
    
    
}
