package TableroMvc;

import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorBase;
import eventos.PonerFichaDto;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.ArgumentCaptor;
import eventos.IEventoPonerFicha;

/**
 * TableroModel solo arma el evento y lo entrega al listener.
 * El listener es un mock: probamos el mensaje, no la red.
 */
public class TableroModelTest {

    @Test
    public void colocarFichaAvisaConJugadorYCompaneros() {
        // Arrange
        TableroModel model = new TableroModel();
        IEventoPonerFicha listener = mock(IEventoPonerFicha.class);
        model.agregarObserverPonerFicha(listener);
        model.setJugador(new JugadorDto("jesus", 3, new ArrayList<>()));
        List<JugadorBase> companeros = List.of(new JugadorBase("Victor", 2));
        model.setCompañeros(companeros);
        FichaDto ficha = new FichaDto(2, 5);

        // Act
        model.colocarFicha(true, ficha, "Derecha");

        // Assert
        ArgumentCaptor<PonerFichaDto> captor = ArgumentCaptor.forClass(PonerFichaDto.class);
        verify(listener).ponerFicha(captor.capture());
        assertEquals("jesus", captor.getValue().getJugador().getNombre());
        assertEquals(companeros, captor.getValue().getCompañeros());
    }
}
