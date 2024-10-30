package com.mycompany.domodominoservercentral;

import enumerados.RespuestaServidor;
import java.util.ArrayList;
import java.util.List;
import observers.IEventoRespuestaServidorCentral;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final String[][] infoPartidas;

    public ServerCentral() {
        infoPartidas = new String[12][5];
    }

    public RespuestaServidor agregarPartida(String infoSocket, String codigo) {
        for (int i = 0; i < 12; i++) {
            if (infoPartidas[i][0].isEmpty()) {
                infoPartidas[i][0] = infoSocket;
                infoPartidas[i][4] = codigo;
                return RespuestaServidor.seRegistroPartidaExitosamente;
            }
        }

        return RespuestaServidor.noSePudoRegistrarPartida;
    }

    public RespuestaServidor agregarJugadorAPartida(String infoSocket, String codigo) {
        for (int i = 0; i < 12; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int j = 1; j < 5; j++) {

                    if (infoPartidas[i][j].isEmpty()) {

                        infoPartidas[i][j] = infoSocket;

                        return RespuestaServidor.seRegistroJugadorExitosamente;

                    }
                }
                return RespuestaServidor.partidaLlena;
            }
        }
        return RespuestaServidor.partidaNoEncontrada;
    }

    public List<String> informacionDePartidaPorJugador(String infoSocket) {

        List<String> informacionPartida = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 4; j++) {

                if (infoPartidas[i][j].equals(infoSocket)) {

                    for (int k = 0; k < 5; k++) {
                        informacionPartida.add(infoPartidas[i][k]);
                    }
                }
            }
        }
        return informacionPartida;
    }

    public List<String> informacionDePartidaPorCodigo(String codigo) {
        List<String> informacionPartida = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int k = 0; k < 5; k++) {
                    informacionPartida.add(infoPartidas[i][k]);
                }
            }
        }
        return informacionPartida;
    }

    public void acabarPartida(String codigo) {
        for (int i = 0; i < 12; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int k = 0; k < 5; k++) {
                    infoPartidas[i][k] = "";
                }
            }
        }
    }

}
