package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LoginModel;
import view.LoginView;

public class LoginControler implements ActionListener{
    
    private LoginModel domoDominoModel;
    private LoginView domoDominoView;

    public LoginControler(LoginModel domoDominoModel, LoginView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;
        this.domoDominoView.getBtnIniciarSesion().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Iniciando Sesion.... (mentira nomas imprimi esto)");
    }
    
}
