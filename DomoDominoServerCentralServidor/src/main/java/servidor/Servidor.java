package servidor;

import eventos.EventoAcabarPartidaDto;
import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import eventos.VotoDeJugador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private ServerSocket serverSocket;
    private final List<Socket> clientesConectados;
    private final GestorMensajes gestorMensajes;

    private static final Logger log = Logger.getLogger(Servidor.class.getName());

    public Servidor(int puerto, GestorMensajes gestorMensajes) {
        this.gestorMensajes = gestorMensajes;
        clientesConectados = new ArrayList<>();
        iniciarServidor(puerto);
    }

    private void iniciarServidor(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            new Thread(new Oyente()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Oyente implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Socket cliente = serverSocket.accept();
                    clientesConectados.add(cliente);
                    new Thread(new Receptor(cliente)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Receptor implements Runnable {

        private Socket cliente;
        private ObjectInputStream lector;

        public Receptor(Socket cliente) {
            this.cliente = cliente;
            try {
                lector = new ObjectInputStream(cliente.getInputStream());
            } catch (IOException e) {
            }
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
                    
                    case VotoDeJugador votoDeJugador ->
                        gestorMensajes.notificarObserverIniciarPartida(votoDeJugador);
                        
                    case EventoAcabarPartidaDto acabarPartidaDto ->
                        gestorMensajes.notificarObserverAcabarPartida(acabarPartidaDto);
                    default ->
                        log.log(Level.INFO, "Tipo de mensaje no reconocido");
                }
                log.log(Level.INFO, "Método: run - Clase: Servidor - Proyecto: Server de Server Central");
            }

        }

        public Object obtenerMensaje() {
            Object mensaje = null;
            try {
                mensaje = lector.readObject();
                log.log(Level.INFO, "Llegó un mensaje");
            } catch (IOException | ClassNotFoundException ex) {
                log.log(Level.SEVERE, "Error al leer el mensaje", ex);
            }
            return mensaje;

        }
    }


}
