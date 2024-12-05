/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadasInterfaz;

import dtos.ArregloDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorBase;
import java.util.List;
import observers.IEventoPasarTurno;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import observers.IEventoValidarFichas;
import observersLogicaAServidorCentral.IEventoSalirDePartida;

/**
 *
 * @author favel
 */
public interface ITableroFachada {

    public void agregarIEventoPonerFicha(IEventoPonerFicha listener);

    public void agregarIEventoTomarFIchaDelPozo(IEventoPedirFichaAlPozo listener);

    public void agregarIEventoSalirDePartida(IEventoSalirDePartida listener);

    public void mandarDatosDeInicioDePartida(JugadorDto jugadorDto, ArregloDto arrayDto, List<JugadorBase> jugadorBases, boolean turno);

    public void mandarArregloActualizado(ArregloDto arrayDto);

    public void mandarJugadoroActualizado(JugadorDto jugadorDto);

    public void avisarDePasoDeTurno(boolean turno);

    public void enviarFichaDelPozo(FichaDto ficha);
    
    public void agregarIEventoValidarFichas(IEventoValidarFichas listener);
    
    public void enviarValidacionDeFichas(boolean validacion);

}
