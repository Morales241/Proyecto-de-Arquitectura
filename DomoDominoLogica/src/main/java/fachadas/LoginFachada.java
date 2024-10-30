package fachadas;

import loginMvc.LoginModel;
import observers.IObserverUsuarioDto;

/**
 *
 * @author Berry
 */
public class LoginFachada implements ILoginFachada {

    private final LoginModel loginModel;
    
    public LoginFachada(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    @Override
    public void agregarObserverIniciarSesion(IObserverUsuarioDto observer) {
        loginModel.agregarIObserverUsuarioDtoIniciarSesion(observer);
    }

    @Override
    public void agregarObserverRegistro(IObserverUsuarioDto observer) {
        loginModel.agregarIObserverUsuarioDtoRegistro(observer);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        loginModel.notificarObservadores(mensaje);
    }
    
}
