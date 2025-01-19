package pantallaPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author tacot
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        agregarFondoTablero();
        agregarFondoPanelJugador1();
        agregarFichasDelJugador();
        pintarTablero();
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Principal = new javax.swing.JPanel();
        PanelJugador2 = new javax.swing.JPanel();
        AvatarJugador2 = new javax.swing.JLabel();
        FichasJugador2 = new javax.swing.JLabel();
        PanelJugador3 = new javax.swing.JPanel();
        AvatarJugador3 = new javax.swing.JLabel();
        FichasJugador3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnPozo = new javax.swing.JButton();
        PanelScrollJugador1 = new javax.swing.JScrollPane();
        PanelJugador1 = new javax.swing.JPanel();
        PanelJugador4 = new javax.swing.JPanel();
        AvatarJugador4 = new javax.swing.JLabel();
        FichasJugador4 = new javax.swing.JLabel();
        PanelTablero = new javax.swing.JPanel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Principal.setBackground(new java.awt.Color(255, 255, 255));
        Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelJugador2.setBackground(new java.awt.Color(0, 0, 0,0));
        PanelJugador2.setMinimumSize(new java.awt.Dimension(400, 100));
        PanelJugador2.setPreferredSize(new java.awt.Dimension(400, 100));

        AvatarJugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/avatar2.png"))); // NOI18N

        FichasJugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fichaRespaldo/fichaRespaldo1.png"))); // NOI18N

        javax.swing.GroupLayout PanelJugador2Layout = new javax.swing.GroupLayout(PanelJugador2);
        PanelJugador2.setLayout(PanelJugador2Layout);
        PanelJugador2Layout.setHorizontalGroup(
            PanelJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJugador2Layout.createSequentialGroup()
                .addComponent(AvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(FichasJugador2)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        PanelJugador2Layout.setVerticalGroup(
            PanelJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJugador2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(AvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(FichasJugador2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        Principal.add(PanelJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 300, 100));

        PanelJugador3.setBackground(new java.awt.Color(0, 0, 0,0));
        PanelJugador3.setPreferredSize(new java.awt.Dimension(100, 300));

        AvatarJugador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/avatar1.png"))); // NOI18N

        FichasJugador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fichaRespaldo/fichaRespaldo1.png"))); // NOI18N

        javax.swing.GroupLayout PanelJugador3Layout = new javax.swing.GroupLayout(PanelJugador3);
        PanelJugador3.setLayout(PanelJugador3Layout);
        PanelJugador3Layout.setHorizontalGroup(
            PanelJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJugador3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AvatarJugador3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJugador3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(FichasJugador3)))
                .addContainerGap())
        );
        PanelJugador3Layout.setVerticalGroup(
            PanelJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJugador3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AvatarJugador3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FichasJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        Principal.add(PanelJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 140, 250));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/regresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        Principal.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 50));

        btnPozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Pozo.png"))); // NOI18N
        btnPozo.setBorderPainted(false);
        btnPozo.setContentAreaFilled(false);
        Principal.add(btnPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 100, 82));

        PanelScrollJugador1.setBackground(new java.awt.Color(0,0,0,0));

        PanelJugador1.setBackground(new java.awt.Color(96, 61, 33));

        javax.swing.GroupLayout PanelJugador1Layout = new javax.swing.GroupLayout(PanelJugador1);
        PanelJugador1.setLayout(PanelJugador1Layout);
        PanelJugador1Layout.setHorizontalGroup(
            PanelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        PanelJugador1Layout.setVerticalGroup(
            PanelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        PanelScrollJugador1.setViewportView(PanelJugador1);

        Principal.add(PanelScrollJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 410, 140));

        PanelJugador4.setBackground(new java.awt.Color(0, 0, 0,0));
        PanelJugador4.setPreferredSize(new java.awt.Dimension(100, 300));

        AvatarJugador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/avatar3.png"))); // NOI18N

        FichasJugador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fichaRespaldo/fichaRespaldo1.png"))); // NOI18N

        javax.swing.GroupLayout PanelJugador4Layout = new javax.swing.GroupLayout(PanelJugador4);
        PanelJugador4.setLayout(PanelJugador4Layout);
        PanelJugador4Layout.setHorizontalGroup(
            PanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJugador4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AvatarJugador4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJugador4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(FichasJugador4)))
                .addContainerGap())
        );
        PanelJugador4Layout.setVerticalGroup(
            PanelJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJugador4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AvatarJugador4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FichasJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Principal.add(PanelJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, 250));

        PanelTablero.setBackground(new java.awt.Color(187, 135, 89));
        PanelTablero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Principal.add(PanelTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 130, 618, 330));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondo_Tablero.png"))); // NOI18N
        Fondo.setName(""); // NOI18N
        Principal.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    private void agregarFondoTablero() {
        //fondo del tablero
        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/fondos/Fondo_Tablero2.png")));
        fondo.setBounds(0, 0, PanelTablero.getWidth(), PanelTablero.getHeight());
        PanelTablero.add(fondo);
        PanelTablero.setComponentZOrder(fondo, PanelTablero.getComponentCount() - 1);

    }

    private void agregarFondoPanelJugador1() {

        //fondo del panel del jugador 1
        JLabel fondoJ1 = new JLabel(new ImageIcon(getClass().getResource("/fondos/Fondo_PanelJ1.png")));
        fondoJ1.setBounds(0, 0, PanelJugador1.getWidth(), PanelJugador1.getHeight());
        PanelJugador1.add(fondoJ1);
        PanelJugador1.setComponentZOrder(fondoJ1, PanelJugador1.getComponentCount() - 1);
    }

    private void agregarFichasDelJugador() {
        int alto = 102;
        int ancho = 56;

        PanelJugador1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        PanelJugador1.removeAll();

        for (int i = 0; i <= 1; i++) {
            for (int j = i; j <= 4; j++) {
                String rutaImagen = String.format("/fichasNormales/ficha%d_%d.png", i, j);

                URL urlImagen = getClass().getResource(rutaImagen);

                ImageIcon icon = new ImageIcon(urlImagen);

                JButton button = new JButton(icon);

                button.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button.setBackground(new ColorUIResource(96, 61, 33));
                    }
                });

                button.setBorderPainted(false);
                button.setFocusable(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setRolloverEnabled(false);
                button.setPreferredSize(new Dimension(ancho, alto));

                PanelJugador1.add(button);
            }
        }
        PanelJugador1.revalidate();
        PanelJugador1.repaint();
    }

    private void pintarTablero() {

        PanelTablero.removeAll();
        
        agregarFondoTablero();
        
        Graphics2D g2d = (Graphics2D) PanelTablero.getGraphics().create();
        
        int anchoDeCelda = 30;
        int altoDeCelada = 30;
        
        int filas = 20;
        int columnas = 20;
        
        int anchoDePanel  = PanelTablero.getWidth();
        int altoDePanel = PanelTablero.getHeight();
        
        int anchoDeTablero = columnas * anchoDeCelda;
        int altoDeTablero = filas * altoDeCelada;
        
        int guiaX = (anchoDePanel - anchoDeTablero)/2;
        int guiaY = (altoDePanel - altoDeTablero)/2;
        
        for (int i = 0; i < filas ; i++) {
            for (int j = 0; j < columnas; j++) {
                
//                int valor = tablero[i][j];

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvatarJugador2;
    private javax.swing.JLabel AvatarJugador3;
    private javax.swing.JLabel AvatarJugador4;
    private javax.swing.JLabel FichasJugador2;
    private javax.swing.JLabel FichasJugador3;
    private javax.swing.JLabel FichasJugador4;
    private javax.swing.JLabel Fondo;
    private javax.swing.JPanel PanelJugador1;
    private javax.swing.JPanel PanelJugador2;
    private javax.swing.JPanel PanelJugador3;
    private javax.swing.JPanel PanelJugador4;
    private javax.swing.JScrollPane PanelScrollJugador1;
    private javax.swing.JPanel PanelTablero;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton btnPozo;
    private javax.swing.JButton btnRegresar;
    // End of variables declaration//GEN-END:variables
}
