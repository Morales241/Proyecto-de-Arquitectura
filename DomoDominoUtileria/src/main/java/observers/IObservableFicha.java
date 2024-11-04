/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observers;


/**
 *
 * @author tacot
 */
public interface IObservableFicha {
    public void agregarObservador(IObserverFicha observador);
    
    public void eliminarObservador(IObserverFicha observador);
    
    public void notificarObservadores();
    
}
