package Inicio;

import fachadas.IInicioFachada;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mediador.IMediador;
import mediador.Mediador;
import observers.IEventoValidacionDeNombre;

/**
 * Clase principal de Logica en la que inicia el juego
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LogicaInicio implements ILogicaInicio {

    private final IMediador mediador;

    public LogicaInicio() {
        this.mediador = Mediador.getInstancia();
    }

    @Override
    public void Jugar() {
        mediador.mostrarPantallaConcreta("tablero");
    }
    
    public String validarNombre(String nombre){
        
        
        Pattern validacion = Pattern.compile("^[A-Za-z0-9_]{3,15}$");
        
        Matcher match =validacion.matcher(nombre);
        if (match.matches()) {
            Jugar();
        }
        return "El nombre no es valido";
        
    }

}
