/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

import java.io.Serializable;

/**
 *
 * @author Jesus Morales
 */
public class NodoDto implements Serializable{
    private static final long serialVersionUID = 1L;
    private String ip;
    private int puerto;
    private String nombre;

    public NodoDto(String ip, int puerto, String nombre) {
        this.ip = ip;
        this.puerto = puerto;
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    
}
