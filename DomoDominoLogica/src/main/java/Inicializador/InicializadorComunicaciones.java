package Inicializador;

import fachadas.GestorDeComunicacionesFachada;
import fachadasInterfaz.IGestorDeComunicacionesFachada;

/**
 * Inicializador Comunicaciones
 * 
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class InicializadorComunicaciones {

    private IGestorDeComunicacionesFachada comunicaciones;

    public InicializadorComunicaciones() {
    }

    public void inicializarClasesComunicaciones() {
        comunicaciones = new GestorDeComunicacionesFachada();
        comunicaciones.crearServidor(8097);
    }
    
    public GestorDeComunicacionesFachada getComunicaciones() {
        return (GestorDeComunicacionesFachada) comunicaciones;
    }

}
