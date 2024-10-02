package signInMvc;

import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class SignInModel implements IObservable {

    private List<IObserver> observadores = new ArrayList<>();
    private String nombre, contra;
    
    public SignInModel() {
        
    }
    
    public void registrarse(){
        //logica de registrarse, probablemente solo llame a un control y que el lo haga, pero eso va aqui    
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
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
