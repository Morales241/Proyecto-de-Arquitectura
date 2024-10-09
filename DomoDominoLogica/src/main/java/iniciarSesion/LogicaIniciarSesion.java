package iniciarSesion;

import DAOs.UsuarioDAO;
import InicioMvc.InicioModel;
import dtos.UsuarioDto;
import loginMvc.LoginModel;
import mediador.Mediador;
import observers.IObserverUsuarioDto;

public class LogicaIniciarSesion implements ILogicaIniciarSesion {
    
    
    private final UsuarioDAO usuarioDao;
    private final LoginModel loginModel;
    private final Mediador mediador;

    /**
     * Constructor de la clase
     */
    public LogicaIniciarSesion() {
        this.usuarioDao = new UsuarioDAO();
        this.mediador = Mediador.getInstancia();
        
        this.loginModel =  (LoginModel) mediador.obtenerPantallaConcreta("login").getModelo();
        
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
