package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LoginModel;
import view.LoginView;

public class LoginControler implements ActionListener{
    
    private LoginModel domoDominoModel;
    private LoginView domoDominoView;

    public LoginControler(LoginModel domoDominoModel, LoginView domoDominoView) {
        this.domoDominoModel = domoDominoModel;
        this.domoDominoView = domoDominoView;
        
        //Esto sigue estando mal, hay que buscar como hacer una "instancia de ActionListenen En linea"
        //o algo asi dijo el profe, recuerdo que dijo que se llamaba en linea.
        
        //Las demas correcciones a lo que yo se ya se aplicaron, es esto y el de abajo checarlo, no recuerdo
        //que dijo gibran sobre ese metodo, suerte plebes ahi ahorita me meto al discordo :D
        ActionListener actionListener = new ActionListener();
        domoDominoView.agregarListener(actionListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Iniciando Sesion.... (mentira nomas imprimi esto)");
        System.out.println(domoDominoModel.getNombre());
        System.out.println(domoDominoModel.getContra());
    }
    
}
