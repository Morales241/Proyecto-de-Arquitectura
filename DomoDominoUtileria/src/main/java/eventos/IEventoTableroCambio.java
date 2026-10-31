package eventos;

/**
 * Aviso de que el estado del tablero cambio y hay que repintar.
 * La vista relee el modelo, por eso no lleva datos.
 */
public interface IEventoTableroCambio {

    public void tableroCambio();

}
