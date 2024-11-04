package Entidades;

import java.util.List;

public class GestorTurnos {
    private static GestorTurnos instancia;
    private List<String> ordenJugadores;
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

    public void setOrdenJugadores(List<String> jugadores) {
        this.ordenJugadores = jugadores;
    }

    public String getJugadorActual() {
        return ordenJugadores.get(indiceActual);
    }

    public void cambiarTurno() {
        indiceActual = (indiceActual + 1) % ordenJugadores.size();
    }
}

