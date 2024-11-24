package TableroMvc;

import dtos.ArregloDto;
import java.util.ArrayList;
import java.util.List;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.PasarTurno;
import eventos.PonerFichaDto;
import observers.IEventoPasarTurno;
import observers.IEventoPonerFicha;
import observers.IEventoSalirDePartida;
import observers.IEventoTomarFichaDelPozo;
import observers.IObserver;

public class TableroModel  {

//Arreglo
    ArregloDto arreglo = new ArregloDto();
    //Fichas
    private int numeroFichas = 7;
    private List<FichaDto> fichas;
    private FichaDto fichaSeleccionada;
    private PonerFichaDto ponerFicha;
    
    //Jugadores
    private List<IObserver> observadores = new ArrayList<>();
    private JugadorDto jugador;
    private JugadorAEliminarDto jugadorAeliminar; 
    private PasarTurno pasarTurno;
    
    //Eventos
    private IEventoPonerFicha observerPonerFicha;
    private IEventoTomarFichaDelPozo observerTomarDelPozo;
    private IEventoPasarTurno observerPasarTurno;
    private IEventoSalirDePartida observerSalirDePartida;
    
    public TableroModel() {
        
    }
public int[][] traerArreglo(){
    return arreglo.getTablero();
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
    
    /*
    EVENTO DE PONER FICHA
    */
    public void agregarIEventoPonerFIcha(IEventoPonerFicha listener) {
         this.observerPonerFicha = listener;
    }
    
    public void ejecutarAccionPonerFicha(PonerFichaDto ponerFicha) {
         if (observerPonerFicha != null) {
              observerPonerFicha.ponerFicha(ponerFicha);
         }
    }
 
    /*
    EVENTO DE SACAR FICHA DEL POZO
    */
    public void agregarIEventoSacarFichaDelPozo(IEventoTomarFichaDelPozo listener) {
         this.observerTomarDelPozo = listener;
    }
    
    public void ejecutarAccionTomarFichaDelPozo(FichaDto ficha) {
         if (observerTomarDelPozo != null) {
              observerTomarDelPozo.tomarFichaDelPozo(ficha);
         }
    }
    
    
    /*
    EVENTO DE PASAR TURNO
    */
    public void agregarEventoPasarTurno(IEventoPasarTurno listener) {
         this.observerPasarTurno = listener;
    }
    
    public void ejecutarEventoPasarTurno(PasarTurno pasarTurno) {
         if (observerPasarTurno != null) {
              observerPasarTurno.pasarTurno(pasarTurno);
         }
    }
    
    /*
    SEGURAMENTE ESTE ESTE MAL IMPLEMENTADO
    */
    public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener) {
          this.observerSalirDePartida = listener;
    }
    public void ejecutarAccionSalirDePartida() {
          if (observerSalirDePartida != null) {
                observerSalirDePartida.salirDePartida(jugadorAeliminar);
          }
    }
}
