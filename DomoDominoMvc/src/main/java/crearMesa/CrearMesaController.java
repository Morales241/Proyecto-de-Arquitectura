/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearMesa;

import observers.IObserver;

/**
 *
 * @author tacot
 */
public class CrearMesaController implements IObserver{
    private CrearMesaView vista;
    private CrearMesaModel modelo;

    public CrearMesaController(CrearMesaView vista, CrearMesaModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

//    @Override
//    public void actualizar(IComando comando) {
//        if (comando != null) {
//            comando.ejecutarComando();
//        }
//    }
    
    public void Regresar(){
    //codigo pa regresar asajssjad
    }
    
    public void CrearMesa(){
    //codigo pa crear mesa jajsaj
    }

    @Override
    public void actualizar(String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
