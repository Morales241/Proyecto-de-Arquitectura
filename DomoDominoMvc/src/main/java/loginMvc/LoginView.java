package loginMvc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import observers.IObservable;
import observers.IObserver;

public class LoginView extends javax.swing.JFrame implements IObserver, IObservable{

    private LoginModel domoDominoModel;
    private List<IObserver> observadores = new ArrayList<>();
    
    public LoginView(LoginModel domoDominoModel) {
        initComponents();
        this.domoDominoModel = domoDominoModel;
        domoDominoModel.agregarObservador(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(244, 244, 244));
        txtNombre.setToolTipText("");
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 190, -1));

        txtContra.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 190, -1));

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\tacot\\OneDrive\\Documentos\\GitHub\\Proyecto-de-Arquitectura\\DomoDominoMvc\\src\\main\\resources\\iniciarsesion.png")); // NOI18N
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 260, 40));

        labelFondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\tacot\\OneDrive\\Documentos\\GitHub\\Proyecto-de-Arquitectura\\DomoDominoMvc\\src\\main\\resources\\domodomino.png")); // NOI18N
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

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        domoDominoModel.setContra(txtContra.getText());
        domoDominoModel.setNombre(txtNombre.getText());
        
        notificarObservadores();
        
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    /**
     * Metodo que agrega un actionListener al boton, sin tener que pasarle el 
     * boton a la clase control.
     * @param actionListener 
     */
    public void agregarListener(ActionListener actionListener){
        btnIniciarSesion.addActionListener(actionListener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar() {
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

    
}
