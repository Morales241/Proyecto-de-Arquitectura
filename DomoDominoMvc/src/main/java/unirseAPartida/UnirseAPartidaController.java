/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unirseAPartida;

import eventos.JugadorUnirseAPartidaDto;
import observers.IEventoSeleccion;
import observersLogicaAServidorCentral.IEventoAgregarJugadorAPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class UnirseAPartidaController {

    private final UnirseAPartidaModel unirseAPartidaModel;
    private final UnirseAPartidaView unirseAPartidaView;

    public UnirseAPartidaController(UnirseAPartidaModel unirseAPartidaModel, UnirseAPartidaView unirseAPartidaView) {
        this.unirseAPartidaModel = unirseAPartidaModel;
        this.unirseAPartidaView = unirseAPartidaView;
        this.unirseAPartidaView.agregarIEventoRegresar(new accionRegresar());
        this.unirseAPartidaView.agregarIEventoUnirseAPartida(new accionUnirseAPartida());
        this.unirseAPartidaView.agregarIEventoSeleccionIzquierda(new accionSeleccionIzquierda());
        this.unirseAPartidaView.agregarIEventoSeleccionDerecha(new accionSeleccionDerecha());
    }

    public void validarNombre(JugadorUnirseAPartidaDto jugador) {
        unirseAPartidaModel.validarNombre(jugador);
    }

    public void regresar() {
        unirseAPartidaModel.ejecutarAccionRegresar();
    }

    private class accionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {
            validarNombre(jugador);
        }

    }

    private class accionRegresar implements IObserver {

        @Override
        public void actualizar() {
            regresar();
        }
    }

    private class accionSeleccionIzquierda implements IEventoSeleccion {

        @Override
        public void actualizarAvatar() {
            cambiarAvatar(-1);
        }

    }

    private class accionSeleccionDerecha implements IEventoSeleccion {

        @Override
        public void actualizarAvatar() {
            cambiarAvatar(+1);
        }

    }
    
    public void cambiarAvatar(int direccion) {
        unirseAPartidaModel.cambiarAvatar(direccion);
    }
}
