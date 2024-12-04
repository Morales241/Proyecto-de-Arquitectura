/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tablero;

import dtos.ArregloDto;
import dtos.JugadorDto;
import eventos.JugadorBase;
import java.util.List;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;

/**
 *
 * @author tacot
 */
public interface ILogicaTablero {
     public void agregarIEventoPonerFicha(IEventoPonerFicha listener);
     
     public void agregarIEventoTomarFIchaDelPozo(IEventoPedirFichaAlPozo listener);
     
     public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener);
     
     public void mandarDatosDeInicioDePartida(JugadorDto jugadorDto, ArregloDto arrayDto, List<JugadorBase> jugadorBases);
     
     public void mandarArregloActualizado(ArregloDto arrayDto);

}
