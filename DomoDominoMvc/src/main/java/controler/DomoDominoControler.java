package controler;

import model.DomoDominoModel;
import view.DomoDominoView;

public class DomoDominoControler {
    
    private DomoDominoModel domoDominoModel;
    private DomoDominoView domoDominoView;

    public DomoDominoControler(DomoDominoModel domoDominoModel, DomoDominoView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;
    }
    
}
