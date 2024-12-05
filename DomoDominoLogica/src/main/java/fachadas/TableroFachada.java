/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import fachadasInterfaz.ITableroFachada;
import TableroMvc.TableroModel;
import dtos.ArregloDto;
import dtos.JugadorDto;
import eventos.JugadorBase;
import java.util.List;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;

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
        tableroModel.agregarObserverPonerFicha(listener);
    }
    
    @Override
    public void agregarIEventoTomarFIchaDelPozo(IEventoPedirFichaAlPozo listener) {
        tableroModel.agregarObserverTomarFichaDelPozo(listener);
    }
    
    @Override
    public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener) {
        tableroModel.agregarObserverSalirDePartida(listener);
    }
    
    @Override
    public void mandarArregloActualizado(ArregloDto arrayDto) {
        tableroModel.setArray(arrayDto);
    }
    
    @Override
    public void mandarDatosDeInicioDePartida(JugadorDto jugadorDto, ArregloDto arrayDto, List<JugadorBase> jugadorBases) {
        tableroModel.iniciarPartida(jugadorDto, arrayDto, jugadorBases);
    }
    
    public void mandarJugadorActualizado(JugadorDto jugadorDto) {
        tableroModel.setJugador(jugadorDto);
    }
}
