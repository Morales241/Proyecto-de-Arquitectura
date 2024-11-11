/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Ficha implements Serializable {

    private Integer lado1;
      private Integer lado2;

      public Ficha() {
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

      public boolean esMula() {
            return this.getLado1() == this.getLado2();
      }

      @Override
      public String toString() {
            return "Ficha{" + "lado1=" + lado1 + ", lado2=" + lado2 + '}';
      }
}