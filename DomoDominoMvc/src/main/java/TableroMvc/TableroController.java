package TableroMvc;

import dtos.FichaDto;
import eventos.JugadorAEliminarDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;

public class TableroController {

     private TableroModel tableroModel;
     private TableroView tableroView;

     public TableroController(TableroModel tableroModel, TableroView tableroView) {
          this.tableroModel = tableroModel;
          this.tableroView = tableroView;
          tableroView.agregarObserverPonerFicha(new accionPonerFicha());
//          tableroView.agregarEventoTomarFichaDelPozo(new accionTomarFichaDelPozo());
//          tableroView.agregarEventoPasarTurno(new accionPasarTurno());
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
     
     private class accionPasarTurno implements IEventoPasarTurno {
          @Override
          public void pasarTurno(PasarTurno pasarTurno) {
               
          }
     }
     
     private class accionSalirDePartida implements IEventoSalirDePartida {
          @Override
          public void salirDePartida(JugadorAEliminarDto jugador) {
     
          }
     }
}
