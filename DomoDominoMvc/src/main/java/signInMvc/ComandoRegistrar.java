/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package signInMvc;

import comands.IComando;

/**
 *
 * @author tacot
 */
public class ComandoRegistrar implements IComando{

    private final SignInControler controlador;

    public ComandoRegistrar(SignInControler controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void ejecutarComando() {
        controlador.registrar();
    }
    
}
