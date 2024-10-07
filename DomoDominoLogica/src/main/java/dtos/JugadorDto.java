/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.ArrayList;
import java.util.List;
import pozo.Ficha;

/**
 *
 * @author favel
 */
public class JugadorDto {
    private String nombre;
    private List<Ficha> fichas; // Lista para guardar las fichas del jugador

    // Constructor
    public JugadorDto(String nombre) {
        this.nombre = nombre;
        this.fichas = new ArrayList<>();
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del jugador
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener la lista de fichas del jugador
    public List<Ficha> getFichas() {
        return fichas;
    }

    // Método para agregar una ficha a la lista del jugador
    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    // Método para agregar varias fichas a la lista del jugador
    public void agregarFichas(List<Ficha> fichas) {
        this.fichas.addAll(fichas);
    }

    // Método para mostrar las fichas del jugador
    public void mostrarFichas() {
        for (Ficha ficha : fichas) {
            System.out.println(ficha);
        }
    }

}
