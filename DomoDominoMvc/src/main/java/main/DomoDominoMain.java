package main;

import controler.LoginControler;
import model.LoginModel;
import view.LoginView;

public class DomoDominoMain {

    public static void main(String[] args) {
        LoginModel lm = new LoginModel();
        LoginView lv = new LoginView(lm);
        LoginControler lc = new LoginControler(lm, lv);
        
        lv.setVisible(true);
    }
    
}
