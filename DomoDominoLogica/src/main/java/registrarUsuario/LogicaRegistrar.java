/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarUsuario;

import DAOs.UsuarioDAO;
import com.mycompany.domodominopersistencia.Usuario;

/**
 *
 * @author tacot
 */
public class LogicaRegistrar implements ILogicaRegistrar {

    private final UsuarioDAO usuarioDAO;

    /**
     * Constructor de la clase
     */
    public LogicaRegistrar() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    /**
     * Metodo para registrar usuarios
     * @param usuario
     * @return verdadero o falso para confirmar el registro
     */
    @Override
    public boolean registrarUsuario(UsuarioDto usuario) {
        if (validarNombre(usuario.getNombre()) &&
            validarCorreo(usuario.getCorreo()) &&
            validarContraseña(usuario.getContraseña())) {
            
            Usuario nuevoUsuario = new Usuario(usuario.getNombre(), usuario.getCorreo(), usuario.getContraseña());
         
            usuarioDAO.registrar(nuevoUsuario);
            
            return true; 
        }
        return false; 
    }

    /**
     * Valida que nombre: 
     * - No contiene espacios. 
     * - Solo contiene letras y números. 
     * - No pasa de 20 caracteres.
     *
     * @param nombre El nombre a validar.
     * @return true si el nombre es válido, false en caso contrario.
     */
    @Override
    public boolean validarNombre(String nombre) {
        return nombre.matches("^[a-zA-Z0-9]{1,20}$");
    }

    /**
     * Valida que correo tenga: 
     * - Al menos un carácter antes del símbolo '@'. 
     * - Al menos un carácter después del símbolo '@'. 
     * - Un punto. 
     * - Al menos un carácter después del punto.
     *
     * @param correo El correo a validar.
     * @return true si el correo es válido, false en caso contrario.
     */
    @Override
    public boolean validarCorreo(String correo) {
        return correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    /**
     * Valida si la contraseña cumple con los siguientes criterios: 
     * - Solo contiene letras y números. 
     * - Tiene una longitud de entre 1 y 20 caracteres.
     *
     * @param contraseña La contraseña a validar.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    @Override
    public boolean validarContraseña(String contraseña) {
        return contraseña.matches("^[a-zA-Z0-9]{1,20}$");
    }


}
