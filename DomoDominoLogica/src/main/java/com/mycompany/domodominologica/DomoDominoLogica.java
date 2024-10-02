/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.domodominologica;

import com.mycompany.domodominopersistencia.Ficha;
import java.util.ArrayList;
import java.util.List;
import pozo.Pozo;

/**
 *
 * @author tacot
 */
public class DomoDominoLogica {

    public static void main(String[] args) {
        Pozo pozo = new Pozo(7);
        pozo.crearFichasPozo();
        System.out.println(pozo.sacarFicha());
        
        List<Ficha> fichas = new ArrayList<>();
        fichas = pozo.repartirFichas();
        
        for (Ficha ficha: fichas) {
            System.out.println(ficha);
        }
    }
}
