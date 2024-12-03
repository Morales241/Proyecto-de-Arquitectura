package eventos;

/**
 *
 * @author tacot
 */
public class RespuestaDeUnirseAPartida extends RespuestaServidorCentral{
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int avatar;
    
    public RespuestaDeUnirseAPartida() {
    }

    public RespuestaDeUnirseAPartida(String nombre, int avatar, String respuesta, Boolean key) {
        super(respuesta, key);
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public RespuestaDeUnirseAPartida(String nombre, int avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }
}
