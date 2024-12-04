package Entidades;

import java.util.List;
import java.util.Map;

import java.util.ArrayList;

public class GestorTurnos {
    private final List<Jugador> turnos;
    private int indiceActual;

    public GestorTurnos() {
        this.turnos = new ArrayList<>();
        this.indiceActual = 0;
    }

    public void inicializarTurnos(Map<String, Jugador> jugadores) {
        turnos.clear();
        Jugador jugadorConDobleSeis = null;

        for (Map.Entry<String, Jugador> entry : jugadores.entrySet()) {
            Jugador jugador = entry.getValue();

            boolean tieneDobleSeis = jugador.getFichas().stream()
                .anyMatch(ficha -> ficha.getLado1() == 6 && ficha.getLado2() == 6);

            if (tieneDobleSeis && jugadorConDobleSeis == null) {
                jugadorConDobleSeis = jugador;
            } else {
                turnos.add(jugador);
            }
        }

        if (jugadorConDobleSeis != null) {
            turnos.add(0, jugadorConDobleSeis);
        }

        indiceActual = 0;
    }

    public Jugador obtenerTurnoActual() {
        if (turnos.isEmpty()) {
            return null;
        }
        return turnos.get(indiceActual);
    }

    public void avanzarTurno() {
        if (!turnos.isEmpty()) {
            indiceActual = (indiceActual + 1) % turnos.size();
        }
    }

    public boolean esTurnoDe(Jugador jugador) {
        return jugador.equals(obtenerTurnoActual());
    }

    public List<Jugador> obtenerOrdenDeTurnos() {
        return new ArrayList<>(turnos);
    }
}
