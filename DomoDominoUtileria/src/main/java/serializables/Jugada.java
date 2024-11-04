package serializables;

import dtos.FichaDto;

/**
 *
 * @author tacot
 */
public class Jugada {
    private FichaDto ficha;
    private String informacionJugador;
    //aqui van a ir mas variables para la informacion del evento

    public Jugada() {
    }

    public Jugada(FichaDto ficha) {
        this.ficha = ficha;
    }

    public FichaDto getFicha() {
        return ficha;
    }

    public void setFicha(FichaDto ficha) {
        this.ficha = ficha;
    }

    public String getInformacionJugador() {
        return informacionJugador;
    }

    public void setInformacionJugador(String informacionJugador) {
        this.informacionJugador = informacionJugador;
    }

}
