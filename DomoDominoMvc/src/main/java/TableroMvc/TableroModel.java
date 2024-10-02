package TableroMvc;

import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;
import pozo.Pozo;

public class TableroModel implements IObservable {
    
    private Pozo pozo;
    private int numeroFichas;
    private List<IObserver> observadores = new ArrayList<>();
    
    public void repartirFichas(){
        pozo = new Pozo(numeroFichas);
        pozo.repartirFichas();
    }
    
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
