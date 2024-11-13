/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inicializador;

import cliente.Cliente;
import cliente.GestorDeComunicaciones;
import serverInterno.GestorMensajes;
import serverInterno.Servidor;

/**
 *
 * @author Jesus Morales
 */
public class InicializadorComunicaciones {

    private GestorMensajes gestorMensajes;
    private GestorDeComunicaciones comunicaciones;
    private Servidor servidor;

    public InicializadorComunicaciones() {

    }

    public void inicializarClasesComunicaciones() {

        gestorMensajes = new GestorMensajes();
        servidor = new Servidor(8097, gestorMensajes);
        comunicaciones = new GestorDeComunicaciones(gestorMensajes);
    }

}
