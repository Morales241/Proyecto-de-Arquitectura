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
public class JugadorConsulta implements Serializable{
    private static final long serialVersionUID = 1L;
    private NodoDto nodo;
    private String codigo;

    public JugadorConsulta() {
    }

    public JugadorConsulta(NodoDto nodo, String codigo) {
        this.nodo = nodo;
        this.codigo = codigo;
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
    
}
