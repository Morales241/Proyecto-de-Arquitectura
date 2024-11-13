package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private Socket socket;
    private ObjectOutputStream escritor;
    private ObjectInputStream lector;
    private static final Logger log = Logger.getLogger(Cliente.class.getName());

    public Cliente() {

    }

    public void conectarAServidor(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            escritor = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(Object mensaje) {
        if (escritor != null) {
            try {
                escritor.writeObject(mensaje);
                escritor.flush();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cerrarConexion() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
        }
    }
}
