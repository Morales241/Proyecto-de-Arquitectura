package lobby;

import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.VotoDeJugador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import mediador.IComponente;
import mediador.IMediador;
import observers.IObserver;
import observersLogicaAServidorCentral.IEventoSalirDeLobby;
import observersLogicaAServidorCentral.IEventoVotarParaIniciarPartida;

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
    private IEventoSalirDeLobby observerRegresar;
    private IEventoVotarParaIniciarPartida observerVotar;
    private List<JLabel> etiquetasJugadores;
    
    public LobbyView(LobbyModel lobbyModel) {
        initComponents();
        this.lobbyModel = lobbyModel;
        
        etiquetasJugadores = new ArrayList<>();
        etiquetasJugadores.add(nomJugador1);
        etiquetasJugadores.add(nomJugador2);
        etiquetasJugadores.add(nomJugador3);
        etiquetasJugadores.add(nomJugador4);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAviso = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnVotar = new javax.swing.JButton();
        nomJugador1 = new javax.swing.JLabel();
        nomJugador2 = new javax.swing.JLabel();
        nomJugador3 = new javax.swing.JLabel();
        nomJugador4 = new javax.swing.JLabel();
        imgJugador1 = new javax.swing.JLabel();
        imgJugador2 = new javax.swing.JLabel();
        imgJugador3 = new javax.swing.JLabel();
        imgJugador4 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 50, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAviso.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        txtAviso.setForeground(new java.awt.Color(232, 209, 172));
        txtAviso.setText(" Codigo: ");
        jPanel1.add(txtAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 270, -1));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setFocusable(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 30));

        btnVotar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jugar.png"))); // NOI18N
        btnVotar.setBorderPainted(false);
        btnVotar.setContentAreaFilled(false);
        btnVotar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVotar.setFocusPainted(false);
        btnVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVotar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, -1, -1));

        nomJugador1.setText("jLabel2");
        jPanel1.add(nomJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        nomJugador2.setText("jLabel3");
        jPanel1.add(nomJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        nomJugador3.setText("jLabel4");
        jPanel1.add(nomJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        nomJugador4.setText("jLabel5");
        jPanel1.add(nomJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, -1, -1));
        jPanel1.add(imgJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));
        jPanel1.add(imgJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));
        jPanel1.add(imgJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));
        jPanel1.add(imgJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FondoGeneral.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

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

    private void btnVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVotarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVotar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel imgJugador1;
    private javax.swing.JLabel imgJugador2;
    private javax.swing.JLabel imgJugador3;
    private javax.swing.JLabel imgJugador4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomJugador1;
    private javax.swing.JLabel nomJugador2;
    private javax.swing.JLabel nomJugador3;
    private javax.swing.JLabel nomJugador4;
    private javax.swing.JLabel txtAviso;
    // End of variables declaration//GEN-END:variables
    
      public void mostrarJugadores(List<JugadorDto> jugadores) {
        for (int i = 0; i < jugadores.size() && i < etiquetasJugadores.size(); i++) {
            etiquetasJugadores.get(i).setText(jugadores.get(i).getNombre());
        }
    }

    public void agregarIEventoSalirDeLobby(IEventoSalirDeLobby listener) {
        this.observerRegresar = listener;
    }

    private void ejecutarSalirDeLobby(JugadorAEliminarDto jugador) {
        if (observerRegresar != null) {
            observerRegresar.salirDeLobby(jugador);
        }
    }
    
    public void agregarIEventoVotarParaIniciarPartida(IEventoVotarParaIniciarPartida listener) {
        this.observerVotar = listener;
    }

    private void ejecutarVotarParaIniciarPartida(VotoDeJugador votoDeJugador) {
        if (observerVotar != null) {
            observerVotar.iniciarPartida(votoDeJugador);
        }
    }
    
    
    
    @Override
    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }


    private class IniciarPartida implements IObserver {
        @Override
        public void actualizar() {
//            ejecutarIniciarPartida();
        }
    }
}
