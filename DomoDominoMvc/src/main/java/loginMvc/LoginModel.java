package loginMvc;

import dtos.UsuarioDto;
import iniciarSesion.LogicaIniciarSesion;
import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class LoginModel implements IObservable {

    private String correo, contra;
    private List<IObserver> observadores = new ArrayList<>();
    private LogicaIniciarSesion logicaIniciarSesion;

    public LoginModel() {
        logicaIniciarSesion = new LogicaIniciarSesion(); 
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

    public void iniciarSesion(){
        if(logicaIniciarSesion.iniciarSesion(encapsulamiento())){
            notificarObservadores("Login exitoso");
        }
        else{
            notificarObservadores("Error: Usuario o contraseña incorrectos");
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
