package serverInterno;

import java.util.logging.Level;
import java.util.logging.Logger;
import observers.IEventoJugada;
import serializables.Jugada;

public class GestorMensajes {
    private IEventoJugada observerMensaje;
    private static final Logger log = Logger.getLogger(GestorMensajes.class.getName());

    public GestorMensajes() {
    }

    public void agregarObservador(IEventoJugada observador) {
        this.observerMensaje = observador;
    }

    public void eliminarObservador(IEventoJugada observador) {
        this.observerMensaje = null;
    }

    public void notificarObservadores(Jugada jugada) {
        if (observerMensaje != null) {
            observerMensaje.actualizar(jugada);
            log.log(Level.INFO, "va a notificar esto: ", jugada);
        }
    }
}
