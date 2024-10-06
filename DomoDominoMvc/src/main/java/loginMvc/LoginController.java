package loginMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModell, LoginView loginView) {
        this.loginModel = loginModell;
        this.loginView = loginView;

        loginView.btnInciarSecion(new oyenteIniciarSesion());
        
        loginView.btnRegistrarse(new oyenteRegistrarse());
    }  
    
    public void iniciarSesion(){
        loginModel.iniciarSesion();
    }
    
    public void registrarCuenta(){
        //logica para registrar 
    }
    
    private class oyenteIniciarSesion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            iniciarSesion();
        }
    
    }  
    
    private class oyenteRegistrarse implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            registrarCuenta();
        }
    
    }
}
