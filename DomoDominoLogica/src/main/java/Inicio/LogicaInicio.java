package Inicio;

import Inicializador.InicializadorClases;
import InicioMvc.InicioModel;
import mediador.IMediador;
import mediador.Mediador;
import observers.IObserver;

/**
 * Clase principal de Logica en la que inicia el juego
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LogicaInicio implements ILogicaInicio {

    private final IMediador mediador;
    private final InicioModel inicioModel;

    public LogicaInicio() {
        InicializadorClases inicializadorClases = new InicializadorClases();
        inicializadorClases.InicializarClases();
        this.mediador = Mediador.getInstancia();
        this.inicioModel = (InicioModel) mediador.obtenerPantallaConcreta("inicio").getModelo();
        
        inicioModel.agregarIObserverJugar (new AccionIniciarJuego());
    }

    @Override
    public void Jugar() {
        mediador.mostrarPantallaConcreta("tablero");
    }
    
    

    private class AccionIniciarJuego implements IObserver  {

        @Override
        public void actualizar() {
            Jugar();
        }
    }
}
