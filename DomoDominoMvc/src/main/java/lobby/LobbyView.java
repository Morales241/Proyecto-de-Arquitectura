package lobby;

import dtos.JugadorDto;
import eventos.JugadorAEliminarDto;
import eventos.JugadorBase;
import eventos.VotoDeJugador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mediador.IComponente;
import mediador.IMediador;
import observers.IEventoActualizarLobby;
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
public class LobbyView extends javax.swing.JFrame implements IComponente {

    private final LobbyModel lobbyModel;
    private IMediador mediador;
    private IEventoSalirDeLobby observerRegresar;
    private IEventoVotarParaIniciarPartida observerVotar;

    private final List<JLabel> etiquetasNombres;
    private final List<JLabel> etiquetasImagenes;

    public LobbyView(LobbyModel lobbyModel) {
        initComponents();
        this.lobbyModel = lobbyModel;

        etiquetasNombres = new ArrayList<>();
        etiquetasNombres.add(nomJugador1);
        etiquetasNombres.add(nomJugador2);
        etiquetasNombres.add(nomJugador3);
        etiquetasNombres.add(nomJugador4);

        etiquetasImagenes = new ArrayList<>();
        etiquetasImagenes.add(imgJugador1);
        etiquetasImagenes.add(imgJugador2);
        etiquetasImagenes.add(imgJugador3);
        etiquetasImagenes.add(imgJugador4);

        lobbyModel.agregarIEventoObserverActualizarLobby(new ActualizarLobby());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JLabel();
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

        txtCodigo.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(232, 209, 172));
        txtCodigo.setText(" Codigo: ");
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 100, -1));

        txtCodigo1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        txtCodigo1.setForeground(new java.awt.Color(232, 209, 172));
        jPanel1.add(txtCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 190, 30));

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

        nomJugador1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nomJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        nomJugador2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nomJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        nomJugador3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nomJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        nomJugador4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nomJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, -1, -1));
        jPanel1.add(imgJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 100, 110));
        jPanel1.add(imgJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 80, 130));
        jPanel1.add(imgJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 100, 140));
        jPanel1.add(imgJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 80, 170));

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
        this.ejecutarVotarParaIniciarPartida(new VotoDeJugador(this.txtCodigo.getText()));
    }//GEN-LAST:event_btnVotarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        String nombre = lobbyModel.getJugadores().get(0).getNombre();
        int avatar = lobbyModel.getJugadores().get(0).getAvatar();
        this.ejecutarSalirDeLobby(new JugadorAEliminarDto(nombre, avatar));

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
    private javax.swing.JLabel txtCodigo;
    private javax.swing.JLabel txtCodigo1;
    // End of variables declaration//GEN-END:variables

    public void mostrarJugadores(List<JugadorBase> jugadores) {

        for (int i = 0; i < jugadores.size() && i < etiquetasNombres.size(); i++) {
            etiquetasNombres.get(i).setText(jugadores.get(i).getNombre());

            int avatar = jugadores.get(i).getAvatar();
            String rutaImagen = obtenerRutaImagen(avatar);

            ImageIcon icon = new ImageIcon(rutaImagen);
            etiquetasImagenes.get(i).setIcon(icon);
            etiquetasImagenes.get(i).revalidate();
            etiquetasImagenes.get(i).repaint();
        }
    }

    private String obtenerRutaImagen(int avatar) {
        return switch (avatar) {
            case 1 ->
                "/imgPartidaFichas/avatar1.png";
            case 2 ->
                "/imgPartidaFichas/avatar2.png";
            case 3 ->
                "/imgPartidaFichas/avatar3.png";
            case 4 ->
                "/imgPartidaFichas/avatar4.png";
            default ->
                "";
        };
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

    public void ponerCodigo(String codigo){
        this.txtCodigo.setText(codigo);
    }
    private class ActualizarLobby implements IEventoActualizarLobby {

        @Override
        public void actualizar(JugadorBase jugadorBase) {

            lobbyModel.getJugadores().add(jugadorBase);
            ponerCodigo("Codigo: "+jugadorBase.getCodigo());
            mostrarJugadores(lobbyModel.getJugadores());

        }
    }
}
