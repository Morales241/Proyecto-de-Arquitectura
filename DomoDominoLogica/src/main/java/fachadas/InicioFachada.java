package fachadas;

import InicioMvc.InicioModel;
import observers.IObserver;

/**
 * Fachada para manejar el modelo de inicio del juego sin exponer su implementación directa.
 */
public class InicioFachada implements IInicioFachada {

    private InicioModel inicioModel;

    public InicioFachada(InicioModel inicioModel) {
        this.inicioModel = inicioModel; 
    }

    @Override
    public void agregarIObserverJugar(IObserver observer) {
        inicioModel.agregarIObserverJugar(observer);
    }
}
