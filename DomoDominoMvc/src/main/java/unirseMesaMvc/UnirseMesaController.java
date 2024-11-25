package unirseMesaMvc;

/**
 * Controlador de unirse a mesa
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class UnirseMesaController {
    private UnirseMesaController unirseMesaController;
    private UnirseMesaView unirseMesaView;

    public UnirseMesaController(UnirseMesaController unirseMesaController, UnirseMesaView unirseMesaView) {
        this.unirseMesaController = unirseMesaController;
        this.unirseMesaView = unirseMesaView;
    }    
}
