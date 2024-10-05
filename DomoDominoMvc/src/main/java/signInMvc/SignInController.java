package signInMvc;

import observers.IObserver;

public class SignInController implements IObserver{

    private SignInView signInView;
    private SignInModel signInModel;

    public SignInController(SignInView signInView, SignInModel signInModel) {
        this.signInView = signInView;
        this.signInModel = signInModel;
        
        signInView.agregarObservador(this);
    }
 
    @Override
    public void actualizar(String estado) {
        signInModel.registrarse();
    }
    
}
