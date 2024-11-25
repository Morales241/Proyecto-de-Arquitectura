package eventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class EventoAcabarPartidaDto implements Serializable{
    
    private String codigo;

    public EventoAcabarPartidaDto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
