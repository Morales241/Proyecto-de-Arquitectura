package crearMesa;

import observers.IObserverString;


public class CrearMesaController implements IObserverString{
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
    
     void CrearMesa(){
    //codigo pa crear mesa jajsaj
    }

    @Override
    public void actualizar(String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
