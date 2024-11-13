package Inicializador;

import InicioMvc.InicioModel;
import fachadas.IInicioFachada;
import fachadas.InicializadorMVCFachada;
import fachadas.InicioFachada;
import mediador.IMediador;
import mediador.Mediador;

/**
 * Clase que Inicializa todas las clases Mvc y clase mediador.
 * Encapsula los MVC y los pone en el mediador
 * 
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class InicializadorClases {
    
    private final IMediador mediador;
    private final InicializadorMVCFachada cFachada;
    
    private InicioModel inicioModel;
    private IInicioFachada inicioFachada;
    
    public InicializadorClases() {
        mediador = Mediador.getInstancia();
        cFachada = new InicializadorMVCFachada();
    }
    
    /**
     * Inicializar clases MVC
     */
    public void InicializarClases(){
        
        //inicializar pantallas mvc
        cFachada.inciializarMVC();
        
        //fachada inicio
        inicioModel = (InicioModel) mediador.obtenerPantallaConcreta("inicio").getModelo();
          
        inicioFachada = new InicioFachada(inicioModel);

    }


    public IInicioFachada getInicioFachada() {
        return inicioFachada;
    }

    
}
