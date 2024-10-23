package serverInterno;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GestorConexiones {
    private final List<Socket> nodosConectados;

    public GestorConexiones() {
        nodosConectados = new ArrayList<>();
    }

    public void agregarNodo(Socket nodo) {
        nodosConectados.add(nodo);
    }

    public void eliminarNodo(Socket nodo) {
        nodosConectados.remove(nodo);
    }

    public List<Socket> getNodosConectados() {
        return nodosConectados;
    }
}
