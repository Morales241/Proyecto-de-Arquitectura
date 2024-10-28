package cliente;

import java.util.logging.Logger;
import observers.IObserverString;

public class GestorMensajes {
    private IObserverString observerMensaje;
    private static final Logger log = Logger.getLogger(GestorMensajes.class.getName());

    public GestorMensajes() {
    }

    public void agregarObservador(IObserverString observador) {
        this.observerMensaje = observador;
    }

    public void eliminarObservador(IObserverString observador) {
        this.observerMensaje = null;
    }

    public void notificarObservadores(String mensaje) {
        if (observerMensaje != null) {
            observerMensaje.actualizar(mensaje);
            log.info("va a notificar esto: " + mensaje);
        }
    }
}
