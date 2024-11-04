package TableroMvc;

import java.util.ArrayList;
import java.util.List;
import dtos.FichaDto;
import observers.IObservable;
import observers.IObserver;
import observers.IObserverFicha;

public class TableroModel  {

    private int numeroFichas = 7;
    private List<FichaDto> fichas;
    private List<IObserver> observadores = new ArrayList<>();
    private FichaDto fichaSeleccionada;
    private IObserverFicha listenerFicha;

    public TableroModel() {
        
    }

    public void repartirFichas(List<FichaDto> fichas) {
        this.fichas = fichas;
        notificarObservadores();
    }

    public void agregarIObserverFicha(IObserverFicha listener) {
        this.listenerFicha = listener;
    }

    public void ejecutarAccionPonerFicha() {
        if (listenerFicha != null) {
            listenerFicha.actualizar(fichaSeleccionada);
        }
    }

    public List<FichaDto> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaDto> fichas) {
        this.fichas = fichas;
    }

    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        observadores.forEach(IObserver -> {
            IObserver.actualizar();
        });
    }

    public void actualizarFichaSelecionada(FichaDto fichaSelect) {
        this.fichaSeleccionada = fichaSelect;
    }
}
