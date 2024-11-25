package TableroMvc;

import dtos.FichaDto;
import eventos.JugadorAEliminarDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoSolicitudTomarFicha;
import observers.IEventoTomarFichaDelPozo;

public class TableroController {

     private TableroModel tableroModel;
     private TableroView tableroView;

     public TableroController(TableroModel tableroModel, TableroView tableroView) {
          this.tableroModel = tableroModel;
          this.tableroView = tableroView;
          tableroView.agregarIEventoPonerFicha(new accionPonerFicha());
          tableroView.agregarEventoSolicitudTomarFicha(new accionTomarFichaDelPozo());
          tableroView.agregarEventoPasarTurno(new accionPasarTurno());
          tableroView.agregarEventoSalirDePartida(new accionSalirDePartida());
     }

     private class accionPonerFicha implements IEventoPonerFicha {
          @Override
          public void ponerFicha(PonerFichaDto ponerFicha) {
          
          }
     }
      
     private class accionTomarFichaDelPozo implements IEventoSolicitudTomarFicha {

        @Override
        public void solicitudTomarFicha() {
          solicitarFicha();
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
     
     public void solicitarFicha(){
         tableroModel.ejecutarEventoSolicitudTomarFicha();
     }
}
