package main;

import loginMvc.LoginControler;
import loginMvc.LoginModel;
import loginMvc.LoginView;
import mediador.Mediador;
import signInMvc.SignInControler;
import signInMvc.SignInModel;
import signInMvc.SignInView;

public class DomoDominoMain {

    public static void main(String[] args) {
        LoginModel loginModel = new LoginModel("Jesus", "123");
        LoginView loginView = new LoginView(loginModel);
        LoginControler loginControler = new LoginControler(loginModel, loginView);
        
        SignInModel signInModel = new SignInModel();
        SignInView signInView = new SignInView(signInModel);
        SignInControler signInControler = new SignInControler(signInView, signInModel);
        
        //si se crean mas pantallas ponganlas aqui arriba
        
        Mediador mediador = new Mediador();
        
        mediador.registrarView("LoginView", loginView);
        mediador.registrarView("SignInView", signInView);
        
        loginView.setMediador(mediador);
        signInView.setMediador(mediador);
        
        loginView.setVisible(true);
    }
    
}
