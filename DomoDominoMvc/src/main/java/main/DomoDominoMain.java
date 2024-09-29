package main;

import controler.LoginControler;
import model.LoginModel;
import view.LoginView;

public class DomoDominoMain {

    public static void main(String[] args) {
        LoginModel ddm = new LoginModel();
        LoginView ddv = new LoginView(ddm);
        LoginControler lc = new LoginControler(ddm, ddv);
        
        ddv.setVisible(true);
    }
    
}
