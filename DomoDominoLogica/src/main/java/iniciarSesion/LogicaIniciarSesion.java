package iniciarSesion;

import DAOs.UsuarioDAO;
import dtos.UsuarioDto;
import fachadas.ILoginFachada;
import mediador.Mediador;
import observers.IObserverUsuarioDto;

public class LogicaIniciarSesion implements ILogicaIniciarSesion {
    
    
    private final UsuarioDAO usuarioDao;
    private final ILoginFachada loginFachada;
    private final Mediador mediador;

    /**
     * Constructor de la clase
     * @param loginFachada
     */
    public LogicaIniciarSesion(ILoginFachada loginFachada) {
        this.usuarioDao = new UsuarioDAO();
        this.loginFachada = loginFachada;
        this.mediador = Mediador.getInstancia();
        
        loginFachada.agregarObserverIniciarSesion(new AccionIniciarSesion());
        loginFachada.agregarObserverRegistro(new ActionRegistrarse());
    }

    @Override
    public boolean iniciarSesion(UsuarioDto usuario) {
        return usuarioDao.iniciarSesion(usuario.getCorreo(), usuario.getContraseña());  
    }

    public void cambiarPantallaRegistro(){
        mediador.mostrarPantallaConcreta("signIn");
    }

    public void cambiarPantallaInicio(){
        mediador.mostrarPantallaConcreta("inicio");
    }

    private class AccionIniciarSesion implements IObserverUsuarioDto {

        @Override
        public void actualizar(UsuarioDto usuarioDto) {
            if (iniciarSesion(usuarioDto)) {
                loginFachada.notificarObservadores("Se inició sesión de manera satisfactoria");
                cambiarPantallaInicio();
            } else {
                loginFachada.notificarObservadores("Error: el usuario o la contraseña es incorrecta");
            }
        }
    }

    private class ActionRegistrarse implements IObserverUsuarioDto {
        @Override
        public void actualizar(UsuarioDto usuarioDto) {
            cambiarPantallaRegistro();
        }
    }
    
}
