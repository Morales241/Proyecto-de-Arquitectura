/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicializadorMVC;

import InicioMvc.InicioController;
import InicioMvc.InicioModel;
import InicioMvc.InicioView;
import contenedor.ContenedorMvc;
import mediador.IMediador;
import mediador.Mediador;

/**
 *
 * @author tacot
 */
public class InicializadorMVC {

    public InicializadorMVC() {
    }
    
    public void inicializarClase(){
        
        //MVC Inicio
        IMediador mediador = Mediador.getInstancia();
        
        InicioModel inicioModel = new InicioModel();
        InicioView inicioView = new InicioView(inicioModel);
        inicioView.setMediador(mediador);
        InicioController inicioController = new InicioController(inicioModel, inicioView);
        ContenedorMvc<InicioModel, InicioView, InicioController> inicioContenedor = new ContenedorMvc<>(inicioModel,inicioView,inicioController);
        mediador.registrarPantalla("inicio", inicioContenedor);
        
        
        
    }
    
}
