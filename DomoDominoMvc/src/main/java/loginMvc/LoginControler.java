package loginMvc;

import observers.IObserver;

public class LoginControler implements IObserver {

    private LoginModel domoDominoModel;
    private LoginView domoDominoView;

    public LoginControler(LoginModel domoDominoModel, LoginView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;

        domoDominoView.agregarObservador(this);
    }

    @Override
    public void actualizar() {
        domoDominoModel.iniciarSesion();
    }
    
    
}
