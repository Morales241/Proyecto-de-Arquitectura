/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableroMvc;


import dtos.ArrayDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import java.util.ArrayList;
import java.util.List;
import serializables.Jugador;

/**
 *
 * @author JOSUE GOMEZ
 */
public class TableroModel {
      private ArrayDto array;
private JugadorDto jugador;
    private List<Observer> observers;

    public TableroModel(ArrayDto array, JugadorDto jugador) {
        this.array = array;
        this.jugador = jugador;
        this.observers = new ArrayList<>();
    }

    public void agregarObserver(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
     public void agregarFicha(FichaDto ficha) {
        jugador.agregarFicha(ficha);
        notificarObservers();
    }

    public void colocarFicha(boolean extremoIzquierdo, FichaDto fichaSeleccionada) {
        boolean colocada = extremoIzquierdo ? array.colocarFichaExtremoIzquierdo(fichaSeleccionada)
                                             : array.colocarFichaExtremoDerecho(fichaSeleccionada);
        if (colocada) {
            jugador.eliminarFicha(fichaSeleccionada);
            notificarObservers();
        }
    }

    public JugadorDto getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDto jugador) {
        this.jugador = jugador;
    }

  

    public ArrayDto getArray() {
        return array;
    }

 public boolean verificarMovimientosPosibles() {
        return array.verificarPosiblesMovimientos(jugador.getFichas());
    }
 

    public interface Observer {
        void update();
    }
}

