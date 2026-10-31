package InicioMvc;

import eventos.IEventoIrACrearPartida;
import eventos.IEventoIrAUnirseAPartida;

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

    private class OyenteCrearPartida implements IEventoIrACrearPartida {

        @Override
        public void irACrearPartida() {
            crearPartida();
        }
    }

    private class OyenteUnirseAPartida implements IEventoIrAUnirseAPartida {

        @Override
        public void irAUnirseAPartida() {
            unirseAPartida();
        }
    }
}
