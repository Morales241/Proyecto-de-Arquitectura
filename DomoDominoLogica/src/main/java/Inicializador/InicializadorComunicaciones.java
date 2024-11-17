package Inicializador;

import cliente.GestorDeComunicaciones;
import serverInterno.GestorMensajes;
import serverInterno.Servidor;

/**
 *
 * @author Jesus Morales
 */
public class InicializadorComunicaciones {

    private GestorMensajes gestorMensajes;
    private GestorDeComunicaciones comunicaciones;
    private Servidor servidor;

    public InicializadorComunicaciones() {
    }

    public void inicializarClasesComunicaciones() {
        comunicaciones = new GestorDeComunicaciones();
        comunicaciones.crearServidor(8097);
    }
    
    public GestorDeComunicaciones getComunicaciones() {
        return comunicaciones;
    }

}
