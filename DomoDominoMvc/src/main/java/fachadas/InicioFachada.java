package fachadas;

import fachadasInterfaz.IInicioFachada;
import InicioMvc.InicioModel;
import eventos.IEventoValidacionDeNombre;
import eventos.IObserver;

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
