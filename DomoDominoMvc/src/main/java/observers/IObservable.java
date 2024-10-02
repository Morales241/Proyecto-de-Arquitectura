package observers;

import comands.IComando;

public interface IObservable {
    public void agregarObservador(IObserver observador);
    
    public void eliminarObservador(IObserver observador);
    
    public void notificarObservadores(IComando comando);
    
}
