package signInMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInController {

    private SignInView signInView;
    private SignInModel signInModel;

    public SignInController(SignInView signInView, SignInModel signInModel) {
        this.signInView = signInView;
        this.signInModel = signInModel;
        
        signInView.btnRegistrarse(new OyenteRegistrarCuenta());
    }
 
    public void registrarCuenta(){
        signInModel.ejecutarAccionRegistro();
    }
    
    private class OyenteRegistrarCuenta implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String[] Usuario = signInView.getUsuario().split("%");
            
            signInModel.setNombre(Usuario[0]);
            
            signInModel.setCorreo(Usuario[1]);

            signInModel.setContra(Usuario[2]);
            
            registrarCuenta();
            
        }
    
    }
    
}
