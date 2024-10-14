package TableroMvc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableroController {
    
    private TableroModel tableroModel;
    private TableroView tableroView;

    public TableroController(TableroModel tableroModel, TableroView tableroView) {
        this.tableroModel = tableroModel;
        this.tableroView = tableroView;

        this.tableroView.agregarOyenteMouse(new ponerFichaEnTablero());
        
    }
    
    public void colocarFichaEnTablero(){
        tableroView.actualizarFichaSelecionada();
        tableroModel.ejecutarAccionPonerFicha();
    }
    
    private class ponerFichaEnTablero extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            
            colocarFichaEnTablero();
        }
        
    }
}
