package mediador;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class Mediador implements IMediador {

    private Map<String, JFrame> views;

    public Mediador() {
        this.views = new HashMap<>();
    }

    @Override
    public void registrarView(String nombre, JFrame view) {
        views.put(nombre, view);
        view.setVisible(false); //ASI NO SE MUESTRAN DE UNA, SE INICIALIZAN OCULTAS GIGABRAIN
    }

    @Override
    public void mostrarViewConcreta(String nombre) {
        JFrame viewConcreta = views.get(nombre);
        if (viewConcreta != null) {
            //no se por que pero "t" es la segunda posicion del map, osea la vista concreta.
            views.values().forEach((t) -> {
                t.setVisible(false);
            });
            viewConcreta.setVisible(true);
        } else {
            //Aqui tiren un log de que no se encontro la viewConcreta jejejej
            System.out.println("No se encontro la viewConcreta "+ nombre);
        }

    }

}
