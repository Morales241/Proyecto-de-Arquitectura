package loginMvc;

import comands.IComando;
import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class LoginModel implements IObservable {

    private String nombre, contra;
    private String validaNombre, validarContra;

    private List<IObserver> observadores = new ArrayList<>();

    public LoginModel(String validaNombre, String validaContra) {
       this.validaNombre = validaNombre;
       this.validarContra = validaContra;
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

    public void iniciarSesion(){
        if(nombre.equals(validaNombre) && contra.equals(validarContra)){
            notificarObservadores();
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
    public void notificarObservadores(IComando comando) {
        observadores.forEach(IObserver -> {
            IObserver.actualizar();
        });
    }

}
