package iniciarSesion;

import DAOs.UsuarioDAO;
import dtos.UsuarioDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import loginMvc.LoginModel;

public class LogicaIniciarSesion implements ILogicaIniciarSesion {
    
    
    private final UsuarioDAO usuarioDao;
    private final LoginModel loginModel;

    /**
     * Constructor de la clase
     * @param loginModel
     */
    public LogicaIniciarSesion(LoginModel loginModel) {
        this.usuarioDao = new UsuarioDAO();
        this.loginModel = loginModel;
        loginModel.agregarActionListenerIniciarSesion(new AccionIniciarSesion());
        loginModel.agregarActionListenerRegistro(new  ActionRegistrarse());
        
    }

    @Override
    public boolean iniciarSesion(UsuarioDto usuario) {
        return usuarioDao.iniciarSesion(usuario.getCorreo(), usuario.getContraseña());  
    }
    
    public void cambiarPantallaRegistrio(){
        System.out.println("se cambio a la otra pantalla");
    }
    
    private class AccionIniciarSesion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UsuarioDto usuario = loginModel.encapsulamiento();
            
            if(iniciarSesion(usuario)){
                loginModel.notificarObservadores("Se incio secion de manera satisfactoria");
            }else{
                loginModel.notificarObservadores("Error: el usuario o la contraseña es incorrecta");
            }
        }
        
    }
    
    private class ActionRegistrarse implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cambiarPantallaRegistrio();
        }
    
    }
    
}
