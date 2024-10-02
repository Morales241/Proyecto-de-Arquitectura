package loginMvc;

public class LoginControler {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginControler(LoginModel loginModell, LoginView loginView) {
        this.loginModel = loginModell;
        this.loginView = loginView;

        loginView.agregarObservador((String estado) -> {
            loginModel.iniciarSesion();
        });
    }  
}
