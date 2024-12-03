package gestorTurno;

import fachadas.GestorDeComunicacionesFachada;
import fachadasInterfaz.IGestorDeComunicacionesFachada;


public class LogicaGestorTurno implements ILogicaGestorTurno{
    private final IGestorDeComunicacionesFachada comunicaciones;

    public LogicaGestorTurno(GestorDeComunicacionesFachada comunicacionesP) {
        this.comunicaciones = comunicacionesP;
    }

    @Override
    public void gestionarTurno() {
        
    }
}
