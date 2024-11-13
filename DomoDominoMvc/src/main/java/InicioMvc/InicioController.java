package InicioMvc;

import observers.IObserver;

public class InicioController {

    private InicioModel inicioModel;
    private InicioView inicioView;

    public InicioController(InicioModel inicioModel, InicioView inicioView) {
        this.inicioView = inicioView;
        this.inicioModel = inicioModel;
        
        inicioView.agregarIEventoCrearPartida(new OyenteCrearPartida());
        inicioView.agregarIEventoUnirseAPartida(new OyenteUnirseAPartida());
    }

    public void crearPartida() {
        inicioModel.ejecutarAccionCrearPartida();
    }

    public void unirseAPartida() {
        inicioModel.ejecutarAccionUnirseAPartida();
    }

    private class OyenteCrearPartida implements IObserver {

        @Override
        public void actualizar() {
            crearPartida();
        }
    }

    private class OyenteUnirseAPartida implements IObserver {

        @Override
        public void actualizar() {
            unirseAPartida();
        }
    }
}
