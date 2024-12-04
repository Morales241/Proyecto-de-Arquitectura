/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class JugadorSeUnioAPartida implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int avatar;

    public JugadorSeUnioAPartida(String nombre, int avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
    
    
}
