package Inicializador;

import Entidades.GestorTurnos;
import InicioMvc.InicioModel;
import TableroMvc.TableroModel;
import aviso.AvisoModel;
import crearPartida.CrearPartidaModel;
import fachadas.AvisoFachada;
import fachadas.CrearPartidaFachada;
import fachadas.GestorDeTurnosFachada;
import fachadasInterfaz.ICrearPartidaFachada;
import fachadasInterfaz.IInicioFachada;
import fachadasInterfaz.ITableroFachada;
import fachadasInterfaz.IUnirseAPartidaFachada;
import fachadas.InicializadorMVCFachada;
import fachadas.InicioFachada;
import fachadas.LobbyFachada;
import fachadas.TableroFachada;
import fachadas.UnirseAPartidaFachada;
import fachadasInterfaz.IGestorDeTurnosFachada;
import fachadasInterfaz.ILobbyFachada;
import lobby.LobbyModel;
import mediador.IMediador;
import mediador.Mediador;
import unirseAPartida.UnirseAPartidaModel;

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
    
    private final IMediador mediador;
    private final InicializadorMVCFachada cFachada;
    
    private IInicioFachada inicioFachada;
    
    private ICrearPartidaFachada crearPartidaFachada;
    
    private IUnirseAPartidaFachada unirsePartidaFachada;
    
    private ITableroFachada tableroFachada;
    
    private AvisoFachada avisoFachada;
    
    private ILobbyFachada lobbyFachada;
    
    private IGestorDeTurnosFachada turnosFachada;
     
    public InicializadorClases() {
        mediador = Mediador.getInstancia();
        cFachada = new InicializadorMVCFachada();
    }
    
    /**
     * Inicializar clases MVC
     */
    public void InicializarClases(){
        
        //inicializar pantallas mvc
        cFachada.inciializarMVC();
        
        //fachada inicio
        InicioModel inicioModel = (InicioModel) mediador.obtenerPantallaConcreta("inicio").getModelo();
          
        inicioFachada = new InicioFachada(inicioModel);

        //fachada crearPartida
        CrearPartidaModel crearPartidaModel = (CrearPartidaModel) mediador.obtenerPantallaConcreta("crearPartida").getModelo();
        crearPartidaFachada = new CrearPartidaFachada(crearPartidaModel);
        
        //fachada unirsePartida
        UnirseAPartidaModel unirseAPartidaModel = (UnirseAPartidaModel) mediador.obtenerPantallaConcreta("unirsePartida").getModelo();
        unirsePartidaFachada = new UnirseAPartidaFachada(unirseAPartidaModel);
        
        //fachada tablero
//        TableroModel tableroModel = (TableroModel) mediador.obtenerPantallaConcreta("tablero").getModelo();
//        tableroFachada = new TableroFachada(tableroModel);
        
        //fachada aviso
        AvisoModel avisoModel = (AvisoModel) mediador.obtenerPantallaConcreta("aviso").getModelo();
        avisoFachada = new AvisoFachada(avisoModel);
        
        //fachada lobby lobby
        LobbyModel lobbyModel = (LobbyModel) mediador.obtenerPantallaConcreta("lobby").getModelo();
        lobbyFachada = new LobbyFachada(lobbyModel);
        
        GestorTurnos gestorTurnos = new GestorTurnos();
        turnosFachada = new GestorDeTurnosFachada(gestorTurnos);
        
    }

    public IInicioFachada getInicioFachada() {
        return inicioFachada;
    }

    public IGestorDeTurnosFachada getTurnosFachada() {
        return turnosFachada;
    }

    public ICrearPartidaFachada getCrearPartidaFachada() {
        return crearPartidaFachada;
    }

    public IUnirseAPartidaFachada getUnirseAPartidaFachada() {
         return unirsePartidaFachada;
    }
    
    public ITableroFachada getTableroFachada() {
         return tableroFachada;
    }

    public AvisoFachada getAvisoFachada() {
        return avisoFachada;
    }

    public ILobbyFachada getLobbyFachada() {
        return lobbyFachada;
    }
   
}
