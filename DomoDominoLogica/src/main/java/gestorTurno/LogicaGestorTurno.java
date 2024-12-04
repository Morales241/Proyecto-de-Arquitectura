package gestorTurno;

import dtos.JugadorDto;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import fachadasInterfaz.IGestorDeTurnosFachada;

import java.util.List;

public class LogicaGestorTurno implements ILogicaGestorTurno {

    private final IGestorDeComunicacionesFachada comunicaciones;
    private final IGestorDeTurnosFachada turnosFachada;

    public LogicaGestorTurno(IGestorDeComunicacionesFachada comunicaciones, IGestorDeTurnosFachada turnosFachada) {
        this.comunicaciones = comunicaciones;
        this.turnosFachada = turnosFachada;
    }

    @Override
    public void inicializarTurnos(List<JugadorDto> jugadoresDTO) {
        turnosFachada.inicializarTurnos(jugadoresDTO);
    }

    @Override
    public String obtenerTurnoActual() {
        return turnosFachada.obtenerTurnoActual();
    }

    @Override
    public void pasarTurno() {
        turnosFachada.pasarTurno();
    }

    @Override
    public List<JugadorDto> obtenerOrdenDeTurnos() {
        return turnosFachada.obtenerOrdenDeTurnos();
    }

    @Override
    public void sincronizarTurnosConClaseExterna(List<String> turnosExterna) {
        turnosFachada.sincronizarTurnosConClaseExterna(turnosExterna);
    }
}
