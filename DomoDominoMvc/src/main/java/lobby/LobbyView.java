package lobby;

import dtos.JugadorDto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import mediador.IComponente;
import mediador.IMediador;
import observers.IObserver;

/**
 * Vista del lobby
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class LobbyView extends javax.swing.JFrame implements IComponente{
    
    private final LobbyModel lobbyModel;
    private IMediador mediador;
    private IObserver observerIniciarPartida;
    private List<JLabel> etiquetasJugadores;
    
    public LobbyView(LobbyModel lobbyModel) {
        initComponents();
        this.lobbyModel = lobbyModel;
        
        etiquetasJugadores = new ArrayList<>();
        etiquetasJugadores.add(nomJugador1);
        etiquetasJugadores.add(nomJugador2);
        etiquetasJugadores.add(nomJugador3);
        etiquetasJugadores.add(nomJugador4);
        
        agregarIEventoIniciarPartida(new IniciarPartida());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nomJugador1 = new javax.swing.JLabel();
        nomJugador2 = new javax.swing.JLabel();
        nomJugador3 = new javax.swing.JLabel();
        nomJugador4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 50, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regresar.png"))); // NOI18N
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setFocusPainted(false);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jugar.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, -1, -1));

        nomJugador1.setText("jLabel2");
        jPanel1.add(nomJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        nomJugador2.setText("jLabel3");
        jPanel1.add(nomJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        nomJugador3.setText("jLabel4");
        jPanel1.add(nomJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));

        nomJugador4.setText("jLabel5");
        jPanel1.add(nomJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FondoGeneral.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomJugador1;
    private javax.swing.JLabel nomJugador2;
    private javax.swing.JLabel nomJugador3;
    private javax.swing.JLabel nomJugador4;
    // End of variables declaration//GEN-END:variables
    
      public void mostrarJugadores(List<JugadorDto> jugadores) {
        for (int i = 0; i < jugadores.size() && i < etiquetasJugadores.size(); i++) {
            etiquetasJugadores.get(i).setText(jugadores.get(i).getNombre());
        }
    }

    public void agregarIEventoIniciarPartida(IObserver listener) {
        this.observerIniciarPartida = listener;
    }

    @Override
    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }

    private void ejecutarIniciarPartida() {
        if (observerIniciarPartida != null) {
            observerIniciarPartida.actualizar();
        }
    }

    private class IniciarPartida implements IObserver {
        @Override
        public void actualizar() {
            ejecutarIniciarPartida();
        }
    }
}
