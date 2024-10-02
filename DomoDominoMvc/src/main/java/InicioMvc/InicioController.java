package InicioMvc;

import comands.IComando;
import observers.IObserver;

public class InicioController implements IObserver{
    
    private InicioModel inicioModel;
    private InicioView inicioView;

    public InicioController(InicioModel inicioModel, InicioView inicioView) {
        this.inicioView = inicioView;

        inicioView.agregarObservador(this);
    }


    @Override
    public void actualizar(IComando comando) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
