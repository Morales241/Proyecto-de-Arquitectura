package iniciarSesion;

import DAOs.UsuarioDAO;
import dtos.UsuarioDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import loginMvc.LoginModel;
import mediador.Mediador;

public class LogicaIniciarSesion implements ILogicaIniciarSesion {
    
    
    private final UsuarioDAO usuarioDao;
    private final LoginModel loginModel;
    private final Mediador mediador;

    /**
     * Constructor de la clase
     * @param loginModel
     */
    public LogicaIniciarSesion(LoginModel loginModel) {
        this.usuarioDao = new UsuarioDAO();
        this.loginModel = loginModel;
        this.mediador = Mediador.getInstancia();
        
        loginModel.agregarActionListenerIniciarSesion(new AccionIniciarSesion());
        loginModel.agregarActionListenerRegistro(new  ActionRegistrarse());
        
    }

    @Override
    public boolean iniciarSesion(UsuarioDto usuario) {
        return usuarioDao.iniciarSesion(usuario.getCorreo(), usuario.getContraseña());  
    }
    
    public void cambiarPantallaRegistrio(){
        mediador.mostrarPantallaConcreta("signIn");
    }
    
    public void cambiarPantallaInicio(){
        mediador.mostrarPantallaConcreta("inicio");
        
    }
    
    private class AccionIniciarSesion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UsuarioDto usuario = loginModel.encapsulamiento();
            
            if(iniciarSesion(usuario)){
                loginModel.notificarObservadores("Se incio secion de manera satisfactoria");
                cambiarPantallaInicio();
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
