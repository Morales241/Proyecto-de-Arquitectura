package crearPartida;

import eventos.JugadorCrearPartidaDto;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IObserver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Modelo de la partida que gestiona la creación de la partida, validación de nombre, y cambio de avatares.
 */
public class CrearPartidaModel {
  
    private final String[] rutasAvatares = {
        "/imgPartidaFichas/avatar1.png",
        "/imgPartidaFichas/avatar2.png",
        "/imgPartidaFichas/avatar3.png",
        "/imgPartidaFichas/avatar4.png"
    };
    private int indiceAvatar = 0;
    
    private IObserver observadoresCambioAvatar;
    private IEventoCrearPartida observerCrearPartida;
    private IObserver observerNombreInvalido;
    private IObserver observerRegresar;

    public CrearPartidaModel() {
    }

    // Métodos existentes para la validación de nombre y eventos
    public void validarNombre(JugadorCrearPartidaDto jugador) {
        Pattern validacion = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        Matcher match = validacion.matcher(jugador.getNombre());
        if (match.matches()) {
            ejecutarAccionCrearPartida(jugador);
        } else {
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

    // Métodos para la funcionalidad de cambio de avatar
    public String getRutaAvatarActual() {
        return rutasAvatares[indiceAvatar];
    }

    public void cambiarAvatar(int direccion) {
        indiceAvatar = (indiceAvatar + direccion + rutasAvatares.length) % rutasAvatares.length;
        notificarCambioAvatar();
    }

    public void agregarObservadorCambioAvatar(IObserver observador) {
        observadoresCambioAvatar = observador;
    }

    private void notificarCambioAvatar() {
        if(observadoresCambioAvatar != null) {
            observadoresCambioAvatar.actualizar();
        }
    }
}
