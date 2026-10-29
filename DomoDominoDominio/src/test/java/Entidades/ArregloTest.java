package Entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 * Arreglo: cada partida empieza con tablero vacio (null, sin -1 magicos).
 */
public class ArregloTest {

    @Test
    public void tableroRecienCreadoSinFichas() {
        // Arrange
        Arreglo arreglo = new Arreglo();

        // Act
        Ficha[][] tablero = arreglo.getTablero();

        // Assert
        for (Ficha[] fila : tablero) {
            for (Ficha celda : fila) {
                assertNull(celda);
            }
        }
    }

    @Test
    public void reiniciarLimpiaFichasColocadas() {
        // Arrange
        Arreglo arreglo = new Arreglo();
        arreglo.getTablero()[5][5] = new Ficha(6, 6);

        // Act
        arreglo.reiniciarTablero();

        // Assert
        assertNull(arreglo.getTablero()[5][5]);
    }

    @Test
    public void extremosSeGuardan() {
        // Arrange
        Arreglo arreglo = new Arreglo();

        // Act
        arreglo.setExtremo1(3);
        arreglo.setExtremo2(5);

        // Assert
        assertEquals(3, arreglo.getExtremo1());
        assertEquals(5, arreglo.getExtremo2());
    }
}
