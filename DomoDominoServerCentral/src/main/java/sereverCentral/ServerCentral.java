package sereverCentral;

import cliente.Cliente;
import eventos.JugadorAEliminarDto;
import eventos.JugadorCrearPartidaDto;
import eventos.JugadorUnirseAPartidaDto;
import eventos.NodoDto;
import eventos.RespuestaServidorCentral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private final Map<String, List<NodoDto>> infoPartidas;
    private final Cliente cliente;
    private final GestorMensajes gestorMensajes;

    public ServerCentral(Cliente clienteParametro, GestorMensajes gMensajes) {
        infoPartidas = new HashMap<>();
        this.cliente = clienteParametro;
        this.gestorMensajes = gMensajes;

        this.gestorMensajes.agregarObservadorCrearPartida(new AccionCrearPartida());
        this.gestorMensajes.agregarObservadorAgregarJugador(new AccionUnirseAPartida());
        this.gestorMensajes.agregarObservadorSalirDePartida(new AccionSalirDePartida());
        this.gestorMensajes.agregarObservadorIniciarPartida(new AccionIniciarPartida());
        this.gestorMensajes.agregarObservadorAcabarPartida(new AccionAcabarParitda());

    }

    public void agregarPartida(JugadorCrearPartidaDto jugador) {
        List<NodoDto> nodos = new ArrayList<>();
        nodos.add(jugador.getNodo());
        this.infoPartidas.put(jugador.getCodigo(), nodos);
    }

    public void agregarJugadorPartida(JugadorUnirseAPartidaDto jugador) {

        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());
        if (seEncontroPartida) {

            this.infoPartidas.get(jugador.getCodigo()).add(jugador.getNodo());
        } else {
//        enviar mensaje de que la partida no se encontro
        }
    }

    public void sacarJugadorDePartida(JugadorAEliminarDto jugador) {
        boolean seEncontroPartida = infoPartidas.containsKey(jugador.getCodigo());
        List<NodoDto> nodos = new ArrayList<>();
        if (seEncontroPartida) {

            this.infoPartidas.get(jugador.getCodigo()).remove(jugador.getNodo());
            
            //enviar mensaje
        } else {
//        enviar mensaje de que la partida no se encontro
        }
    }

    public List<NodoDto> informacionDePartidaPorCodigo(String codigo) {
        boolean seEncontroPartida = infoPartidas.containsKey(codigo);
               
        return seEncontroPartida ? infoPartidas.get(codigo) : new ArrayList<>();
    }

    public void acabarPartidaPorCodigo(String codigo) {
        infoPartidas.remove(codigo);
    }

    public void mandarMensaje(String mensaje) {
        RespuestaServidorCentral respuesta = new RespuestaServidorCentral(mensaje);
        cliente.enviarMensaje(respuesta);
    }

    public void mandarInfoDePartida(List<NodoDto> jugadores) {

        for (NodoDto jugador : jugadores) {
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
            List<NodoDto> jugadores = informacionDePartidaPorCodigo(codigo);
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
