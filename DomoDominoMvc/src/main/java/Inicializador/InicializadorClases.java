package Inicializador;

import InicioMvc.InicioController;
import InicioMvc.InicioModel;
import InicioMvc.InicioView;
import TableroMvc.TableroController;
import TableroMvc.TableroModel;
import TableroMvc.TableroView;
import contenedor.ContenedorMvc;
import loginMvc.LoginController;
import loginMvc.LoginModel;
import loginMvc.LoginView;
import mediador.Mediador;
import signInMvc.SignInController;
import signInMvc.SignInModel;
import signInMvc.SignInView;

/**
 * Clase que Inicializa todas las clases Mvc y clase mediador.
 * Encapsula los MVC y los pone en el mediador
 * 
 * 
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class InicializadorClases {
    
    /**
     * Inicializar clases MVC
     */
    public void InicializarClases(Mediador mediador){
    LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView(loginModel);
        loginView.setMediador(mediador);
        LoginController loginController = new LoginController(loginModel, loginView);
        ContenedorMvc<LoginModel, LoginView, LoginController> loginContenedor = new ContenedorMvc<>(loginModel, loginView, loginController);
        
        SignInModel signInModel = new SignInModel();
        SignInView signInView = new SignInView(signInModel);
        signInView.setMediador(mediador);
        SignInController signInController = new SignInController(signInView, signInModel);
        ContenedorMvc<SignInModel, SignInView, SignInController> signInContenedor = new ContenedorMvc<>(signInModel,signInView,signInController);
        
        InicioModel inicioModel = new InicioModel();
        InicioView inicioView = new InicioView(inicioModel);
        inicioView.setMediador(mediador);
        InicioController inicioController = new InicioController(inicioModel, inicioView);
        ContenedorMvc<InicioModel, InicioView, InicioController> inicioContenedor = new ContenedorMvc<>(inicioModel,inicioView,inicioController);
        
        TableroModel tableroModel = new TableroModel();
        TableroView tableroView = new TableroView(tableroModel);
        tableroView.setMediador(mediador);
        TableroController tableroController = new TableroController(tableroModel, tableroView);
        ContenedorMvc<TableroModel, TableroView, TableroController> tableroContenedor = new ContenedorMvc<>(tableroModel,tableroView,tableroController);
        
        //si se crean mas pantallas ponganlas aqui arriba y registrenlas abajo
        
        mediador.registrarPantalla("login", loginContenedor);
        mediador.registrarPantalla("signIn", signInContenedor);
        mediador.registrarPantalla("inicio", inicioContenedor);
        mediador.registrarPantalla("tablero", tableroContenedor);
    }
}
