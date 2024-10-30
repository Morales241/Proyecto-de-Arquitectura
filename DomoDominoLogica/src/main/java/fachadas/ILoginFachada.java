package fachadas;

import observers.IObserverUsuarioDto;

/**
 *
 * @author Berry
 */
public interface  ILoginFachada {
    void agregarObserverIniciarSesion(IObserverUsuarioDto observer);
    void agregarObserverRegistro(IObserverUsuarioDto observer);
    void notificarObservadores(String mensaje);
}
