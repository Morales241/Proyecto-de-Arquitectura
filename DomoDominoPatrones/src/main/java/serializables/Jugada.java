/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializables;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class Jugada implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String jugada;

    public Jugada() {
    }

    public Jugada(String jugada) {
        this.jugada = jugada;
    }

    public String getJugada() {
        return jugada;
    }

    public void setJugada(String jugada) {
        this.jugada = jugada;
    }
    
    
}
