package main;

import controler.DomoDominoControler;
import model.DomoDominoModel;
import view.DomoDominoView;

public class DomoDominoMain {

    public static void main(String[] args) {
        DomoDominoModel ddm = new DomoDominoModel();
        DomoDominoView ddv = new DomoDominoView(ddm);
        DomoDominoControler ddc = new DomoDominoControler(ddm, ddv);
        
        ddv.setVisible(true);
    }
    
}
