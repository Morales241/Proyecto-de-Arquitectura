package TableroMvc;

import java.util.ArrayList;
import java.util.List;
import dtos.FichaDto;
import observers.IObserver;

public class TableroModel  {

    private int numeroFichas = 7;
    private List<FichaDto> fichas;
    private List<IObserver> observadores = new ArrayList<>();
    private FichaDto fichaSeleccionada;

    public TableroModel() {
        
    }

    public void repartirFichas(List<FichaDto> fichas) {
        this.fichas = fichas;
        
    }


    public List<FichaDto> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaDto> fichas) {
        this.fichas = fichas;
    }

    public void actualizarFichaSelecionada(FichaDto fichaSelect) {
        this.fichaSeleccionada = fichaSelect;
    }
}
