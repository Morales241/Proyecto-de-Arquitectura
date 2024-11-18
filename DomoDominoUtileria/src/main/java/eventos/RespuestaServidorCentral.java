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
public class RespuestaServidorCentral implements Serializable{
    private static final long serialVersionUID = 1L;
    String Respuesta;

    public RespuestaServidorCentral(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
    
    
}
