package crearPartida;

import eventos.JugadorCrearPartidaDto;
import eventos.NodoDto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class CrearPartidaModel {

    private IEventoCrearPartida observerCrearPartida;
    private IObserver observerNombreInvalido;
    private IObserver observerRegresar;

    public CrearPartidaModel() {
    }

    public void validarNombre(JugadorCrearPartidaDto jugador) {
        Pattern validacion = Pattern.compile("^[A-Za-z0-9_]{3,15}$");

        Matcher match = validacion.matcher(jugador.getNodo().getNombre());
        if (match.matches()) {
            
            ejecutarAccionCrearPartida(jugador);
            
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
    
    public void agregarIEventoCrearPartida(IEventoCrearPartida listener) {
        this.observerCrearPartida = listener;

    }

    public void ejecutarAccionCrearPartida(JugadorCrearPartidaDto jugador) {
        if (observerCrearPartida != null) {
            observerCrearPartida.crearPartida(jugador);
        }
    }
    
     public void agregarIEventoRegresar(IObserver listener) {
        this.observerRegresar = listener;

    }

    public void ejecutarAccionRegresar() {
        if (observerRegresar != null) {
            observerRegresar.actualizar();
        }
    }
}
