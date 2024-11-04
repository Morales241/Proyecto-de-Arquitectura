/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorTurno;

import fachadas.ClienteFachada;

/**
 *
 * @author Natasha Ruiz Perez
 */
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
