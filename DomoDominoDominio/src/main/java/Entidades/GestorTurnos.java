package Entidades;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class GestorTurnos {

    private final List<Jugador> turnos;
    private int indiceActual;
    private List<String> turnosSincronizados;

    // Constructor
    public GestorTurnos() {
        this.turnos = new ArrayList<>();
        this.indiceActual = 0;
        this.turnosSincronizados = new ArrayList<>();
    }

    public void inicializarTurnos(Map<String, Jugador> jugadores) {
        turnos.clear();
        Jugador jugadorConMulaMasAlta = null;
        int valorMulaMasAlta = -1;

        for (Map.Entry<String, Jugador> entry : jugadores.entrySet()) {
            Jugador jugador = entry.getValue();

            int valorMulaDelJugador = jugador.getFichas().stream()
                    .filter(ficha -> ficha.getLado1() == ficha.getLado2()) 
                    .mapToInt(Ficha::getLado1) 
                    .max()
                    .orElse(-1);

            if (valorMulaDelJugador > valorMulaMasAlta) {
                valorMulaMasAlta = valorMulaDelJugador;
                jugadorConMulaMasAlta = jugador;
            }

            turnos.add(jugador);
        }

        if (jugadorConMulaMasAlta != null) {
            turnos.remove(jugadorConMulaMasAlta);
            turnos.add(0, jugadorConMulaMasAlta); 
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

    public void setTurnos(List<String> turnos) {
        this.turnosSincronizados = new ArrayList<>(turnos);
    }

    public List<String> getTurnosSincronizados() {
        return turnosSincronizados;
    }
}
