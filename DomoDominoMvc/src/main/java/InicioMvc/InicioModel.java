package InicioMvc;

import observers.IObserver;

public class InicioModel {

    private IObserver observerCrearPartida;
    private IObserver observerUnirsePartida;

    public InicioModel() {
    }

    public void agregarIEventoCrearPartida(IObserver listener) {
        this.observerCrearPartida = listener;
    }

    public void ejecutarAccionCrearPartida() {
        if (observerCrearPartida != null) {
            observerCrearPartida.actualizar();
        }
    }

    public void agregarIEventoUnirseAPartida(IObserver listener) {
        this.observerUnirsePartida = listener;
    }

    public void ejecutarAccionUnirseAPartida() {
        if (observerUnirsePartida != null) {
            observerUnirsePartida.actualizar();
        }

    }

}
