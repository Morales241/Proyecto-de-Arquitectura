/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginMvc;

import comands.IComando;

/**
 *
 * @author favel
 */
public class ComandoLogin implements IComando{
    private LoginControler controlador;

    public ComandoLogin(LoginControler control) {
        controlador = control;
    }

    @Override
    public void ejecutarComando() {
        controlador.logIn();
    }
    
    
    
}
