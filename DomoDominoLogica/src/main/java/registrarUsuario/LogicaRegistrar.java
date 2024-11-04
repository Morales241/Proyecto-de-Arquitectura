package registrarUsuario;

import dtos.UsuarioDto;
import DAOs.UsuarioDAO;
//import com.mycompany.domodominopersistencia.Usuario;
import Entidades.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mediador.IMediador;
import mediador.Mediador;
import signInMvc.SignInModel;

public class LogicaRegistrar implements ILogicaRegistrar {
    
    private final UsuarioDAO usuarioDAO;
    private final SignInModel signInModel;
    private final IMediador mediador;

    /**
     * 
     * Constructor de la clase
     */
    public LogicaRegistrar() {
        this.usuarioDAO = new UsuarioDAO();
        this.mediador = Mediador.getInstancia();
        this.signInModel = (SignInModel) mediador.obtenerPantallaConcreta("signIn").getModelo();
        
        signInModel.agregarActionListenerRegistro(new AccionRegistrarUsuario());
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
         
//            usuarioDAO.registrar(nuevoUsuario);
            
            return true; 
        }
        return false; 
    }
    
    public void cambiarPantallaInicio(){
        mediador.mostrarPantallaConcreta("login");
    }
    
    private class AccionRegistrarUsuario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UsuarioDto usuario = signInModel.encapsulamiento();
            
            if(registrarUsuario(usuario)){
                signInModel.notificarObservadores("El usuario se registro de manera satisfactoria");
                cambiarPantallaInicio();
            }else{
                signInModel.notificarObservadores("Error: el usuario no se pudo registrar");
            }
        }
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
