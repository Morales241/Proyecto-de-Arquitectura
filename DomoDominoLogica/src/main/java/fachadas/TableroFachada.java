/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import TableroMvc.TableroModel;
import dtos.ArregloDto;
import dtos.FichaDto;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoSolicitudTomarFicha;
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
    public void agregarIEventoTomarFIchaDelPozo(IEventoSolicitudTomarFicha listener) {
        this.tableroModel.agregarEventoSolicitudTomarFicha(listener);
    }

    @Override
    public void agregarIEventoPasarTurno(IEventoPasarTurno listener) {
        this.tableroModel.agregarEventoPasarTurno(listener);
    }

    @Override
    public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener) {
        this.tableroModel.agregarIEventoSalirDePartida(listener);
    }

    @Override
    public void tomarFichaDelPozo(FichaDto ficha) {
        this.tableroModel.actualizarFichaSelecionada(ficha);
    }
    
    public void actualizarTablero(ArregloDto arreglo){
        tableroModel.ejecutarEventoActualizarTablero(arreglo);
    }

}
