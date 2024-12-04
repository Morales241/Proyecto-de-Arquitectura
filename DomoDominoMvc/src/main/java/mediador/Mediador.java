package mediador;

import contenedor.ContenedorMvc;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import mediador.IMediador;

/**
 * Clase mediador, encargada del flujo de las pantallas.
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 * @param <M> Clase Modelo
 * @param <V> Clase Vista
 * @param <C> Clase Controlador
 */
public class Mediador<M, V extends JFrame, C> implements IMediador {

    private Map<String, ContenedorMvc<M, V, C>> pantallas;
    private static Mediador instancia;

    /**
     * Contructor de la clase mediador
     */
    private Mediador() {
        this.pantallas = new HashMap<>();
    }

    /**
     * Metodo que muestra una Pantalla Concreta dependiendo del nombre que le recibe como parametro
     *
     * @param nombre Nombre a buscar dentro del mapa
     */
    @Override
    public void mostrarPantallaConcreta(String nombre) {
        //saca en pantalla concreta el nombre que encuentre
         ContenedorMvc<M, V, C> pantallaConcreta = pantallas.get(nombre);
        if (pantallaConcreta != null) {
            pantallas.values().forEach((otrasPantallas) -> {
                if (!pantallas.get("aviso").equals(otrasPantallas)) {
                    otrasPantallas.getVista().setVisible(false);
                }
                
            });
            pantallaConcreta.getVista().setVisible(true);

        } else {
            //Aqui tiren un log de que no se encontro la viewConcreta jejejej
            System.out.println("No se encontro la viewConcreta para mostrar" + nombre);
        }
    }

    /**
     * Metodo que cierra una Pantalla Concreta dependiendo del nombre que le recibe como parametro
     *
     * @param nombre Nombre a buscar dentro del mapa
     */
    @Override
    public void cerrarPantallaConcreta(String nombre) {
        //saca en pantalla concreta el nombre que encuentre
        ContenedorMvc<M, V, C> pantallaConcreta = pantallas.get(nombre);
        if (pantallaConcreta != null) {
            pantallaConcreta.getVista().setVisible(false);

        } else {
            //Aqui tiren un log de que no se encontro la viewConcreta jejejej
            System.out.println("No se encontro la viewConcreta para cerrar" + nombre);
        }
    }

    /**
     * Regresa la pantalla concreta que coincida con el nombre
     *
     * @param nombre
     * @return
     */
    @Override
    public ContenedorMvc obtenerPantallaConcreta(String nombre) {
        ContenedorMvc<M, V, C> pantallaConcreta = pantallas.get(nombre);
        if (pantallaConcreta != null) {
            return pantallaConcreta;
        } else {
            //Aqui tiren un log de que no se encontro la viewConcreta jejejej
            System.out.println("No se encontro la viewConcreta para obtener" + nombre);
        }
        return null;
    }

    /**
     * Resgistra la pantalla, se guarda el nombre y su contenedor
     *
     * @param nombre Nombre con el cual se relaciona el contenedor
     * @param contenedorMvc Contenedor que contiene Vista, Modelo y controlado
     */
    @Override
    public void registrarPantalla(String nombre, ContenedorMvc contenedorMvc) {
        pantallas.put(nombre, contenedorMvc);
    }

    /**
     * Método para obtener la instancia única del Singleton.
     *
     * @param <M>
     * @return La única instancia del Mediador
     */
    public static <M, V extends JFrame, C> Mediador<M, V, C> getInstancia() {
        if (instancia == null) {
            instancia = new Mediador<>();
        }

        return instancia;
    }

    @Override
    public void MostrarAviso() {
         ContenedorMvc<M, V, C> pantallaConcreta = pantallas.get("aviso");
        if (pantallaConcreta != null) {
            pantallaConcreta.getVista().setVisible(true);

        } else {
            //Aqui tiren un log de que no se encontro la viewConcreta jejejej
            System.out.println("No se encontro la viewConcreta para mostrar: aviso");
        }
    }

}
