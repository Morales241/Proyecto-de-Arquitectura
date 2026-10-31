package eventos;

/**
 * Aviso de que el avatar seleccionado cambio.
 * La vista lee la ruta actual del modelo, por eso no lleva datos.
 */
public interface IEventoAvatarSeleccionado {

    public void avatarSeleccionado();

}
