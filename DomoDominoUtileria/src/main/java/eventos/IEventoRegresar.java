package eventos;

/**
 * Aviso de navegacion hacia atras (boton regresar).
 * Sin datos: el destino ya lo sabe quien escucha.
 */
public interface IEventoRegresar {

    public void regresar();

}
