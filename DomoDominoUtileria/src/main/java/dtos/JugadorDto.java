package dtos;

import eventos.JugadorBase;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author favel
 */

public class JugadorDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombre;
    private int avatar;
    private List<FichaDto> fichas;

    public JugadorDto(String nombre, int avatar, List<FichaDto> fichas) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.fichas = fichas;
    }

    public JugadorDto(String nombre) {
        this.nombre = nombre;
    }
   
    public String getNombre() {
        return nombre;
    }

    public int getAvatar() {
        return avatar;
    }

    public List<FichaDto> getFichas() {
        return fichas;
    }
}
