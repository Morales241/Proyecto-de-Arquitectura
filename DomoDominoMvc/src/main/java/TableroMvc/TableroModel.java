/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableroMvc;


import dtos.Array;
import dtos.FichaDto;
import java.util.ArrayList;
import java.util.List;
import serializables.Jugador;

/**
 *
 * @author JOSUE GOMEZ
 */
public class TableroModel {
      private Array array;

    private List<Observer> observers;

    public TableroModel(Array array) {
        this.array = array;
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

  

    public Array getArray() {
        return array;
    }


 

    public interface Observer {
        void update();
    }
}

