package observers;

public interface IObservable {
    public void agregarObservador(IObserver observador);
    
    public void eliminarObservador(IObserver observador);
    
    public void notificarObservadores(String mensaje);
    
}
