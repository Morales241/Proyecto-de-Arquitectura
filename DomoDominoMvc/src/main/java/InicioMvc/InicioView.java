package InicioMvc;

import javax.swing.JOptionPane;
import mediador.IComponente;
import mediador.IMediador;
import observers.IEventoJugar;
import observers.IEventoValidacionDeNombre;

/**
 * Vista de inicio
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class InicioView extends javax.swing.JFrame implements IComponente {

    private final InicioModel inicioModel;
    private IMediador mediador;
    private IEventoJugar listenerJugar;

    /**
     * Creates new form InicioView
     *
     * @param inicioModel
     */
    public InicioView(InicioModel inicioModel) {
        initComponents();
        this.inicioModel = inicioModel;
        this.inicioModel.agregarIEventoValidacionDeNombre(new EventoModelo());

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnJugar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jugar - copia.png"))); // NOI18N
        btnJugar.setBorderPainted(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setFocusPainted(false);
        btnJugar.setFocusable(false);
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        jPanel1.add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 260, 40));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Javanese Text", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 310, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domodomino.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        ejecutarAccionJugar(this.txtNombre.getText());
    }//GEN-LAST:event_btnJugarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void agregarIEventoJugar(IEventoJugar listener) {
        this.listenerJugar = listener;
    }

    public void ejecutarAccionJugar(String nombre) {
        if (listenerJugar != null) {
            listenerJugar.validarNombreParaJugar(nombre);
        }
    }

    @Override
    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }

    public void avisoAlJugadorDeNombreVacio(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private class EventoModelo implements IEventoValidacionDeNombre {

        @Override
        public void validacionDeNombre(String mensajeDeValidacion) {
            avisoAlJugadorDeNombreVacio(mensajeDeValidacion);
        }
    }
}
