package Aviso;

import fachadasInterfaz.IAvisoFachada;
import mediador.IMediador;

/**
 *
 * @author tacot
 */
public class LogicaAviso implements ILogicaAviso{

    private final IAvisoFachada avisoFachada;
    private final IMediador mediador;

    public LogicaAviso(IAvisoFachada avisoFachada, IMediador mediador) {
        this.avisoFachada = avisoFachada;
        this.mediador = mediador;
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
