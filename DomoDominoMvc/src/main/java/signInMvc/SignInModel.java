package signInMvc;

import comands.IComando;
import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;
import registrarUsuario.LogicaRegistrar;
import registrarUsuario.UsuarioDto;

public class SignInModel implements IObservable {

    private List<IObserver> observadores = new ArrayList<>();
    private String nombre, contra,correo;
    private LogicaRegistrar logicaRegistrar;
    
    
    public SignInModel() {
        
    }
    public UsuarioDto encapsulamiento(){
       UsuarioDto usuario = new UsuarioDto(correo,contra,nombre);
        return usuario;
    }
    public boolean registrarse(){
        return logicaRegistrar.registrarUsuario(encapsulamiento());
        
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
    public void notificarObservadores(IComando comando) {
        observadores.forEach(IObserver -> {
            IObserver.actualizar(comando);
        });
    }
    
}
