package InicioMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import observers.IEventoJugar;


public class InicioController{
    
    private InicioModel inicioModel;
    private InicioView inicioView;

    public InicioController(InicioModel inicioModel, InicioView inicioView) {
        this.inicioView = inicioView;
        this.inicioModel = inicioModel;

        inicioView.agregarIEventoJugar(new OyenteJugar());
    }
    
    public void validarNombre(String nombre){
        this.inicioModel.ejecutarAccionJugar(nombre);
        
    }
    
    private class OyenteJugar implements IEventoJugar {

        @Override
        public void validarNombreParaJugar(String nombre) {
            validarNombre(nombre);
        }
        
    }
}
