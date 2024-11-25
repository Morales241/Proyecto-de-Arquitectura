/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observers;

import dtos.FichaDto;
import java.util.List;

public interface IEventoActualizarVista {
    
    public void actualizarFichasJugador(List<FichaDto> fichas);
}
