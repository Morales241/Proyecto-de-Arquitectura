package main;

import Arreglo.LogicaArreglo;
import Pozo.ILogicaPozo;
import Pozo.LogicaPozo;
import TableroMvc.TableroController;
import TableroMvc.TableroModel;
import TableroMvc.TableroView;
import dtos.ArregloDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.JugadorBase;
import eventos.PonerFichaDto;
import fachadas.ArregloFachada;
import fachadas.TableroFachada;
import fachadasInterfaz.ITableroFachada;
import java.util.ArrayList;
import java.util.List;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import tablero.LogicaTablero;

/**
 *
 * @author tacot
 */
public class prueba {

     private static ArregloFachada fachada = new ArregloFachada();
     private static ITableroFachada tifachada;

     private final ILogicaPozo IPozo = new LogicaPozo();

     private static LogicaArreglo arreglo = new LogicaArreglo(fachada);
     private static LogicaPozo pozo = new LogicaPozo();
     private static LogicaTablero tablero = new LogicaTablero(tifachada);

     private static TableroModel model = new TableroModel();

     private static TableroFachada tfachada = new TableroFachada(model);

     private static TableroView view = new TableroView(model);
     private static TableroController controller = new TableroController(model, view);

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {

          
          
          model.agregarObserverPonerFicha(new accionArreglo());
          model.agregarObserverTomarFichaDelPozo(new accionPozo());

          view.setVisible(true);

          ArregloDto array = arreglo.convertirEntidad(arreglo.obtenerArreglo());

          List<FichaDto> fichas = new ArrayList<>();
          fichas.add(new FichaDto(2, 2));
//        fichas.add(new FichaDto(2, 3));
//        fichas.add(new FichaDto(2, 4));
          fichas.add(new FichaDto(3, 5));
//        fichas.add(new FichaDto(4, 6));

          JugadorDto jugadorDto = new JugadorDto("jesus", 3, fichas);

          List<JugadorBase> jugadorBases = new ArrayList<>();

          jugadorBases.add(new JugadorBase("Victor", 2));
          jugadorBases.add(new JugadorBase("Alfredo", 1));
          jugadorBases.add(new JugadorBase("Mariana", 3));

          model.iniciarPartida(jugadorDto, array, jugadorBases, true);
     }

     private static class accionArreglo implements IEventoPonerFicha {

          @Override
          public void ponerFicha(PonerFichaDto ponerFicha) {

               boolean llave = arreglo.colocarFicha(ponerFicha.getFicha(), ponerFicha.getExtremo(), ponerFicha.getDireccion());
               if (llave) {

                    ArregloDto ad = arreglo.convertirEntidad(arreglo.obtenerArreglo());
                    JugadorDto jugadorDto = ponerFicha.getJugador();
                    jugadorDto.getFichas().remove(ponerFicha.getFicha());
                    model.setArray(ad);
                    model.setJugador(jugadorDto);
               }
          }
     }

     public static class accionPozo implements IEventoPedirFichaAlPozo {

          @Override
          public void pedirFicha() {
//               FichaDto fichaSacada = IPozo.sacarFicha();
//               logicaTablero.enviarFichaDelPozo(fichaSacada);
          }
     }
}
