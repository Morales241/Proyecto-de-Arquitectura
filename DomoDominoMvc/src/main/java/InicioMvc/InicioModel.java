package InicioMvc;

import observers.IEventoJugar;
import observers.IEventoValidacionDeNombre;
public class InicioModel {
    
    private IEventoJugar listenerJugar;
    private IEventoValidacionDeNombre listenervalidacion;
    
    public InicioModel() {
    }

    public void agregarIEventoJugar(IEventoJugar  listener) {
        this.listenerJugar = listener;
    }
    
    public void ejecutarAccionJugar(String nombre){
        if (listenerJugar != null) {
            listenerJugar.validarNombreParaJugar(nombre);
            System.out.println("Se va a validar el nombre");
        }
    }
    
    public void agregarIEventoValidacionDeNombre(IEventoValidacionDeNombre listener){
        this.listenervalidacion = listener;
    }
    
    public void ejecutarAccionValidar(String mensaje){
        if (listenervalidacion != null) {
            listenervalidacion.validacionDeNombre(mensaje);
        }
    }
}
