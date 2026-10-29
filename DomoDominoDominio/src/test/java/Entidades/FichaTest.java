package Entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Ficha: mula solo cuando ambos lados coinciden.
 */
public class FichaTest {

    @Test
    public void mulaCuandoLadosIguales() {
        // Arrange
        Ficha ficha = new Ficha(2, 2);

        // Act
        boolean resultado = ficha.esMula();

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void noMulaCuandoLadosDistintos() {
        // Arrange
        Ficha ficha = new Ficha(2, 5);

        // Act
        boolean resultado = ficha.esMula();

        // Assert
        assertFalse(resultado);
    }
}
