package contenedor;

import javax.swing.JFrame;

/**
 * Clase que encapsula en un contenedor un MVC
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 * @param <M> Clase Modelo
 * @param <V> Clase Vista
 * @param <C> Clase Controlador
 */
public class ContenedorMvc<M, V extends JFrame, C> {
    private M modelo;
    private V vista;
    private C controlador;

    public ContenedorMvc(M modelo, V vista, C controlador) {
        this.modelo = modelo;
        this.vista = vista;
        this.controlador = controlador;
    }

    public M getModelo() {
        return modelo;
    }

    public V getVista() {
        return vista;
    }

    public C getControlador() {
        return controlador;
    }
}
