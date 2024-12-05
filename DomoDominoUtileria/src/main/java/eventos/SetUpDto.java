package eventos;

import dtos.FichaDto;
import dtos.JugadorDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class SetUpDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private int avatar;
    private List<JugadorDto> turnos;
    private List<JugadorBase> jugadoresDePartida;
    private List<FichaDto> fichasDelJugador;
    private List<FichaDto> fichasSacadasDelPozo;

    public SetUpDto(String nombre, int avatar, List<JugadorBase> jugadoresDePartiada, List<FichaDto> fichasDelJugador, List<FichaDto> fichasSacadasDelPozo) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.jugadoresDePartida = jugadoresDePartiada;
        this.fichasDelJugador = fichasDelJugador;
        this.fichasSacadasDelPozo = fichasSacadasDelPozo;
    }

    public List<JugadorDto> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<JugadorDto> turnos) {
        this.turnos = turnos;
    }

    public List<JugadorBase> getJugadoresDePartida() {
        return jugadoresDePartida;
    }

    public void setJugadoresDePartida(List<JugadorBase> jugadoresDePartida) {
        this.jugadoresDePartida = jugadoresDePartida;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public List<FichaDto> getFichasDelJugador() {
        return fichasDelJugador;
    }

    public void setFichasDelJugador(List<FichaDto> fichasDelJugador) {
        this.fichasDelJugador = fichasDelJugador;
    }

    public List<FichaDto> getFichasSacadasDelPozo() {
        return fichasSacadasDelPozo;
    }

    public void setFichasSacadasDelPozo(List<FichaDto> fichasSacadasDelPozo) {
        this.fichasSacadasDelPozo = fichasSacadasDelPozo;
    }
    
}
