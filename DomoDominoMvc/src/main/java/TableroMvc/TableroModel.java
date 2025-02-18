/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableroMvc;

import dtos.ArregloDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.PonerFichaDto;
import java.util.List;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoValidarFichas;
import observers.IObserver;
import observersLogicaAServidorCentral.IEventoSalirDePartida;

/**
 *
 * @author JOSUE GOMEZ
 */
public class TableroModel {

//    private ArregloDto array  = new ArregloDto(new int[30][30], 0, 0, 15, 15, 15, 15);
    private ArregloDto array;
    private boolean turno;
    private JugadorDto jugador;
    private List<JugadorBase> compañeros;
    private IEventoPonerFicha eventoPonerFicha;
    private IEventoPedirFichaAlPozo eventoTomarFichaDelPozo;
    private IEventoSalirDePartida eventoSalirDePartida;
    private IEventoValidarFichas eventoValidarFichas;
    private IObserver actualizar;
    private boolean pozo;

    public TableroModel() {
         
    }

    public void agregarObserverValidarFichas(IEventoValidarFichas listener) {
        this.eventoValidarFichas = listener;
    }

    public void ejecutarObserverValidarFichas(List<FichaDto> fichas) {
        if (eventoValidarFichas != null) {
            fichas = getJugador().getFichas();
            eventoValidarFichas.validarFichas(fichas);
        }
    }
    
    public void agregarObserverPonerFicha(IEventoPonerFicha eventoPonerFicha) {
        this.eventoPonerFicha = eventoPonerFicha;
    }

    public void agregarObserverTomarFichaDelPozo(IEventoPedirFichaAlPozo eventoTomarFichaDelPozo) {
        this.eventoTomarFichaDelPozo = eventoTomarFichaDelPozo;
    }

    public void agregarObserverSalirDePartida(IEventoSalirDePartida eventoSalirDePartida) {
        this.eventoSalirDePartida = eventoSalirDePartida;
    }

    public void ejecutarObserverPonerFicha(PonerFichaDto ponerFicha) {
        if (eventoPonerFicha != null) {
            ponerFicha.setCompañeros(compañeros);
            ponerFicha.setJugador(jugador);
            eventoPonerFicha.ponerFicha(ponerFicha);
        }
    }

    public void ejecutarObserverTomarFichaDelPozo() {
        if (eventoTomarFichaDelPozo != null) {
            eventoTomarFichaDelPozo.pedirFicha();
        }
    }

    public void ejecutarObserverSalirDePartida(JugadorAEliminarDto jugador) {
        if (eventoSalirDePartida != null) {
            eventoSalirDePartida.salirDePartida(jugador);
        }
    }

    public void agregarObserverActualizar(IObserver actualizar) {
        this.actualizar = actualizar;
    }

    public void ejecutarObserverActualizar() {
        if (actualizar != null) {
            actualizar.actualizar();
        }
    }

    public void agregarFicha(FichaDto ficha) {
        jugador.getFichas().add(ficha);
        ejecutarObserverActualizar();
    }

    public void colocarFicha(boolean extremoIzquierdo, FichaDto fichaSeleccionada, String Direccion) {
        PonerFichaDto fichaDto = new PonerFichaDto(fichaSeleccionada, extremoIzquierdo, Direccion);
        fichaDto.setJugador(jugador);
        fichaDto.setCompañeros(compañeros);
        ejecutarObserverPonerFicha(fichaDto);

    }

    public JugadorDto getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDto jugador) {
        this.jugador = jugador;
    }

    public ArregloDto getArray() {
        return array;
    }

    public void setArray(ArregloDto array) {
        this.array = array;
        ejecutarObserverActualizar();
    }

    public List<JugadorBase> getCompañeros() {
        return compañeros;
    }

    public void setCompañeros(List<JugadorBase> compañeros) {
        this.compañeros = compañeros;
    }

    public void iniciarPartida(JugadorDto jugadorDto, ArregloDto arrayDto, List<JugadorBase> jugadorBases, boolean turno) {
        
        setJugador(jugadorDto);
        setCompañeros(jugadorBases);
        setArray(arrayDto);
        setTurno(turno);
        ejecutarObserverActualizar();
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
        ejecutarObserverActualizar();
    }

    public boolean isPozo() {
        return pozo;
    }

    public void setPoso(boolean pozo) {
        this.pozo = pozo;
        
        ejecutarObserverActualizar();
    }
    
    
}
