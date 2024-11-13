package crearPartida;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import observers.IEventoCrearPartidaMVC;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class CrearMesaModel {

    private IEventoCrearPartidaMVC observerCrearPartida;
    private IObserver observerNombreInvalido;

    public CrearMesaModel() {
    }

    public void validarNombre(String nombre) {
        Pattern validacion = Pattern.compile("^[A-Za-z0-9_]{3,15}$");

        Matcher match = validacion.matcher(nombre);
        if (match.matches()) {
            
            ejecutarAccionCrearPartida(nombre);
            
        }else{
        
            ejecutarAccionNombreInvalido();
        }
    }

    public void agregarIEventoNombreInvalido(IObserver listener) {
        this.observerNombreInvalido = listener;

    }

    public void ejecutarAccionNombreInvalido() {
        if (observerNombreInvalido != null) {
            observerNombreInvalido.actualizar();
        }
    }
    
    public void agregarIEventoCrearPartida(IEventoCrearPartidaMVC listener) {
        this.observerCrearPartida = listener;

    }

    public void ejecutarAccionCrearPartida(String informacion) {
        if (observerCrearPartida != null) {
            observerCrearPartida.crearPartida(informacion);
        }
    }
}
