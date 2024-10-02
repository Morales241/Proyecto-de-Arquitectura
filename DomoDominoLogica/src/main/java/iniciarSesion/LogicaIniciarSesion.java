package iniciarSesion;

import DAOs.UsuarioDAO;
import dtos.UsuarioDto;

public class LogicaIniciarSesion implements ILogicaIniciarSesion {
    
    
    private final UsuarioDAO usuarioDao;

    /**
     * Constructor de la clase
     */
    public LogicaIniciarSesion() {
        this.usuarioDao = new UsuarioDAO();
    }

    @Override
    public boolean iniciarSesion(UsuarioDto usuario) {
        return usuarioDao.iniciarSesion(usuario.getCorreo(), usuario.getContraseña());  
    }
    
    
}
