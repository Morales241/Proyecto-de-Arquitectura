/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosDeEventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class JugadorConsulta implements Serializable{
    private static final long serialVersionUID = 1L;
    private NodoDto nodo;
    private String codigo;
     private int avatar;
    private String nombre;

    public JugadorConsulta() {
    }

    public JugadorConsulta(NodoDto nodo, String codigo, int avatar, String nombre) {
        this.nodo = nodo;
        this.codigo = codigo;
        this.avatar = avatar;
        this.nombre = nombre;
    }

    public NodoDto getNodo() {
        return nodo;
    }

    public void setNodo(NodoDto nodo) {
        this.nodo = nodo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
