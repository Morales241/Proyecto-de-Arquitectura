/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lobby;

import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.VotoDeJugador;
import fachadas.LobbyFachada;
import fachadasInterfaz.IGestorDeComunicacionesFachada;
import observersLogicaAServidorCentral.IEventoSalirDeLobby;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;

/**
 *
 * @author tacot
 */
public class LobbyLogica implements ILobbyLogica {

    private final LobbyFachada lobbyFachada;
    private final IGestorDeComunicacionesFachada comunicaciones;
    private String nombre;
    private int avatar;

    public LobbyLogica(LobbyFachada lobbyFachada, IGestorDeComunicacionesFachada comunicaciones) {
        this.lobbyFachada = lobbyFachada;
        this.comunicaciones = comunicaciones;
    }

    @Override
    public void agregarObservadorVotar(IEventoVotarParaIniciarPartida listener) {
        lobbyFachada.agregarObservadorVotar(listener);
    }

    @Override
    public void agregarObservadorSalir(IEventoSalirDeLobby listener) {
        lobbyFachada.agregarObservadorSalir(listener);
    }

    @Override
    public void actualizarLobby(JugadorBase jugadorBase) {
        lobbyFachada.actualizarLobby(jugadorBase);
    }

    @Override
    public void inicializarnos(String nombre, int avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }

    @Override
    public void salirDeLobby(JugadorAEliminarDto jugadorAEliminarDto){
        comunicaciones.enviarMensaje(jugadorAEliminarDto, "serverCentral");
    }
    
    @Override
    public void votarParaIniciarPartida(VotoDeJugador votoDeJugador){
        comunicaciones.enviarMensaje(votoDeJugador, "serverCentral");
    }
}
