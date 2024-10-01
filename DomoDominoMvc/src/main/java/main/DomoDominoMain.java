package main;

import loginMvc.LoginControler;
import loginMvc.LoginModel;
import loginMvc.LoginView;

public class DomoDominoMain {

    public static void main(String[] args) {
        LoginModel loginModel = new LoginModel("Jesus", "123");
        LoginView loginView = new LoginView(loginModel);
        LoginControler loginControler = new LoginControler(loginModel, loginView);
        
        loginView.setVisible(true);
    }
    
}
