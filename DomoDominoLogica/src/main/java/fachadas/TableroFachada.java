/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import fachadasInterfaz.ITableroFachada;
import TableroMvc.TableroModel;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;

/**
 *
 * @author favel
 */
public class TableroFachada implements ITableroFachada {

     private final TableroModel tableroModel;

     public TableroFachada(TableroModel tableroModel) {
          this.tableroModel = tableroModel;
     }
     
     @Override
     public void agregarIEventoPonerFicha(IEventoPonerFicha listener) {
          this.tableroModel.agregarIEventoPonerFIcha(listener);
     }

     @Override
     public void agregarIEventoTomarFIchaDelPozo(IEventoTomarFichaDelPozo listener) {
         this.tableroModel.agregarIEventoSacarFichaDelPozo(listener);
     }

     @Override
     public void agregarIEventoPasarTurno(IEventoPasarTurno listener) {
         this.tableroModel.agregarEventoPasarTurno(listener);
     }

     @Override
     public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener) {
         this.tableroModel.agregarIEventoSalirDePartida(listener);
     }
     
}
