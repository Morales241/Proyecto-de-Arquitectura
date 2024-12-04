/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crearPartida;

import eventos.JugadorCrearPartidaDto;

/**
 *
 * @author tacot
 */
public interface ILogicaCrearPartida {
    public void regresarAlInicio();
    public String crearPartida(JugadorCrearPartidaDto jugador);
}
