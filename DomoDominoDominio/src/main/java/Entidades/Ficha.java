/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.ImageIcon;

public class Ficha implements Serializable {

    private Integer lado1;
    private Integer lado2;
    private ImageIcon icono; // Cambiado de String a ImageIcon

    public Ficha() {
    }

    public Ficha(Integer lado1, Integer lado2, ImageIcon icono) { // Constructor actualizado
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.icono = icono;
    }

    public Ficha(Integer lado1, Integer lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Integer getLado1() {
        return lado1;
    }

    public void setLado1(Integer lado1) {
        this.lado1 = lado1;
    }

    public Integer getLado2() {
        return lado2;
    }

    public void setLado2(Integer lado2) {
        this.lado2 = lado2;
    }

    public ImageIcon getIcono() { // Método actualizado
        return icono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.lado1);
        hash = 13 * hash + Objects.hashCode(this.lado2);
        hash = 13 * hash + Objects.hashCode(this.icono); // Actualizado a icono
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ficha other = (Ficha) obj;
        if (!Objects.equals(this.icono, other.icono)) { // Actualizado a icono
            return false;
        }
        if (!Objects.equals(this.lado1, other.lado1)) {
            return false;
        }
        return Objects.equals(this.lado2, other.lado2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ficha{");
        sb.append("lado1=").append(lado1);
        sb.append(", lado2=").append(lado2);
        sb.append(", icono=").append(icono); // Actualizado a icono
        sb.append('}');
        return sb.toString();
    }
}