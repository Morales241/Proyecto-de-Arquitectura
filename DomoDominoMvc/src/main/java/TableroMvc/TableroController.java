package TableroMvc;

import dtos.FichaDto;
import eventos.JugadorAEliminarDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import java.util.List;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoValidarFichas;

public class TableroController {

    private TableroModel tableroModel;
    private TableroView tableroView;

    public TableroController(TableroModel tableroModel, TableroView tableroView) {
        this.tableroModel = tableroModel;
        this.tableroView = tableroView;
        tableroView.agregarObserverPonerFicha(new accionPonerFicha());
        tableroView.agregarObserverValidarFichas(new AccionValidarFichas());

//          tableroView.agregarEventoTomarFichaDelPozo(new accionTomarFichaDelPozo());
//          tableroView.agregarEventoSalirDePartida(new accionSalirDePartida());
    }

    private class accionPonerFicha implements IEventoPonerFicha {

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {
            tableroModel.ejecutarObserverPonerFicha(ponerFicha);
        }
    }

    private class accionTomarFichaDelPozo implements IEventoTomarFichaDelPozo {

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {

        }
    }

    private class accionSalirDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {

        }
    }

    private class AccionValidarFichas implements IEventoValidarFichas {

        @Override
        public void validarFichas(List<FichaDto> fichas) {
        
        tableroModel.ejecutarObserverValidarFichas(fichas);
        }

    }
}
