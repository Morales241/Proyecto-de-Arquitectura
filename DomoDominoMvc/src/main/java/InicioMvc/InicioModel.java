package InicioMvc;

import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class InicioModel  implements IObservable{
    private List<IObserver> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        observadores.forEach(IObserver -> {
            IObserver.actualizar(mensaje);
        });
    }
     
     
}
