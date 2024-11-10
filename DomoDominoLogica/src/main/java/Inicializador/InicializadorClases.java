package Inicializador;

import InicioMvc.InicioController;
import InicioMvc.InicioModel;
import InicioMvc.InicioView;
import TableroMvc.TableroController;
import TableroMvc.TableroModel;
import TableroMvc.TableroView;
import contenedor.ContenedorMvc;
import Entidades.Arreglo;
import dtos.JugadorDto;
import Entidades.Pozo;
import Inicio.LogicaInicio;
import fachadas.IInicioFachada;
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
    
    /**
     * Inicializar clases MVC
     */
    public void InicializarClases(){
        IMediador mediador = Mediador.getInstancia();
        
        
        InicioModel inicioModel = new InicioModel();
        InicioView inicioView = new InicioView(inicioModel);
        inicioView.setMediador(mediador);
        InicioController inicioController = new InicioController(inicioModel, inicioView);
        ContenedorMvc<InicioModel, InicioView, InicioController> inicioContenedor = new ContenedorMvc<>(inicioModel,inicioView,inicioController);
      
        mediador.registrarPantalla("inicio", inicioContenedor);
          
        //aquí instanciamos la logica, se tienen que camiar los parametros por contenedores en vez de solo los modelos
        IInicioFachada inicioFachada = new InicioFachada(inicioModel);
//        LogicaInicio logicaInicio = new LogicaInicio(inicioFachada);
    }
}
