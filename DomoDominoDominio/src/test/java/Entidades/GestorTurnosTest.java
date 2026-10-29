package Entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * GestorTurnos: el turno rota en orden entre los jugadores.
 */
public class GestorTurnosTest {

    private Map<String, Jugador> dosJugadores() {
        // Arrange compartido: mapa en orden de insercion
        Map<String, Jugador> jugadores = new LinkedHashMap<>();
        jugadores.put("jesus", new Jugador("jesus"));
        jugadores.put("mariana", new Jugador("mariana"));
        return jugadores;
    }

    @Test
    public void primerTurnoEsPrimerJugador() {
        // Arrange
        GestorTurnos turnos = new GestorTurnos();

        // Act
        turnos.inicializarTurnos(dosJugadores());

        // Assert
        assertEquals("jesus", turnos.obtenerTurnoActual().getNombre());
    }

    @Test
    public void avanzarRotaAlSiguiente() {
        // Arrange
        GestorTurnos turnos = new GestorTurnos();
        Map<String, Jugador> jugadores = dosJugadores();
        turnos.inicializarTurnos(jugadores);

        // Act
        turnos.avanzarTurno();

        // Assert
        assertEquals("mariana", turnos.obtenerTurnoActual().getNombre());
        assertTrue(turnos.esTurnoDe(jugadores.get("mariana")));
    }
}
