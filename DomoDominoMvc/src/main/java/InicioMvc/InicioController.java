package InicioMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InicioController{
    
    private InicioModel inicioModel;
    private InicioView inicioView;

    public InicioController(InicioModel inicioModel, InicioView inicioView) {
        this.inicioView = inicioView;
        this.inicioModel = inicioModel;

        inicioView.btnJugar(new OyenteJugar());
    }

    public void Jugar(){
        inicioModel.ejecutarAccionJugar();
    }
    
    private class OyenteJugar implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Se hizo la acction perform");
            Jugar();
        }

    }
}
