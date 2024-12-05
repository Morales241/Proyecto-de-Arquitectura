package tablero;

import dtos.ArregloDto;
import dtos.JugadorDto;
import eventos.JugadorBase;
import fachadasInterfaz.ITableroFachada;
import java.util.List;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import observersLogicaAServidorCentral.IEventoSalirDePartida;

/**
 *
 * @author tacot
 */
public class LogicaTablero implements ILogicaTablero {
    
    private final ITableroFachada tableroFachada;
    
    public LogicaTablero(ITableroFachada tableroFachada) {
        this.tableroFachada = tableroFachada;
    }
    
    @Override
    public void agregarIEventoPonerFicha(IEventoPonerFicha listener) {
        tableroFachada.agregarIEventoPonerFicha(listener);
    }
    
    @Override
    public void agregarIEventoTomarFIchaDelPozo(IEventoPedirFichaAlPozo listener) {
        tableroFachada.agregarIEventoTomarFIchaDelPozo(listener);
    }
    
    @Override
    public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener) {
        tableroFachada.agregarIEventoSalirDePartida(listener);
    }
    
    @Override
    public void mandarDatosDeInicioDePartida(JugadorDto jugadorDto, ArregloDto arrayDto, List<JugadorBase> jugadorBases) {
        tableroFachada.mandarDatosDeInicioDePartida(jugadorDto, arrayDto, jugadorBases);
    }
    
    @Override
    public void mandarArregloActualizado(ArregloDto arrayDto) {
        tableroFachada.mandarArregloActualizado(arrayDto);
        
    }

    @Override
    public void mandarJugadorActualizado(JugadorDto jugadorDto) {
        tableroFachada.mandarJugadoroActualizado(jugadorDto);
        }
}
