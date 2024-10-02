package signInMvc;

import observers.IObserver;

public class SignInControler implements IObserver{

    private SignInView signInView;
    private SignInModel signInModel;

    public SignInControler(SignInView signInView, SignInModel signInModel) {
        this.signInView = signInView;
        this.signInModel = signInModel;
        
        signInView.agregarObservador(this);
    }
 
    @Override
    public void actualizar() {
        signInModel.registrarse();
    }
    
}
