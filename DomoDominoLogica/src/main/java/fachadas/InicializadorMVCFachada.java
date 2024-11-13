/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import inicializadorMVC.InicializadorMVC;

/**
 *
 * @author tacot
 */
public class InicializadorMVCFachada implements IinicializadorMVCFachada{
    private final InicializadorMVC inicializadorMVC;

    public InicializadorMVCFachada() {
        this.inicializadorMVC = new InicializadorMVC();
    }

    @Override
    public void inciializarMVC() {
        this.inicializadorMVC.inicializarClases();
    }
    
}
