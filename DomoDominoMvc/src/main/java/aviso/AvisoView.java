package aviso;

import mediador.IComponente;
import mediador.IMediador;
import observers.IEventoAviso;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class AvisoView extends javax.swing.JFrame implements IComponente{

    private final AvisoModel avisoModel;
    private IObserver eventoCerrarPantalla;
    private IMediador mediador;

    public AvisoView(AvisoModel avisoModel) {
        this.avisoModel = avisoModel;
        this.avisoModel.agregarEventoAviso(new AccionMostrarAviso());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAviso = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAviso.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtAviso.setForeground(new java.awt.Color(220, 179, 88));
        txtAviso.setText("s");
        jPanel1.add(txtAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 480, 70));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aceptar.png"))); // NOI18N
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setFocusable(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 90, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoAviso.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        notificarEventoCerrarPantalla();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public void mostrarAviso(String mensaje) {

        this.txtAviso.setText(mensaje);

    }

    public void agregarEventoCerrarPantalla(IObserver eventoCerrarPantalla) {
        this.eventoCerrarPantalla = eventoCerrarPantalla;
    }

    public void notificarEventoCerrarPantalla() {
        if (eventoCerrarPantalla != null) {

            eventoCerrarPantalla.actualizar();

        }
    }
    
    private class AccionMostrarAviso implements IEventoAviso {

        @Override
        public void notificarAlUsuario(String mensaje) {
            mostrarAviso(mensaje);
        }

    }
    @Override
    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtAviso;
    // End of variables declaration//GEN-END:variables
}
