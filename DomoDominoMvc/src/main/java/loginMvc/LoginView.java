package loginMvc;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mediador.IComponente;
import mediador.Mediador;
import observers.IObserver;

public class LoginView extends javax.swing.JFrame implements IComponente, IObserver{

    private final LoginModel loginModel;
    private Mediador mediador;
    
    public LoginView(LoginModel loginModel) {
        initComponents();
        this.loginModel = loginModel;
        this.loginModel.agregarObservador(this);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreLbl = new javax.swing.JLabel();
        nombreLbl1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreLbl.setForeground(new java.awt.Color(245, 209, 174));
        nombreLbl.setText("Contraseña");
        jPanel1.add(nombreLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        nombreLbl1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreLbl1.setForeground(new java.awt.Color(248, 230, 195));
        nombreLbl1.setText("Correo");
        jPanel1.add(nombreLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Registrar.png"))); // NOI18N
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setFocusable(false);
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 260, 50));

        txtCorreo.setBackground(new java.awt.Color(244, 244, 244));
        txtCorreo.setToolTipText("");
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 190, -1));

        txtContra.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 190, -1));

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iniciarsesion.png"))); // NOI18N
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.setFocusable(false);
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 260, 40));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domodomino.png"))); // NOI18N
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void btnInciarSecion(ActionListener actionListener){
        btnIniciarSesion.addActionListener(actionListener);
    }   
    
    public void btnRegistrarse(ActionListener actionListener){
        btnRegistrar.addActionListener(actionListener);
    } 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JLabel nombreLbl1;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    @Override
    public void actualizar(String estado) {
        JOptionPane.showMessageDialog(null, estado);
    }

    public String getUsuario(){
        return txtCorreo.getText() + "%" + txtContra.getText();
    } 
}
