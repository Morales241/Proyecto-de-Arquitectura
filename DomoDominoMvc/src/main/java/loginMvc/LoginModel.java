package loginMvc;

import dtos.UsuarioDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class LoginModel implements IObservable {

    private String correo, contra;
    private final List<IObserver> observadores = new ArrayList<>();
    private ActionListener listenerIniciarSesion;
    private ActionListener listenerRegistro;

    public LoginModel() {
        
    }

    public void agregarActionListenerIniciarSesion(ActionListener listener) {
        this.listenerIniciarSesion = listener;
        
    }
    
    public void ejecutarAccionIniciarSesion(){
        
        if (listenerIniciarSesion != null) {
            listenerIniciarSesion.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Accion"));
        }
    }
    
    public void agregarActionListenerRegistro(ActionListener listener) {
        this.listenerRegistro = listener;
    }

    public void ejecutarAccionRegistro(){
        
        if (listenerRegistro != null) {
            listenerRegistro.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Accion"));
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
