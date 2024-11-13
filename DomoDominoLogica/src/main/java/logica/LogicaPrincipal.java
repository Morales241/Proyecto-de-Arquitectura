package logica;

import Inicializador.InicializadorClases;
import Inicio.ILogicaInicio;
import Inicio.LogicaInicio;
import cliente.LogicaCliente;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
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
import observers.IObserver;
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
    private ILogicaInicio lInicio;
    private IInicioFachada iFachada;
    //poner variables de las fachadas que conectan a los modelos de los diferentes MVC

    public LogicaPrincipal() {
        mediador = Mediador.getInstancia();
        
        InicializadorClases inicializadorClases = new InicializadorClases();
        
        inicializadorClases.InicializarClases();
        
        lInicio = new LogicaInicio();
        
        iFachada = inicializadorClases.getInicioFachada();
        
        iFachada.agregarIObserverCrearPartida(new AccionCambiarDePantallaCrearPartida());
        iFachada.agregarIObserverUnirseAPartida(new AccionCambiarDePantallaUnirseAPartida());
        
    }

    //se va a cambiar el nombre de este metodo
    public void iniciarJuego() {

        mediador.mostrarPantallaConcreta("inicio");

    }

    private class AccionCrearPartida implements IEventoCrearPartida {

        @Override
        public void crearPartida(JugadorCrearPartidaDto jugador) {

        }

    }

    public void crearPartida(Jugador jugador) {

    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {

        }
    }

    private class AccionIniciarPartida implements IEventoIniciarPartida {

        @Override
        public void iniciarPartida(SetUpDto setUp) {

        }
    }

    private class AccionSalirDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {
        }
    }

    private class AccionPonerFicha implements IEventoPonerFicha {

        @Override
        public void ponerFicha(PonerFichaDto ponerFicha) {

        }
    }

    private class AccionTomarFichaDelPozo implements IEventoTomarFichaDelPozo {

        @Override
        public void tomarFichaDelPozo(FichaDto fichaSacada) {

        }
    }

    private class AccionElejirFicha {

    }

    private class AccionCambiarDePantallaCrearPartida implements IObserver {

        @Override
        public void actualizar() {
            lInicio.crearPartida();
        }
    }
    
    private class AccionCambiarDePantallaUnirseAPartida implements IObserver {

        @Override
        public void actualizar() {
            lInicio.unirseAPartida();
        }
    }
    
    

}
