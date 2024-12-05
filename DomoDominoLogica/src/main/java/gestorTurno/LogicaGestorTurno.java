package gestorTurno;

import Entidades.Jugador;
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
    public boolean pasarTurno() {
        if(turnosFachada.seAcaboLaPartida()){
            turnosFachada.calcularPuntajeFinal();
            return false;
        }
        else{
            turnosFachada.pasarTurno();
            return true;
        } 
    }

    @Override
    public List<JugadorDto> obtenerOrdenDeTurnos() {
        return turnosFachada.obtenerOrdenDeTurnos();
    }

    @Override
    public void sincronizarTurnosConClaseExterna(List<JugadorDto> turnosExterna) {
        turnosFachada.sincronizarTurnosConClaseExterna(turnosExterna);
    }
}
