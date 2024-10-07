package signInMvc;

import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;
import dtos.UsuarioDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInModel implements IObservable {

    private List<IObserver> observadores = new ArrayList<>();
    private String nombre, contra, correo;
    private ActionListener listenerRegistro;

    public SignInModel() {

    }
    
    public void agregarActionListenerRegistro(ActionListener listener) {
        this.listenerRegistro = listener;
    }

    public void ejecutarAccionRegistro(){
        
        if (listenerRegistro != null) {
            listenerRegistro.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Accion"));
        }
    }

    public UsuarioDto encapsulamiento() {
        UsuarioDto usuario = new UsuarioDto(correo, contra, nombre);
        return usuario;
    }

    public void registrarse() {

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
