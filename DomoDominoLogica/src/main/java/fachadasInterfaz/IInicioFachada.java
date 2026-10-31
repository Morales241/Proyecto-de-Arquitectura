package fachadasInterfaz;

import eventos.IEventoIrACrearPartida;
import eventos.IEventoIrAUnirseAPartida;

/**
 * Interfaz para la Fachada del Inicio del juego.
 */
public interface IInicioFachada {

    /**
     * Método para agregar un observador al modelo de unirse a partida.
     *
     * @param observer El observador que se agregará.
     */
    void agregarEventoIrACrearPartida(IEventoIrACrearPartida observer);
    
    /**
     * Método para agregar un observador al modelo de crear partida.
     *
     * @param observer El observador que se agregará.
     */
    void agregarEventoIrAUnirseAPartida(IEventoIrAUnirseAPartida observer);
}
