package InicioMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class InicioModel  implements IObservable{
    private List<IObserver> observadores = new ArrayList<>();
    private ActionListener listenerJugar;
    
    public InicioModel() {
    }

    public void agregarActionListenerJugar(ActionListener listener) {
        this.listenerJugar = listener;
        
    }
    
    public void ejecutarAccionJugar(){
        
        if (listenerJugar != null) {
            listenerJugar.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Accion"));
        }
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
