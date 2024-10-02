package mediador;

import javax.swing.JFrame;

public interface IMediador {
    public void registrarView(String nombre, JFrame view);
    public void mostrarViewConcreta(String nombre);
}
