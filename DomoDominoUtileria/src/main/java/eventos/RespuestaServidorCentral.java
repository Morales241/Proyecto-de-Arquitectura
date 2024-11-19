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
    private String respuesta;
    private int opcionRespuesta;
    private boolean llave;
    private String codigo;

    public RespuestaServidorCentral() {
    }

    public RespuestaServidorCentral(int opcionRespuesta, boolean llave) {
        this.opcionRespuesta = opcionRespuesta;
        this.llave = llave;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getOpcionRespuesta() {
        return opcionRespuesta;
    }

    public void setOpcionRespuesta(int opcionRespuesta) {
        this.opcionRespuesta = opcionRespuesta;
    }

    public boolean isLlave() {
        return llave;
    }

    public void setLlave(boolean llave) {
        this.llave = llave;
    }
    
    
}
