package Inicializador;

import InicioMvc.InicioModel;
import crearPartida.CrearPartidaModel;
import fachadas.CrearPartidaFachada;
import fachadas.ICrearPartidaFachada;
import fachadas.IInicioFachada;
import fachadas.IUnirseAPartidaFachada;
import fachadas.InicializadorMVCFachada;
import fachadas.InicioFachada;
import fachadas.UnirseAPartidaFachada;
import mediador.IMediador;
import mediador.Mediador;
import unirseAPartida.UnirseAPartidaModel;

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
    
    private IInicioFachada inicioFachada;
    
    private ICrearPartidaFachada crearPartidaFachada;
    
    private IUnirseAPartidaFachada unirsePartidaFachada;
    
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
        InicioModel inicioModel = (InicioModel) mediador.obtenerPantallaConcreta("inicio").getModelo();
          
        inicioFachada = new InicioFachada(inicioModel);

        //fachada crearPartida
        CrearPartidaModel crearPartidaModel = (CrearPartidaModel) mediador.obtenerPantallaConcreta("crearPartida").getModelo();
        crearPartidaFachada = new CrearPartidaFachada(crearPartidaModel);
        
        //fachada unirsePartida
        UnirseAPartidaModel unirseAPartidaModel = (UnirseAPartidaModel) mediador.obtenerPantallaConcreta("unirsePartida").getModelo();
        unirsePartidaFachada = new UnirseAPartidaFachada(unirseAPartidaModel);
    }

    public IInicioFachada getInicioFachada() {
        return inicioFachada;
    }

    public ICrearPartidaFachada getCrearPartidaFachada() {
        return crearPartidaFachada;
    }

    public IUnirseAPartidaFachada getUnirseAPartidaFachada() {
         return unirsePartidaFachada;
    }
    
}
