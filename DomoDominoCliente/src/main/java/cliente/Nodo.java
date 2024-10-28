package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IObserverString;

public class Nodo {
    private Socket socket;
    private ServerSocket serverSocket;
    private List<Socket> nodosConectados;
    private IObserverString observerMensaje;
    private BufferedReader lector;
    private PrintWriter escritor;

    public Nodo(int puerto) {
        nodosConectados = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(puerto);
            new Thread(new Oyente()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void conectarANodo(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            nodosConectados.add(socket);
            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            escritor = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new Receptor(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarObservador(IObserverString observador) {
        this.observerMensaje = observador;
    }

    public void eliminarObservador(IObserverString observador) {
        this.observerMensaje = null;
    }

    public void notificarObservadores(String mensaje) {
        if (observerMensaje != null) {
            observerMensaje.actualizar(mensaje);
        }
    }

    public void enviarMensaje(String mensaje) {
        for (Socket nodo : nodosConectados) {
            try {
                escritor.println(mensaje);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class Oyente implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Socket nodo = serverSocket.accept();
                    nodosConectados.add(nodo);
                    new Thread(new Receptor(nodo)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Receptor implements Runnable {

        private Socket nodo;
        private BufferedReader lector;

        public Receptor(Socket nodo) {
            this.nodo = nodo;
            try {
                lector = new BufferedReader(new InputStreamReader(nodo.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String obtenerMensaje() throws IOException {
            String mensaje = lector.readLine();
            return mensaje != null ? mensaje : null;
        }

        @Override
        public void run() {
            try {
                String mensaje;
                while ((mensaje = obtenerMensaje()) != null) {
                    notificarObservadores(mensaje); 
                }
            } catch (IOException ex) {
                Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
