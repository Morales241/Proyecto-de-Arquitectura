package loginMvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private final LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModell, LoginView loginView) {
        this.loginModel = loginModell;
        this.loginView = loginView;

        loginView.btnInciarSecion(new OyenteIniciarSesion());

        loginView.btnRegistrarse(new OyenteRegistrarse());

    }

    public void iniciarSesion() {

        loginModel.ejecutarAccionIniciarSesion();
    }

    public void registrarCuenta() {
        loginModel.ejecutarAccionRegistro();
    }

    private class OyenteIniciarSesion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String[] Usuario = loginView.getUsuario().split("%");

            loginModel.setCorreo(Usuario[0]);

            loginModel.setContra(Usuario[1]);

            iniciarSesion();
        }

    }

    private class OyenteRegistrarse implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            registrarCuenta();
        }

    }
}
