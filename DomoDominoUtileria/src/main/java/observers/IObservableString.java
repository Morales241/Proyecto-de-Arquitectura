package observers;

public interface IObservableString {
    
    public void agregarObservador(IObserverString observador);
    
    public void eliminarObservador(IObserverString observador);
    
    public void notificarObservadores(String estado);
}
