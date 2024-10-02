package loginMvc;

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
    public void actualizar(String estado) {
        loginModel.iniciarSesion();
    }
    
    
}
