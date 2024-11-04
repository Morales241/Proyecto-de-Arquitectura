package gestorTurno;

import fachadas.ClienteFachada;

public class LogicaGestorTurno implements ILogicaGestorTurno{
    private ClienteFachada clienteFachada;

    public LogicaGestorTurno(ClienteFachada fachadaCliente) {
        this.clienteFachada = fachadaCliente;
    }

    @Override
    public void gestionarTurno() {
        clienteFachada.enviarMensaje("Turno cambiado");
    }
}
