package registrarUsuario;

import dtos.UsuarioDto;

/**
 *
 * @author tacot
 */
public interface ILogicaRegistrar {
    
    public boolean registrarUsuario(UsuarioDto usuario);
    
    public boolean validarNombre(String nombre);
    
    public boolean validarCorreo(String correo);
    
    public boolean validarContraseña(String contraseña);
}
