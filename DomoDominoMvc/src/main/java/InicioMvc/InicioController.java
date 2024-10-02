package InicioMvc;

import observers.IObserver;

public class InicioController implements IObserver{
    
    private InicioModel inicioModel;
    private InicioView inicioView;

    public InicioController(InicioModel inicioModel, InicioView inicioView) {
        this.inicioView = inicioView;

        inicioView.agregarObservador(this);
    }

    @Override
    public void actualizar(String estado) {
        
    }
}
