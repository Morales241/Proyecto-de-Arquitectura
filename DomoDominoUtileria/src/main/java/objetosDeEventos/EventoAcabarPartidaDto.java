package objetosDeEventos;

import java.io.Serializable;

/**
 *
 * @author tacot
 */
public class EventoAcabarPartidaDto implements Serializable{
    private static final long serialVersionUID = 1L;
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
