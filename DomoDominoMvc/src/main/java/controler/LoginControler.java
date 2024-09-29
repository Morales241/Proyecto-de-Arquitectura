package controler;

import model.LoginModel;
import view.LoginView;

public class LoginControler {
    
    private LoginModel domoDominoModel;
    private LoginView domoDominoView;

    public LoginControler(LoginModel domoDominoModel, LoginView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;
    }
    
}
