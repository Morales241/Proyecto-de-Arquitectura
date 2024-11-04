package Entidades;

import java.util.List;

public class GestorTurnos {
    private static GestorTurnos instancia;
    private List<Jugador> ordenJugadores;
    private int indiceActual;

    private GestorTurnos() {
        indiceActual = 0;
    }

    public static synchronized GestorTurnos getInstancia() {
        if (instancia == null) {
            instancia = new GestorTurnos();
        }
        return instancia;
    }

    public void setOrdenJugadores(List<Jugador> jugadores) {
        this.ordenJugadores = jugadores;
    }

    public Jugador getJugadorActual() {
        return ordenJugadores.get(indiceActual);
    }

    public void cambiarTurno() {
        indiceActual = (indiceActual + 1) % ordenJugadores.size();
    }
    
    public int posicionJugador(Jugador jugador){
        return ordenJugadores.indexOf(jugador);
     }
}