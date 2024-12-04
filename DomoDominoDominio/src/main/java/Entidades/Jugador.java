/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

     private String nombre;
     private int avatar;
     private List<Ficha> fichas;

     public Jugador(String nombre) {
          this.nombre = nombre;
          this.fichas = new ArrayList<>();
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public List<Ficha> getFichas() {
          return fichas;
     }

     public void agregarFicha(Ficha ficha) {
          this.fichas.add(ficha);
     }

     public boolean eliminarFicha(Ficha ficha) {
          if (this.fichas.contains(ficha)) {
               this.fichas.remove(ficha);
               return true;
          } else {
               return false;
          }
     }

     public void agregarFichas(List<Ficha> fichas) {
          this.fichas.addAll(fichas);
     }

     public void mostrarFichas() {
          for (Ficha ficha : fichas) {
               System.out.println(ficha);
          }
     }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
     
     
}
