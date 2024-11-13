package sereverCentral;

import cliente.Cliente;
import eventos.JugadorAEliminarDto;
import eventos.JugadorConsulta;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import eventos.RespuestaServidorCentral;
import java.util.ArrayList;
import java.util.List;
import observers.IEventoAcabarPartida;
import observers.IEventoAgregarJugadorAPartida;
import observers.IEventoCrearPartida;
import observers.IEventoSalirDePartida;
import servidor.GestorMensajes;
import observers.IEventoIniciarPartidaServerCentral;

/**
 *
 * @author tacot
 */
public class ServerCentral {

    private final Object[][] infoPartidas;
    private final Cliente cliente;
    private final GestorMensajes gestorMensajes;

    public ServerCentral(Cliente clienteParametro, GestorMensajes gMensajes) {
        infoPartidas = new Object[6][5];
        this.cliente = clienteParametro;
        this.gestorMensajes = gMensajes;

        this.gestorMensajes.agregarObservadorCrearPartida(new AccionCrearPartida());
        this.gestorMensajes.agregarObservadorAgregarJugador(new AccionUnirseAPartida());
        this.gestorMensajes.agregarObservadorSalirDePartida(new AccionSalirDePartida());
        this.gestorMensajes.agregarObservadorIniciarPartida(new AccionIniciarPartida());
        this.gestorMensajes.agregarObservadorAcabarPartida(new AccionAcabarParitda());

    }

    public void agregarPartida(JugadorCrearPartidaDto jugador) {
        for (int i = 0; i < 6; i++) {
            if (infoPartidas[i][0] == null) {
                infoPartidas[i][0] = jugador;
                infoPartidas[i][4] = jugador.getCodigo();
            }
        }
//        enviar mensaje de que no se pudo registrar partida
    }

    public void agregarJugadorPartida(JugadorUnirseAPartidaDto jugador) {
        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(jugador.getCodigo())) {

                for (int j = 1; j < 5; j++) {

                    if (infoPartidas[i][j] == null) {

                        infoPartidas[i][j] = jugador;

                    }
                }
//               enviar mensaje de que la partida esta llena
            }
        }
//        enviar mensaje de que la partida no se encontro
    }

    public void sacarJugadorDePartida(JugadorAEliminarDto jugador) {
        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(jugador.getCodigo())) {

                for (int j = 1; j < 5; j++) {

                    if (infoPartidas[i][j].equals(jugador)) {

                        infoPartidas[i][j] = null;

                    }
                }
//               enviar mensaje de que el jugador no se encontro en la partida
            }
        }
//        enviar mensaje de que la partida no se encontro
    }

    public List<JugadorConsulta> informacionDePartidaPorCodigo(String codigo) {
        List<JugadorConsulta> jugadoresDePartida = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int k = 0; k < 3; k++) {
                    if (infoPartidas[i][k] != null) {
                        jugadoresDePartida.add((JugadorConsulta) infoPartidas[i][k]);
                    }
                }
            }
        }

        return jugadoresDePartida;
    }

    public void acabarPartidaPorCodigo(String codigo) {
        for (int i = 0; i < 6; i++) {

            if (infoPartidas[i][4].equals(codigo)) {

                for (int k = 0; k < 5; k++) {
                    infoPartidas[i][k] = "";
                }
            }
        }
    }

    public void mandarMensaje(String mensaje) {
        RespuestaServidorCentral respuesta = new RespuestaServidorCentral(mensaje);
        cliente.enviarMensaje(respuesta);
    }

    public void mandarInfoDePartida(List<JugadorConsulta> jugadores) {

        for (JugadorConsulta jugador : jugadores) {
            cliente.enviarMensaje(jugador);
        }

    }

    private class AccionCrearPartida implements IEventoCrearPartida {

        @Override
        public void crearPartida(JugadorCrearPartidaDto jugador) {
            agregarPartida(jugador);
        }

    }

    private class AccionUnirseAPartida implements IEventoAgregarJugadorAPartida {

        @Override
        public void agregarJugadorAPartida(JugadorUnirseAPartidaDto jugador) {
            agregarJugadorPartida(jugador);
        }

    }

    private class AccionSalirDePartida implements IEventoSalirDePartida {

        @Override
        public void salirDePartida(JugadorAEliminarDto jugador) {
            sacarJugadorDePartida(jugador);
        }

    }

    private class AccionIniciarPartida implements IEventoIniciarPartidaServerCentral {

        @Override
        public void iniciarPartida(String codigo) {
            List<JugadorConsulta> jugadores = informacionDePartidaPorCodigo(codigo);
            mandarInfoDePartida(jugadores);
        }

    }

    private class AccionAcabarParitda implements IEventoAcabarPartida {

        @Override
        public void acabarPartida(String codigo) {
            acabarPartidaPorCodigo(codigo);

        }
    }
}
