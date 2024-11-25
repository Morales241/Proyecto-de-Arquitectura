/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crearPartida;

import objetosDeEventos.JugadorCrearPartidaDto;
import objetosDeEventos.RespuestaDePartidaCreada;

/**
 *
 * @author tacot
 */
public interface ILogicaCrearPartida {
    public void regresarAlInicio();
    public void crearPartida(JugadorCrearPartidaDto jugador);
    public void procesarRespuesta(RespuestaDePartidaCreada respuestaDePartidaCreada);
}
