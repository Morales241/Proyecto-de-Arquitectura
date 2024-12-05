package cliente;

import eventos.NodoDto;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
//server interno

public class Cliente {

    private Socket socket;
    private static final Logger log = Logger.getLogger(Cliente.class.getName());
    private final Map<String, ObjectOutputStream> nodosConectados;

    public Cliente() {
        nodosConectados = new HashMap<>();
    }

    public void conectarAServidor(String nombre, NodoDto nodo) {
        try {
            ObjectOutputStream escritor;
            socket = new Socket(nodo.getIp(), nodo.getPuerto());
            escritor = new ObjectOutputStream(socket.getOutputStream());
            nodosConectados.put(nombre, escritor);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(Object mensaje, String nombreNodo) {

        ObjectOutputStream escritor = nodosConectados.get(nombreNodo);
        if (escritor != null) {
            try {
                escritor.writeObject(mensaje);
                escritor.flush();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void enviarMensajesACompañeros(Object mensaje) {

        nodosConectados.forEach((nombre, output) -> {
            if (!nombre.equals("serverCentral")) {
                
                if (output != null) {
                    try {
                        output.writeObject(mensaje);
                        output.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    public void cerrarConexion(String nombreNodo) {
        
        nodosConectados.remove(nombreNodo);
    }
}
