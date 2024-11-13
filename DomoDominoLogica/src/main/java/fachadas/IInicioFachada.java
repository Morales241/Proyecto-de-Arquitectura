package fachadas;

import observers.IObserver;

/**
 * Interfaz para la Fachada del Inicio del juego.
 */
public interface IInicioFachada {

    /**
     * Método para agregar un observador al modelo de unirse a partida.
     *
     * @param observer El observador que se agregará.
     */
    void agregarIObserverCrearPartida(IObserver observer);
    
    /**
     * Método para agregar un observador al modelo de crear partida.
     *
     * @param observer El observador que se agregará.
     */
    void agregarIObserverUnirseAPartida(IObserver observer);
}
