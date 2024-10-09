package InicioMvc;

import java.util.ArrayList;
import java.util.List;
import observers.IObservableString;
import observers.IObserver;
import observers.IObserverString;

public class InicioModel  implements IObservableString{
    private List<IObserverString> observadores = new ArrayList<>();
    private IObserver listenerJugar;
    
    public InicioModel() {
    }

    public void agregarIObserverJugar(IObserver  listener) {
        this.listenerJugar = listener;
    }
    
    public void ejecutarAccionJugar(){
        System.out.println("entro a ejecutarAccionjuGAR");
        if (listenerJugar != null) {
            
            listenerJugar.actualizar();
        }
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
