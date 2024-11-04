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
public class Jugador implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String ip;
    private int puerto;
    private String codigo;

    public Jugador(String ip, int puerto, String codigo) {
        this.ip = ip;
        this.puerto = puerto;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
