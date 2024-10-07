/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inicio;

import InicioMvc.InicioModel;
import dtos.UsuarioDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mediador.IMediador;
import mediador.Mediador;

/**
 *
 * @author tacot
 */
public class LogicaInicio implements ILogicaInicio {

    private final IMediador mediador;
    private final InicioModel inicioModel;

    public LogicaInicio(InicioModel inicioModel) {
        this.inicioModel = inicioModel;
        this.mediador = Mediador.getInstancia();
        
        inicioModel.agregarActionListenerJugar(new AccionIniciarJuego());
    }

    @Override
    public void Jugar() {
        mediador.mostrarPantallaConcreta("tablero");
    }

    private class AccionIniciarJuego implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("asdads");
            Jugar();
        }
    }
}
