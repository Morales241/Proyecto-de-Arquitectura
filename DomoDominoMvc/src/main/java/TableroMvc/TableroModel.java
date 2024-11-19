package TableroMvc;

import java.util.ArrayList;
import java.util.List;
import dtos.FichaDto;
import observers.IEventoTomarFichaDelPozo;
import observers.IObserver;

public class TableroModel  {

    private int numeroFichas = 7;
    private List<FichaDto> fichas;
    private List<IObserver> observadores = new ArrayList<>();
    private FichaDto fichaSeleccionada;

    private IObserver observerTomarDelPozo;
    private IObserver observerPonerFicha;
    private IObserver observerPasarTurno;
    private IObserver observerSalirDePartida;
    
    
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
    
    public void agregarIEventoSalirDePartida(IObserver listener) {
          this.observerSalirDePartida = listener;
    }
    
    public void ejecutarAccionSalirDePartida() {
          if (observerSalirDePartida != null) {
                observerSalirDePartida.actualizar();
          }
    }
    
    public void agregarIEventoPasarTurno(IObserver listener) {
          this.observerPasarTurno = listener;
    }
    
    public void ejecutarAccionPasarTurno() {
          if (observerPasarTurno != null) {
                observerPasarTurno.actualizar();
          }
    }
    
    public void agregarIEventoPonerFicha(IObserver listener) {
          this.observerPonerFicha = listener;
    }
    
    public void ejecutarAccionPonerFicha() {
          if (observerPonerFicha != null) {
                observerPonerFicha.actualizar();
          }
    }
    
    public void agregarIEventoTomarDelPozo(IObserver listener) {
          this.observerTomarDelPozo = listener;
    }
    
    public void ejecutarAccionTomarDelPozo() {
          if (observerTomarDelPozo != null) {
                observerTomarDelPozo.actualizar();
          }
    }
}
