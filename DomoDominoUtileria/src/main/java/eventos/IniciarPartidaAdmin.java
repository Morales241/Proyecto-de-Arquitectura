/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tacot
 */
public class IniciarPartidaAdmin implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int fichasDePartida;
    private List<JugadorBase> listaJugadores;

    public IniciarPartidaAdmin(int fichasDePartida, List<JugadorBase> listaJugadores) {
        this.fichasDePartida = fichasDePartida;
        this.listaJugadores = listaJugadores;
    }

    public int getFichasDePartida() {
        return fichasDePartida;
    }

    public void setFichasDePartida(int fichasDePartida) {
        this.fichasDePartida = fichasDePartida;
    }

    public List<JugadorBase> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<JugadorBase> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    
}
