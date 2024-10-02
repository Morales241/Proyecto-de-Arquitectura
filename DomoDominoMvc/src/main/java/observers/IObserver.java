package observers;

import comands.IComando;

public interface IObserver {
    
    public void actualizar(IComando comando);
    
}
