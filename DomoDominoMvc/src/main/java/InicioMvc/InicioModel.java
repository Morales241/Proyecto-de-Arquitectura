package InicioMvc;

import eventos.IEventoIrACrearPartida;
import eventos.IEventoIrAUnirseAPartida;

public class InicioModel {

    private IEventoIrACrearPartida observerCrearPartida;
    private IEventoIrAUnirseAPartida observerUnirsePartida;

    public InicioModel() {
    }

    public void agregarIEventoCrearPartida(IEventoIrACrearPartida listener) {
        this.observerCrearPartida = listener;
    }

    public void ejecutarAccionCrearPartida() {
        if (observerCrearPartida != null) {
            observerCrearPartida.irACrearPartida();
        }
    }

    public void agregarIEventoUnirseAPartida(IEventoIrAUnirseAPartida listener) {
        this.observerUnirsePartida = listener;
    }

    public void ejecutarAccionUnirseAPartida() {
        if (observerUnirsePartida != null) {
            observerUnirsePartida.irAUnirseAPartida();
        }

    }

}
