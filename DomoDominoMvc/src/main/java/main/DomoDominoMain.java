package main;

import InicioMvc.InicioController;
import InicioMvc.InicioModel;
import InicioMvc.InicioView;
import TableroMvc.TableroController;
import TableroMvc.TableroModel;
import TableroMvc.TableroView;
import loginMvc.LoginControler;
import loginMvc.LoginModel;
import loginMvc.LoginView;
import mediador.Mediador;
import signInMvc.SignInControler;
import signInMvc.SignInModel;
import signInMvc.SignInView;

public class DomoDominoMain {

    public static void main(String[] args) {
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView(loginModel);
        LoginControler loginControler = new LoginControler(loginModel, loginView);
        
        SignInModel signInModel = new SignInModel();
        SignInView signInView = new SignInView(signInModel);
        SignInControler signInControler = new SignInControler(signInView, signInModel);
        
        InicioModel inicioModel = new InicioModel();
        InicioView inicioView = new InicioView(inicioModel);
        InicioController inicioController = new InicioController(inicioModel, inicioView);
        
        TableroModel tableroModel = new TableroModel();
        TableroView tableroView = new TableroView(tableroModel);
        TableroController tableroController = new TableroController(tableroModel, tableroView);
        
        //si se crean mas pantallas ponganlas aqui arriba
        
        Mediador mediador = new Mediador();
        
        mediador.registrarView("LoginView", loginView);
        mediador.registrarView("SignInView", signInView);
        mediador.registrarView("inicioView", inicioView);
        mediador.registrarView("TableroView", tableroView);
        
        loginView.setMediador(mediador);
        signInView.setMediador(mediador);
        inicioView.setMediador(mediador);
        tableroView.setMediador(mediador);
        
        inicioView.setVisible(true);
    }
    
}
