package fachadas;

import observers.IEventoValidacionDeNombre;

/**
 * Interfaz para la Fachada del Inicio del juego.
 */
public interface IInicioFachada {

    /**
     * Método para agregar un observador al modelo de inicio del juego.
     *
     * @param observer El observador que se agregará.
     */
    void agregarIObserverJugar(IEventoValidacionDeNombre observer);

    public void mandarMensajeNombreInvalido(String mensaje);
}
