package fachadasInterfaz;

import dtos.JugadorDto;
import java.util.List;

public interface IGestorDeTurnosFachada {
    void inicializarTurnos(List<JugadorDto> jugadoresDTO);
    String obtenerTurnoActual();
    void pasarTurno();
    List<JugadorDto> obtenerOrdenDeTurnos();
}
