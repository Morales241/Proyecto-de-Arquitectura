package TableroMvc;

import java.util.ArrayList;
import java.util.List;
import Entidades.Ficha;
import Entidades.Pozo;
import observers.IObservableString;
import observers.IObserverString;

public class TableroModel implements IObservableString {
    
    private Pozo pozo;
    private int numeroFichas = 7;
    private List<Ficha> fichas;
    private List<IObserverString> observadores = new ArrayList<>();

    public TableroModel() {
        pozo = new Pozo(numeroFichas); 
    }

    public void repartirFichas(){
        fichas = pozo.repartirFichas();
      
        notificarObservadores("repartirFicha");
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    @Override
    public void agregarObservador(IObserverString observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserverString observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        observadores.forEach(IObserver -> {
            IObserver.actualizar(mensaje);
        });
    }
    
    
}
