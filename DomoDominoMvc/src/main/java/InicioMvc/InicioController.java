/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InicioMvc;

import observers.IObserver;

/**
 *
 * @author JOSUE GOMEZ
 */
public class InicioController implements IObserver{
    
    private InicioModel inicioModel;
    private InicioView inicioView;

    public InicioController(InicioModel inicioModel, InicioView inicioView) {
        this.inicioView = inicioView;

        inicioView.agregarObservador(this);
    }

    @Override
    public void actualizar() {
      
    }
}
