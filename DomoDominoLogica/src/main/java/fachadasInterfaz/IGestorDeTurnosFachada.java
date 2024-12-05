package fachadasInterfaz;

import Entidades.Jugador;
import dtos.JugadorDto;
import java.util.List;

public interface IGestorDeTurnosFachada {
    void inicializarTurnos(List<JugadorDto> jugadoresDTO);
    String obtenerTurnoActual();
    void pasarTurno();
    List<JugadorDto> obtenerOrdenDeTurnos();
    public void sincronizarTurnosConClaseExterna(List<JugadorDto> turnosExterna);
    public boolean seAcaboLaPartida();
    
    public List<JugadorDto> calcularPuntajeFinal();
}
