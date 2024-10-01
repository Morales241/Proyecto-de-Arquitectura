package loginMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import observers.IObserver;

public class LoginControler implements IObserver {

    private LoginModel domoDominoModel;
    private LoginView domoDominoView;
    private boolean estado;

    public LoginControler(LoginModel domoDominoModel, LoginView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;

        domoDominoView.agregarObservador(this);
    }

    @Override
    public void actualizar() {
    }
    
    
}
