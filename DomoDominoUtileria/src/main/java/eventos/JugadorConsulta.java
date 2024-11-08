/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

/**
 *
 * @author tacot
 */
public class JugadorConsulta {

    private String ip;
    private String codigo;
    private int puerto;

    public JugadorConsulta() {
    }

    public JugadorConsulta(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public JugadorConsulta(String ip, String codigo, int puerto) {
        this.ip = ip;
        this.codigo = codigo;
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

}
