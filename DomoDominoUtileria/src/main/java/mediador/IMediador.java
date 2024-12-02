package mediador;

import contenedor.ContenedorMvc;
import javax.swing.JFrame;

public interface IMediador<M, V extends JFrame, C> {
    public void registrarPantalla(String nombre, ContenedorMvc<M, V, C> contenedorMvc);
    public ContenedorMvc<M, V, C> obtenerPantallaConcreta(String nombre);
    public void mostrarPantallaConcreta(String nombre);
    public void cerrarPantallaConcreta(String nombre);
    public void MostrarAviso();
}
