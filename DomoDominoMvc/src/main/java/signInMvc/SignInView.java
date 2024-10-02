package signInMvc;

import java.util.ArrayList;
import java.util.List;
import mediador.IComponente;
import mediador.Mediador;
import observers.IObservable;
import observers.IObserver;
import registrarUsuario.LogicaRegistrar;

public class SignInView extends javax.swing.JFrame implements IObserver, IObservable, IComponente {
    
    private SignInModel signInModel;
    private List<IObserver> observadores = new ArrayList<>();
    private Mediador mediador;
  
    /**
     * Creates new form signInView
     */
    public SignInView(SignInModel signInModel) {
        initComponents();
        this.signInModel = signInModel;
        signInModel.agregarObservador(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        nombreLbl2 = new javax.swing.JLabel();
        nombreLbl1 = new javax.swing.JLabel();
        nombreLbl = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 220, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 150, -1));
        getContentPane().add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 150, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Registrar.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 190, 50));

        nombreLbl2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreLbl2.setForeground(new java.awt.Color(245, 209, 174));
        nombreLbl2.setText("Correo");
        getContentPane().add(nombreLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        nombreLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreLbl1.setForeground(new java.awt.Color(248, 230, 195));
        nombreLbl1.setText("Nombre");
        getContentPane().add(nombreLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        nombreLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreLbl.setForeground(new java.awt.Color(245, 209, 174));
        nombreLbl.setText("Contraseña");
        getContentPane().add(nombreLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domodomino.png"))); // NOI18N
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        signInModel.setNombre(txtCorreo.getText());
        signInModel.setContra(txtContra.getText());
        
        notificarObservadores();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JLabel nombreLbl1;
    private javax.swing.JLabel nombreLbl2;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar() {
        if(signInModel.registrarse())
        mediador.mostrarViewConcreta("LoginView");
    }

    @Override
    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        observadores.forEach(IObserver -> {
            IObserver.actualizar();
        });
    }

    @Override
    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

}
