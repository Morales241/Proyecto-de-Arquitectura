package logica;

import Inicializador.InicializadorClases;
import mediador.Mediador;

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

    public LogicaPrincipal() {
        mediador = Mediador.getInstancia();
    }
    
    
    
    public void iniciarJuego(){
        InicializadorClases inicializadorClases = new InicializadorClases();
        inicializadorClases.InicializarClases();
        
        mediador.mostrarPantallaConcreta("login");
        
    }
}
