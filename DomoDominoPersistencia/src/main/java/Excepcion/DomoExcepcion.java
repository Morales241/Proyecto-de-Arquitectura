/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepcion;

/**
 *
 * @author tacot
 */
public class DomoExcepcion extends Exception{

    public DomoExcepcion() {
    }

    public DomoExcepcion(String message) {
        super(message);
    }

    public DomoExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
    
}
