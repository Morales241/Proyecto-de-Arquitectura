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
public class VotoDeJugador implements Serializable{
    private static final long serialVersionUID = 1L;
    private String Codigo;

    public VotoDeJugador(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
}
