package crearPartida;

import eventos.JugadorCrearPartidaDto;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class CrearPartidaController {
    
    private final CrearPartidaModel crearMesaModel;
    private final CrearPartidaView crearMesaView;

    public CrearPartidaController(CrearPartidaModel cMesaModel, CrearPartidaView crearMesaView) {
        this.crearMesaModel = cMesaModel;
        this.crearMesaView = crearMesaView;
        crearMesaView.agregarIEventoCrearPartida(new accionCrearPartida());
        crearMesaView.agregarIEventoRegresar(new accionRegresar());
        
    }
    
    public void validarNombre(JugadorCrearPartidaDto jugador){
        crearMesaModel.validarNombre(jugador);
    }
    
    public void regresar(){
        crearMesaModel.ejecutarAccionRegresar();
    }
    
    private class accionCrearPartida implements IEventoCrearPartida{

        
        @Override
        public void crearPartida(JugadorCrearPartidaDto jugador) {
            validarNombre(jugador);
        }
    }
    
    private class accionRegresar implements IObserver{

        @Override
        public void actualizar() {
            regresar();
        }
    }
}
