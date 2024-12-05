package observers;

import dtos.FichaDto;
import java.util.List;

/**
 *
 * @author tacot
 */
public interface IEventoValidarFichas {
    public void validarFichas(List<FichaDto> fichas);
}
