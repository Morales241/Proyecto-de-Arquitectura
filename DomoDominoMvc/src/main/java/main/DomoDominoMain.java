package main;

import controler.LoginControler;
import model.LoginModel;
import view.LoginView;

public class DomoDominoMain {

    public static void main(String[] args) {
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView(loginModel);
        LoginControler loginControler = new LoginControler(loginModel, loginView);
        
        loginView.setVisible(true);
    }
    
}
