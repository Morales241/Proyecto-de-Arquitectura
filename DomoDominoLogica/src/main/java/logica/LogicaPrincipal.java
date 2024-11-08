package logica;

import Inicializador.InicializadorClases;
import Inicio.LogicaInicio;
import cliente.LogicaCliente;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.PonerFichaDto;
import eventos.SetUpDto;
import fachadas.IInicioFachada;
import mediador.Mediador;
import observers.IEventoAgregarJugadorAPartida;
import observers.IEventoCrearPartida;
import observers.IEventoIniciarPartida;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IEventoValidacionDeNombre;
import serializables.Jugador;

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
    private LogicaCliente lCliente;
    private LogicaInicio lInicio;
    private IInicioFachada iFachada;
    //poner variables de las fachadas que conectan a los modelos de los diferentes MVC

    public LogicaPrincipal() {
    }

    public LogicaPrincipal(LogicaInicio logicaInicio,
            IInicioFachada inicioFachada) {
        mediador = Mediador.getInstancia();
        lInicio = logicaInicio;
        iFachada = inicioFachada;
        inicioFachada.agregarIObserverJugar(new AccionIniciarJuego());
    }

    
    //se va a cambiar el nombre de este metodo
    public void iniciarJuego() {
        InicializadorClases inicializadorClases = new InicializadorClases();
        inicializadorClases.InicializarClases();

        mediador.mostrarPantallaConcreta("login");

    }

    private class AccionIniciarJuego implements IEventoValidacionDeNombre {

        @Override
        public void validacionDeNombre(String mensajeDeValidacion) {
            if (lInicio.validarNombre(mensajeDeValidacion).equals("El nombre no es valido")) {
                iFachada.mandarMensajeNombreInvalido(mensajeDeValidacion);
            } else {
                mediador.mostrarPantallaConcreta("");
            }
        }
    }

    
    
    private class AccionCrearPartida implements IEventoCrearPartida {

        @Override
        public void actualizar(Jugador jugador) {
            
        }

    }
    
    public void crearPartida(Jugador jugador){
        
    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void actualizar(Jugador jugador) {

        }

    }

    private class AccionIniciarPartida implements IEventoIniciarPartida {

        @Override
        public void iniciarPartida(SetUpDto setUp) {

        }

    }

    private class AccionSalirDePartida implements IEventoSalirDePartida{

        @Override
        public void salirDePartida(JugadorDto jugador) {
            
        }

    }

    private class AccionPonerFicha implements IEventoPonerFicha{

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {
            
        }

    }

    private class AccionTomarFichaDelPozo implements IEventoTomarFichaDelPozo{

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {
            
        }

    }

    private class AccionElejirFicha {

    }

}
