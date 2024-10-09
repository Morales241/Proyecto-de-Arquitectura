package loginMvc;

import dtos.UsuarioDto;
import java.util.ArrayList;
import java.util.List;
import observers.IObservableString;
import observers.IObserverString;
import observers.IObserverUsuarioDto;

public class LoginModel implements IObservableString {

    private String correo, contra;
    private final List<IObserverString> observadores = new ArrayList<>();
    private IObserverUsuarioDto listenerIniciarSesion;
    private IObserverUsuarioDto listenerRegistro;

    public LoginModel() {
        
    }

    public void agregarIObserverUsuarioDtoIniciarSesion(IObserverUsuarioDto listener) {
        this.listenerIniciarSesion = listener;
        
    }
    
    public void ejecutarAccionIniciarSesion(){
        if (listenerIniciarSesion != null) {
            listenerIniciarSesion.actualizar(encapsulamiento());
        }
    }
    
    public void agregarIObserverUsuarioDtoRegistro(IObserverUsuarioDto listener) {
        this.listenerRegistro = listener;
    }

    public void ejecutarAccionRegistro(){
        if (listenerRegistro != null) {
            listenerRegistro.actualizar(encapsulamiento());
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public UsuarioDto encapsulamiento() {
        UsuarioDto usuario = new UsuarioDto(correo, contra);
        return usuario;
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
