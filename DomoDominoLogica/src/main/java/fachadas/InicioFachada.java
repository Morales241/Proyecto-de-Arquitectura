package fachadas;

import InicioMvc.InicioModel;
import observers.IEventoValidacionDeNombre;
import observers.IObserver;

/**
 * Fachada para manejar el modelo de inicio del juego sin exponer su implementación directa.
 */
public class InicioFachada implements IInicioFachada {
    
    private final InicioModel inicioModel;
    
    public InicioFachada(InicioModel inicioModel) {
        this.inicioModel = inicioModel;        
    }

    @Override
    public void agregarIObserverCrearPartida(IObserver observer) {
        inicioModel.agregarIEventoCrearPartida(observer);
        
    }
    
    @Override
    public void agregarIObserverUnirseAPartida(IObserver observer) {
        inicioModel.agregarIEventoUnirseAPartida(observer);
        
    }
}
