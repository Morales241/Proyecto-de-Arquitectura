package crearPartida;

import observers.IEventoCrearPartidaMVC;

/**
 *
 * @author tacot
 */
public class CrearMesaController {
    
    private final CrearMesaModel crearMesaModel;
    private final CrearMesaView crearMesaView;

    public CrearMesaController(CrearMesaModel cMesaModel, CrearMesaView crearMesaView) {
        this.crearMesaModel = cMesaModel;
        this.crearMesaView = crearMesaView;
        crearMesaView.agregarIEventoCrearPartida(new accionCrearPartida());
        
    }
    
    public void validarNombre(String nombre){
        crearMesaModel.validarNombre(nombre);
    }
    
    private class accionCrearPartida implements IEventoCrearPartidaMVC{

        @Override
        public void crearPartida(String nombre) {
            validarNombre(nombre);
        }
    }
}
