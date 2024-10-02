/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InicioMvc;

import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

/**
 *
 * @author JOSUE GOMEZ
 */
public class InicioModel  implements IObservable{
     private List<IObserver> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(IObserver observador) {
       observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
       observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
      observadores.forEach(IObserver -> {
            IObserver.actualizar();
        });
    }
     
     
}
