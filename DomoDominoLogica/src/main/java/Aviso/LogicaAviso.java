package Aviso;

import fachadas.AvisoFachada;
import mediador.Mediador;

/**
 *
 * @author tacot
 */
public class LogicaAviso implements ILogicaAviso{

    private final AvisoFachada avisoFachada;
    private final Mediador mediador;

    public LogicaAviso(AvisoFachada avisoFachada) {
        this.avisoFachada = avisoFachada;
        this.mediador = Mediador.getInstancia();
    }

    @Override
    public void cerrarAviso() {
        mediador.cerrarPantallaConcreta("aviso");
    }

    @Override
    public void mostrarAviso(String mensaje) {
        avisoFachada.mostrarAviso(mensaje);
        mediador.MostrarAviso();
    }
    
}
