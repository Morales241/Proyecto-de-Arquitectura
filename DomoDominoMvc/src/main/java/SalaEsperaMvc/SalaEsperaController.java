package SalaEsperaMvc;

/**
 * Controlador de la sala de espera
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class SalaEsperaController {
    private SalaEsperaView salaEsperaView;
    private SalaEsperaModel salaEsperaModel;

    public SalaEsperaController(SalaEsperaView salaEsperaView, SalaEsperaModel salaEsperaModel) {
        this.salaEsperaView = salaEsperaView;
        this.salaEsperaModel = salaEsperaModel;
    }
    
}
