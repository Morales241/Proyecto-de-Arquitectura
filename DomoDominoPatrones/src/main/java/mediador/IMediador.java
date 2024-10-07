package mediador;

import contenedor.ContenedorMvc;
import javax.swing.JFrame;

public interface IMediador<M, V extends JFrame, C> {
    public void registrarPantalla(String nombre, ContenedorMvc<M, V, C> contenedorMvc);
    public void mostrarPantallaConcreta(String nombre);
}
