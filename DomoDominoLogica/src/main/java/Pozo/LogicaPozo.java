/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pozo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Entidades.Pozo;
import Entidades.Ficha;
import dtos.FichaDto;

public class LogicaPozo implements ILogicaPozo {

    private final Pozo pozo;

    public LogicaPozo() {
        this.pozo = Pozo.obtenerInstancia();
        crearFichasPozo();
    }

    @Override
    public void crearFichasPozo() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha ficha = new Ficha(i, j);
                pozo.obtenerFichas().add(ficha);
            }
        }
    }

    @Override
    public FichaDto sacarFicha() {
        Random random = new Random();
        if (!pozoVacio()) {
            int posicion = random.nextInt(pozo.obtenerFichas().size());
            FichaDto fichadto;

            fichadto = new FichaDto(pozo.obtenerFichas().get(posicion).getLado1(), pozo.obtenerFichas().get(posicion).getLado2());

            pozo.obtenerFichas().remove(posicion);
            return fichadto;
        }
        return null;
    }

    @Override
    public List<FichaDto> repartirFichas(int numeroFichas) {
        List<FichaDto> fichasARepartir = new ArrayList<>();
        for (int i = 0; i < numeroFichas; i++) {
            FichaDto ficha = sacarFicha();
            if (ficha != null) {
                fichasARepartir.add(ficha);
            }
        }
        return fichasARepartir;
    }

    @Override
    public void recibirFichas(List<Ficha> fichasJugador) {
        pozo.obtenerFichas().addAll(fichasJugador);
    }

    @Override
    public boolean pozoVacio() {
        return pozo.obtenerFichas().isEmpty();
    }

    @Override
    public void sacarFichasEspecificasPozo(List<FichaDto> fichas) {
        
        List<Ficha> fichasEntidad = new ArrayList<>();
        
        for (FichaDto ficha : fichas) {
            fichasEntidad.add(new Ficha(ficha.getLado1(), ficha.getLado2()));
        }
        
        pozo.sacarFichasEspecificasPozo(fichasEntidad);
    }
}
