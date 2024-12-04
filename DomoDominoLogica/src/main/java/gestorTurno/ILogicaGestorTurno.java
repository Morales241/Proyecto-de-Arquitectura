package gestorTurno;

import Entidades.Jugador;
import dtos.JugadorDto;
import java.util.List;
import java.util.Map;

public interface ILogicaGestorTurno {

    public void inicializarTurnos(List<JugadorDto> jugadoresDTO);

    public String obtenerTurnoActual();

    public void pasarTurno();

    public List<JugadorDto> obtenerOrdenDeTurnos();
    
    public void sincronizarTurnosConClaseExterna(List<String> turnosExterna);
}
