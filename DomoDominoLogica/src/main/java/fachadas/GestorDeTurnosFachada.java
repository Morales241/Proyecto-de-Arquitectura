package fachadas;

import Entidades.Ficha;
import Entidades.GestorTurnos;
import Entidades.Jugador;
import dtos.FichaDto;
import dtos.JugadorDto;
import fachadasInterfaz.IGestorDeTurnosFachada;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDeTurnosFachada implements IGestorDeTurnosFachada {

    private final GestorTurnos GestorTurno;

    public GestorDeTurnosFachada(GestorTurnos GestorTurno) {
        this.GestorTurno = GestorTurno;
    }

    @Override
    public void inicializarTurnos(List<JugadorDto> jugadoresDTO) {
        List<Jugador> jugadores = new ArrayList<>();
        for (JugadorDto dto : jugadoresDTO) {
            Jugador jugador = new Jugador(dto.getNombre());
            jugador.setAvatar(dto.getAvatar());
            for (FichaDto fichaDTO : dto.getFichas()) {
                jugador.agregarFicha(new Ficha(fichaDTO.getLado1(), fichaDTO.getLado2()));
            }
            jugadores.add(jugador);
        }

        GestorTurno.inicializarTurnos(jugadores.stream().collect(Collectors.toMap(Jugador::getNombre, jugador -> jugador)));
    }

    @Override
    public String obtenerTurnoActual() {
        Jugador jugadorActual = GestorTurno.obtenerTurnoActual();
        return jugadorActual != null ? jugadorActual.getNombre() : "No hay turnos disponibles";
    }

    @Override
    public void pasarTurno() {
        GestorTurno.avanzarTurno();
        String turnoActual = obtenerTurnoActual();
    }

    @Override
    public List<JugadorDto> obtenerOrdenDeTurnos() {
        List<JugadorDto> turnosDTO = new ArrayList<>();
        for (Jugador jugador : GestorTurno.obtenerOrdenDeTurnos()) {
            List<FichaDto> fichas = new ArrayList<>();
            jugador.getFichas().forEach(ficha -> {

                fichas.add(new FichaDto(ficha.getLado1(), ficha.getLado2()));
            });
            JugadorDto dto = new JugadorDto(jugador.getNombre(), jugador.getAvatar(), fichas);
            turnosDTO.add(dto);
        }
        return turnosDTO;
    }

    @Override
    public void sincronizarTurnosConClaseExterna(List<JugadorDto> turnosExterna) {
        List<Jugador> turnosList = new ArrayList<>();
        turnosExterna.forEach(o -> turnosList.add(new Jugador(o.getNombre())));

        GestorTurno.setTurnos(turnosList);
    }

    @Override
    public boolean seAcaboLaPartida() {
        return GestorTurno.seAcaboLaPartida();
    }

    @Override
    public List<JugadorDto> calcularPuntajeFinal() {
        List<Jugador> jugadoresOrdenados = GestorTurno.calcularPuntajeFinal();

        List<JugadorDto> jugadoresDTO = new ArrayList<>();
        for (Jugador jugador : jugadoresOrdenados) {
            List<FichaDto> fichas = new ArrayList<>();
            for (Ficha ficha : jugador.getFichas()) {
                fichas.add(new FichaDto(ficha.getLado1(), ficha.getLado2()));
            }
            JugadorDto dto = new JugadorDto(jugador.getNombre(), jugador.getAvatar(), fichas);
            jugadoresDTO.add(dto);
        }

        return jugadoresDTO;
    }
}
