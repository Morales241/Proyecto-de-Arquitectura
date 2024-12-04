package dtos;

import eventos.JugadorBase;
import java.util.List;

/**
 *
 * @author favel
 */

public class JugadorDto {
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
