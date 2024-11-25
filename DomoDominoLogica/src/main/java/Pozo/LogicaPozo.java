/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pozo;


import TableroMvc.TableroModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Entidades.Pozo;
import Entidades.Ficha;

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
    public Ficha sacarFicha() {
        Random random = new Random();
        if (!pozoVacio()) {
            int posicion = random.nextInt(pozo.obtenerFichas().size());
            Ficha ficha = pozo.obtenerFichas().get(posicion);
            pozo.obtenerFichas().remove(posicion);
            return ficha;
        }
        return null;
    }

    @Override
    public List<Ficha> repartirFichas(int numeroFichas) {
        List<Ficha> fichasARepartir = new ArrayList<>();
        for (int i = 0; i < numeroFichas; i++) {
            Ficha ficha = sacarFicha();
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

}