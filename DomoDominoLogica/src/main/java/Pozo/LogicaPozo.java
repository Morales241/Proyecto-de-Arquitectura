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
import java.util.Iterator;

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
            int posicion = random.nextInt(Pozo.obtenerInstancia().obtenerFichas().size());
            Ficha fichaSeleccionada = Pozo.obtenerInstancia().obtenerFichas().get(posicion);

            FichaDto fichadto = new FichaDto(fichaSeleccionada.getLado1(), fichaSeleccionada.getLado2());
            Pozo.obtenerInstancia().obtenerFichas().remove(posicion);

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
        return Pozo.obtenerInstancia().obtenerFichas().isEmpty();
    }

    @Override
    public void sacarFichasEspecificasPozo(List<FichaDto> fichas) {

        List<Ficha> fichasEntidad = new ArrayList<>();

        for (FichaDto ficha : fichas) {
            fichasEntidad.add(new Ficha(ficha.getLado1(), ficha.getLado2()));
        }

        pozo.obtenerFichas().removeAll(fichasEntidad);

    }

    @Override
    public void sacarFichaEspecifica(int lado1, int lado2) {
        Ficha ficha = new Ficha(lado1, lado2);
        
        pozo.obtenerFichas().remove(ficha);
        
    }
}
