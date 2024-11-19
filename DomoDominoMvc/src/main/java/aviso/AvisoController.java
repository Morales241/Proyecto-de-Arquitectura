package aviso;

import observers.IObserver;

/**
 *
 * @author tacot
 */
public class AvisoController {

    private final AvisoModel avisoModel;
    private final AvisoView avisoView;

    public AvisoController(AvisoModel avisoModel, AvisoView avisoView) {
        this.avisoModel = avisoModel;
        this.avisoView = avisoView;
        this.avisoView.agregarEventoCerrarPantalla(new AccionCerrarPantalla());
    }
    
    public void cerrarPantalla() {
        avisoModel.notificarEventoCerrarPantalla();
    }

    private class AccionCerrarPantalla implements IObserver{

        @Override
        public void actualizar() {
            cerrarPantalla();
        }
    
    }
    
}
