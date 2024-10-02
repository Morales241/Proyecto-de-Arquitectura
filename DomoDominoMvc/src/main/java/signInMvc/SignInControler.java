package signInMvc;

import comands.IComando;
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
    public void actualizar(IComando comando) {
        if (comando != null) {
            comando.ejecutarComando();
        }
    }
    
    public void registrar(){
        signInModel.registrarse();
    }
    
}
