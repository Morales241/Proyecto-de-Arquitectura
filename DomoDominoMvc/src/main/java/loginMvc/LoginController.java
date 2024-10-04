package loginMvc;

public class LoginController {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModell, LoginView loginView) {
        this.loginModel = loginModell;
        this.loginView = loginView;

        loginView.agregarObservador((String estado) -> {
            loginModel.iniciarSesion();
        });
    }  
}
