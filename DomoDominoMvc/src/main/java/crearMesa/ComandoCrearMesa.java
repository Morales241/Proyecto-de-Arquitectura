/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearMesa;

import comands.IComando;

/**
 *
 * @author tacot
 */
public class ComandoCrearMesa implements IComando{

    private final CrearMesaController controlador;

    public ComandoCrearMesa(CrearMesaController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void ejecutarComando() {
        controlador.CrearMesa();
    }
    
}
