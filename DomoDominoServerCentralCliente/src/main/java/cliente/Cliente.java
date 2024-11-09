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
    private ObjectInputStream lector;
    private final Servidor server;
    private static final Logger log = Logger.getLogger(Cliente.class.getName());

    public Cliente(Servidor servervidor) {

        this.server = servervidor;
    }

    public void conectarANodo(String ip, int puerto) {
    try {
        log.log(Level.INFO, "Intentando conectar al nodo: " + ip + ":" + puerto);

        socket = new Socket(ip, puerto);
        log.log(Level.INFO, "Socket creado");

        escritor = new ObjectOutputStream(socket.getOutputStream());
        escritor.flush();
        log.log(Level.INFO, "ObjectOutputStream creado y vaciado en el cliente");
//
//        lector = new ObjectInputStream(socket.getInputStream());
//        log.log(Level.INFO, "ObjectInputStream creado en el cliente");
//        
//        server.iniciarReceptor(socket);
//        log.log(Level.INFO, "Receptor iniciado");

    } catch (IOException e) {
        log.log(Level.SEVERE, "Error en la clase Cliente, método conectarANodo: ", e);
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
