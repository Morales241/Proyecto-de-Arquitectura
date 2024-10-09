package iniciarSesion;

import DAOs.UsuarioDAO;
import dtos.UsuarioDto;
import java.awt.event.ActionEvent;
import loginMvc.LoginModel;
import mediador.Mediador;
import observers.IObserverUsuarioDto;

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
        
        loginModel.agregarIObserverUsuarioDtoIniciarSesion(new AccionIniciarSesion());
        loginModel.agregarIObserverUsuarioDtoRegistro(new  ActionRegistrarse());
        
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
    
    private class AccionIniciarSesion implements IObserverUsuarioDto{

        @Override
        public void actualizar(UsuarioDto usuarioDto) {
            if(iniciarSesion(usuarioDto)){
                loginModel.notificarObservadores("Se incio secion de manera satisfactoria");
                cambiarPantallaInicio();
            }else{
                loginModel.notificarObservadores("Error: el usuario o la contraseña es incorrecta");
            }
        }
    }
    
    private class ActionRegistrarse implements IObserverUsuarioDto{
        @Override
        public void actualizar(UsuarioDto usuarioDto) {
            cambiarPantallaRegistrio();
        }
    
    }
    
}
