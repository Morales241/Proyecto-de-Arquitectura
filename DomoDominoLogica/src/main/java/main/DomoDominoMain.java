package main;

import Inicializador.InicializadorClases;
import mediador.Mediador;

/**
 * Clase principal encargada de correr el proyecto
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class DomoDominoMain {

    public static void main(String[] args) {
        Mediador mediador = new Mediador();
        
        InicializadorClases inicializadorClases = new InicializadorClases();
        inicializadorClases.InicializarClases(mediador);
        
        mediador.mostrarPantallaConcreta("login");
        
    }
    
}
