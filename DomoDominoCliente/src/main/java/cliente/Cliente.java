package cliente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverInterno.Servidor;

public class Cliente {
    private Socket socket;
    private DataOutputStream escritor;
    private final Servidor server;
    private static final Logger log = Logger.getLogger(Cliente.class.getName());

    public Cliente(Servidor servervidor) {
        
        this.server = servervidor;
    }

    public void conectarANodo(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            
            escritor = new DataOutputStream(socket.getOutputStream());
            
            server.iniciarReceptor(socket);
            
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error en la clase Cliente, metodo conectarANodo: ", e.getMessage());
        }
    }

//    public void enviarMensaje(Jugada jugada) {
//        try {
//            
//            String informacionAMandar = serializarJugada(jugada);
//            
//            byte[] jsonBytes = pasarAbites(informacionAMandar);
//            
//            escritor.writeInt(jsonBytes.length);
//            
//            escritor.write(jsonBytes);
//            
//        } catch (IOException e) {
//            log.log(Level.SEVERE, "Error en la clase Cliente, metodo enviar mensaje", e.getMessage());
//        }
//    }
//    
//    public String serializarJugada(Jugada jugada){
//         
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        
//        String json = gson.toJson(jugada);
//        
//        return json;
//    }   
//    
    public byte[] pasarAbites(String json){
        
        byte[] jsonBytes = json.getBytes();
        
        return jsonBytes;
    }
}
