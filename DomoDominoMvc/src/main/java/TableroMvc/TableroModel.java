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
import observers.IObserver;
import observersLogicaAServidorCentral.IEventoSalirDePartida;

/**
 *
 * @author JOSUE GOMEZ
 */
public class TableroModel {

    private ArregloDto array;
    private boolean turno;
    private JugadorDto jugador;
    private List<JugadorBase> compañeros;
    private IEventoPonerFicha eventoPonerFicha;
    private IEventoPedirFichaAlPozo eventoTomarFichaDelPozo;
    private IEventoSalirDePartida eventoSalirDePartida;
    private IObserver actualizar;

    public TableroModel() {
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

        ejecutarObserverPonerFicha(new PonerFichaDto(fichaSeleccionada, extremoIzquierdo, Direccion));

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

    public void iniciarPartida(JugadorDto jugadorDto, ArregloDto arrayDto, List<JugadorBase> jugadorBases) {
        setJugador(jugadorDto);
        setCompañeros(jugadorBases);
        setArray(arrayDto);

        ejecutarObserverActualizar();
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    
}
