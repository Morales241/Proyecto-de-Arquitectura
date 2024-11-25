/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadas;

import dtos.FichaDto;
import observers.IEventoActualizarTablero;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoSolicitudTomarFicha;
import observers.IEventoTomarFichaDelPozo;

/**
 *
 * @author favel
 */
public interface ITableroFachada {
     
     public void agregarIEventoPonerFicha(IEventoPonerFicha listener);
     
     public void agregarIEventoTomarFIchaDelPozo(IEventoSolicitudTomarFicha listener);
     
     public void agregarIEventoPasarTurno(IEventoPasarTurno listener);
     
     public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener);
     
     public void tomarFichaDelPozo(FichaDto ficha);
     
}
