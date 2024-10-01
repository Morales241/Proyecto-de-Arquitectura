package loginMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControler{
    
    private LoginModel domoDominoModel;
    private LoginView domoDominoView;

    public LoginControler(LoginModel domoDominoModel, LoginView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;
        
        //Esto sigue estando mal, hay que buscar como hacer una "instancia de ActionListenen En linea"
        //o algo asi dijo el profe, recuerdo que dijo que se llamaba en linea.
        
        //Las demas correcciones a lo que yo se ya se aplicaron, es esto y el de abajo checarlo, no recuerdo
        //que dijo gibran sobre ese metodo, suerte plebes ahi ahorita me meto al discordo :D
        domoDominoView.agregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Iniciando Sesion.... (mentira nomas imprimi esto)");
                System.out.println(domoDominoModel.getNombre());
                System.out.println(domoDominoModel.getContra());
            }
        });
    }   
}
