package loginMvc;

import comands.IComando;
import observers.IObserver;

public class LoginControler implements IObserver {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginControler(LoginModel loginModell, LoginView loginView) {
        this.loginModel = loginModell;
        this.loginView = loginView;

        loginView.agregarObservador(this);
    }

    @Override
    public void actualizar(IComando comando) {
        if (comando != null) {
            comando.ejecutarComando();
        }
    }
    
    public void logIn(){
        loginModel.iniciarSesion();
    }
    
}
