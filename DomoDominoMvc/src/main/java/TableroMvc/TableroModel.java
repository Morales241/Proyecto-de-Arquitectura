package TableroMvc;

import java.util.ArrayList;
import java.util.List;
import Entidades.Ficha;
import Entidades.Pozo;
import observers.IObservable;
import observers.IObserver;
import observers.IObserverString;

public class TableroModel implements IObservable {
    
    private Pozo pozo;
    private int numeroFichas = 7;
    private List<Ficha> fichas;
    private List<IObserver> observadores = new ArrayList<>();

    public TableroModel() {
        pozo = new Pozo(numeroFichas); 
    }

    public void repartirFichas(){
        fichas = pozo.repartirFichas();
      
        notificarObservadores();
    }
    
    public void accion(){
        //accion de acualizacion
    } 

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
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
    public void notificarObservadores() {
        observadores.forEach(IObserver -> {
            IObserver.actualizar();
        });
    }
    
    
}
