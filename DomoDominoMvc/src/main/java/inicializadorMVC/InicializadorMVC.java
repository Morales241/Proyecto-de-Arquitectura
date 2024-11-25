/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicializadorMVC;

import InicioMvc.InicioController;
import InicioMvc.InicioModel;
import InicioMvc.InicioView;
import TableroMvc.TableroController;
import TableroMvc.TableroModel;
import TableroMvc.TableroView;
import contenedor.ContenedorMvc;
import crearPartida.CrearPartidaController;
import crearPartida.CrearPartidaModel;
import crearPartida.CrearPartidaView;
import mediador.IMediador;
import mediador.Mediador;
import unirseAPartida.UnirseAPartidaController;
import unirseAPartida.UnirseAPartidaModel;
import unirseAPartida.UnirseAPartidaView;

/**
 *
 * @author tacot
 */
public class InicializadorMVC {

    public InicializadorMVC() {
    }
    
    public void inicializarClases(){
        
        //MVC Inicio
        IMediador mediador = Mediador.getInstancia();
        
        InicioModel inicioModel = new InicioModel();
        InicioView inicioView = new InicioView(inicioModel);
        inicioView.setMediador(mediador);
        InicioController inicioController = new InicioController(inicioModel, inicioView);
        ContenedorMvc<InicioModel, InicioView, InicioController> inicioContenedor = new ContenedorMvc<>(inicioModel,inicioView,inicioController);
        mediador.registrarPantalla("inicio", inicioContenedor);
        
        //MVC crear partida
        CrearPartidaModel crearMesaModel = new CrearPartidaModel();
        CrearPartidaView crearMesaView = new CrearPartidaView(crearMesaModel);
        crearMesaView.setMediador(mediador);
        CrearPartidaController crearMesaController = new CrearPartidaController(crearMesaModel, crearMesaView);
        ContenedorMvc<CrearPartidaModel, CrearPartidaView, CrearPartidaController> crearPartidaContenedor = new ContenedorMvc<>(crearMesaModel, crearMesaView, crearMesaController);
        mediador.registrarPantalla("crearPartida", crearPartidaContenedor);
        
        //MVC unirse partida
        UnirseAPartidaModel unirseAPartidaModel = new UnirseAPartidaModel();
        UnirseAPartidaView unirseAPartidaView = new UnirseAPartidaView(unirseAPartidaModel);
        unirseAPartidaView.setMediador(mediador);
        UnirseAPartidaController unirseAPartidaController = new UnirseAPartidaController(unirseAPartidaModel, unirseAPartidaView);
        ContenedorMvc<UnirseAPartidaModel, UnirseAPartidaView, UnirseAPartidaController> unirseAPartidaContenedor = new ContenedorMvc<>(unirseAPartidaModel, unirseAPartidaView, unirseAPartidaController);
        mediador.registrarPantalla("unirsePartida", unirseAPartidaContenedor);
        
        //MVC Tablero
        TableroModel tableroModel = new TableroModel();
        TableroView tableroView = new TableroView(tableroModel);
        tableroView.setMediador(mediador);
        TableroController tableroController = new TableroController(tableroModel, tableroView);
        ContenedorMvc<TableroModel, TableroView, TableroController> tableroContenedor = new ContenedorMvc<>(tableroModel, tableroView, tableroController);
        mediador.registrarPantalla("tablero", tableroContenedor);
    }
    
}
