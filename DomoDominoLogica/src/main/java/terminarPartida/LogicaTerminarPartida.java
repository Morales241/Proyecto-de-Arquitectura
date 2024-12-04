package terminarPartida;

import eventos.EventoAcabarPartidaDto;
import fachadasInterfaz.IGestorDeComunicacionesFachada;

public class LogicaTerminarPartida implements ILogicaTerminarPartida{
    
    private IGestorDeComunicacionesFachada comunicaciones;
    
    public LogicaTerminarPartida(IGestorDeComunicacionesFachada comunicaciones) {
        this.comunicaciones = comunicaciones;
    }
    
    @Override
    public void acabarPartida(EventoAcabarPartidaDto codigo){
        comunicaciones.enviarMensaje(codigo, "serverCentral");
    }
}
