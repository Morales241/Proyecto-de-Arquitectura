package com.mycompany.domodominoservercentral;

import dtos.JugadorDto;
import enumerados.RespuestaServidor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final Object[][] infoPartidas;

    public ServerCentral() {
        infoPartidas = new Object[6][5];
    }

    public RespuestaServidor agregarPartida(JugadorDto jugador, String codigo) {
        for (int i = 0; i < 6; i++) {
            if (infoPartidas[i][0] == null) {
                infoPartidas[i][0] = jugador;
                infoPartidas[i][4] = codigo;
                return RespuestaServidor.seRegistroPartidaExitosamente;
            }
        }
        return RespuestaServidor.noSePudoRegistrarPartida;
    }

    public RespuestaServidor agregarJugadorAPartida(JugadorDto jugador, String codigo) {
        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int j = 1; j < 5; j++) {

                    if (infoPartidas[i][j]== null) {

                        infoPartidas[i][j] = jugador;

                        return RespuestaServidor.seRegistroJugadorExitosamente;

                    }
                }
                return RespuestaServidor.partidaLlena;
            }
        }
        return RespuestaServidor.partidaNoEncontrada;
    }

    public List<Object> informacionDePartidaPorJugador(JugadorDto jugador) {

        List<Object> informacionPartida = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 4; j++) {

                if (infoPartidas[i][j].equals(jugador)) {

                    for (int k = 0; k < 5; k++) {
                        informacionPartida.add(infoPartidas[i][k]);
                    }
                }
            }
        }
        return informacionPartida;
    }

    public List<Object> informacionDePartidaPorCodigo(String codigo) {
        List<Object> informacionPartida = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int k = 0; k < 4; k++) {
                    informacionPartida.add(infoPartidas[i][k]);
                }
            }
        }
        return informacionPartida;
    }

    public void acabarPartida(String codigo) {
        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int k = 0; k < 5; k++) {
                    infoPartidas[i][k] = "";
                }
            }
        }
    }
}
