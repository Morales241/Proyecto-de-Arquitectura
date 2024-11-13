package InicioMvc;

import observers.IEventoJugar;
import observers.IEventoValidacionDeNombre;

/**
 * Modelo de inicio
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
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
