package cliente;

import eventos.JugadorConsulta;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.Servidor;

public class Cliente {

    private Socket socket;
    private ObjectOutputStream escritor;
    private final Servidor server;
    private static final Logger log = Logger.getLogger(Cliente.class.getName());

    public Cliente(Servidor servervidor) {

        this.server = servervidor;
    }

    public void conectarANodo(String ip, int puerto) {
        
            try {
                socket = new Socket(ip, puerto);

                escritor = new ObjectOutputStream(socket.getOutputStream());
                escritor.flush();
                server.iniciarReceptor(socket);
                
                log.log(Level.INFO, "se conecto al nodo: " + ip, ip);

            } catch (IOException e) {
                log.log(Level.SEVERE, "Error en la clase Cliente, metodo conectarANodo: ", e);
            }

    }

    public void enviarMensaje(Object mensaje) {
        try {

            escritor.writeObject(mensaje);
            escritor.flush();
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error en la clase Cliente, metodo enviar mensaje", e.getMessage());
        }
    }

}
