/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author favel
 */
public class JugadorDto {
    private String nombre;
    private final List<FichaDto> fichas; 

    public JugadorDto(String nombre) {
        this.nombre = nombre;
        this.fichas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<FichaDto> getFichas() {
        return fichas;
    }

    public void agregarFicha(FichaDto ficha) {
        this.fichas.add(ficha);
    }

    public void agregarFichas(List<FichaDto> fichas) {
        this.fichas.addAll(fichas);
    }

    public void mostrarFichas() {
        for (FichaDto ficha : fichas) {
            System.out.println(ficha);
        }
    }
}
