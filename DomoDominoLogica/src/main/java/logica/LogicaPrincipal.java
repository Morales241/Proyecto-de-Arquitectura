package logica;

import Inicializador.InicializadorClases;
import Inicio.LogicaInicio;
import fachadas.IInicioFachada;
import mediador.Mediador;
import observers.IEventoValidacionDeNombre;

/**
 * Clase de logica principal que se encarga el flujo
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LogicaPrincipal {
    private Mediador mediador;
    private LogicaInicio lInicio;
    private IInicioFachada iFachada;

    public LogicaPrincipal() {
    }

    public LogicaPrincipal(LogicaInicio logicaInicio, 
            IInicioFachada inicioFachada) {
        mediador = Mediador.getInstancia();
        lInicio = logicaInicio;
        iFachada = inicioFachada;
        inicioFachada.agregarIObserverJugar(new AccionIniciarJuego());
    }
    
    public void iniciarJuego(){
        InicializadorClases inicializadorClases = new InicializadorClases();
        inicializadorClases.InicializarClases();
        
        mediador.mostrarPantallaConcreta("login");
        
    }
    
    private class AccionIniciarJuego implements IEventoValidacionDeNombre {

        @Override
        public void validacionDeNombre(String mensajeDeValidacion) {
            if (lInicio.validarNombre(mensajeDeValidacion).equals("El nombre no es valido")) {
                iFachada.mandarMensajeNombreInvalido(mensajeDeValidacion);
            }

        }

        
    }
}
