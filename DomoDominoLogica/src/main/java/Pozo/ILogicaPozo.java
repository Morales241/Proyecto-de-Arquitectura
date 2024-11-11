/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Pozo;

import Entidades.Ficha;
import java.util.List;

public interface ILogicaPozo {
     
    public void crearFichasPozo();
    
    public Ficha sacarFicha();
    
    public List<Ficha> repartirFichas(int numeroFichas);
    
    public void recibirFichas(List<Ficha> fichasJugador);
    
    public boolean pozoVacio();
}
