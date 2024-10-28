package com.mycompany.domodominoservercentral;

import java.io.File;
import observers.IEventoAgregarJugadorAPartida;
import serializables.Jugador;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final String[][] infoPartidas;

    public ServerCentral() {
        infoPartidas = new String[12][5];
    }

    public boolean agregarPartida(String infoSocket, String codigo) {
        for (int i = 0; i < 12; i++) {
            if (infoPartidas[i][0].isEmpty()) {
                infoPartidas[i][0] = infoSocket;
                infoPartidas[i][4] = codigo;
                return true;
            }
        }

        return false;
    }
    
    public void agregarJugadorAPartida(String infoSocket, String codigo){
        for (int i = 0; i < 12; i++) {
            
            if (infoPartidas[i][4].equals(codigo)) {
                
                for (int j = 0; j < 5; j++) {
                    
                    if (infoPartidas[i][j].isEmpty()) {
                        
                        infoPartidas[i][j] = infoSocket;
                        
                    }
                }
                
            }
        }
        
    }

    public class AgregarJugadorAPartida implements IEventoAgregarJugadorAPartida{

        @Override
        public void actualizar(Jugador jugador) {
            
            String info = jugador.getIp()+jugador.getPuerto();
            
            agregarJugadorAPartida(info, jugador.getCodigo());
        }
    }
}
