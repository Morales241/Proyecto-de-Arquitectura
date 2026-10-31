package fachadas;

import fachadasInterfaz.IInicioFachada;
import InicioMvc.InicioModel;
import eventos.IEventoValidacionDeNombre;
import eventos.IEventoIrACrearPartida;
import eventos.IEventoIrAUnirseAPartida;

/**
 * Fachada para manejar el modelo de inicio del juego sin exponer su implementación directa.
 */
public class InicioFachada implements IInicioFachada {
    
    private final InicioModel inicioModel;
    
    public InicioFachada(InicioModel inicioModel) {
        this.inicioModel = inicioModel;        
    }

    @Override
    public void agregarEventoIrACrearPartida(IEventoIrACrearPartida observer) {
        inicioModel.agregarIEventoCrearPartida(observer);
        
    }
    
    @Override
    public void agregarEventoIrAUnirseAPartida(IEventoIrAUnirseAPartida observer) {
        inicioModel.agregarIEventoUnirseAPartida(observer);
        
    }
}
