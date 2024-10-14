package TableroMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroController {
    
    private TableroModel tableroModel;
    private TableroView tableroView;

    public TableroController(TableroModel tableroModel, TableroView tableroView) {
        this.tableroModel = tableroModel;
        this.tableroView = tableroView;

    }
    
    public void accion(){
        tableroModel.accion();
    }
    
    private class AccionTablero implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            accion();
        }
    
    }
}
