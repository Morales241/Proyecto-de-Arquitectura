package SalaEsperaMvc;

import mediador.IComponente;
import mediador.IMediador;

/**
 * Vista de la sala de espera
 *
 *
 * @author Luis Roberto Favela Castro - 00000246853
 * @author Josue Gomez Garza - 00000245612
 * @author Alejandro Gomez Vega - 00000247313
 * @author Jesus Alberto Morales Rojas - 00000245335
 */
public class SalaEsperaView extends javax.swing.JFrame implements IComponente{
    
    private final SalaEsperaModel salaEsperaModel;
    private IMediador mediador;
    
    public SalaEsperaView(SalaEsperaModel salaEsperaModel) {
        initComponents();
        this.salaEsperaModel = salaEsperaModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        labelJugador4 = new javax.swing.JLabel();
        labelCodigoMesa = new javax.swing.JLabel();
        labelJugador3 = new javax.swing.JLabel();
        labelJugador1 = new javax.swing.JLabel();
        labelJugador2 = new javax.swing.JLabel();
        imgJugador4 = new javax.swing.JLabel();
        imgJugador1 = new javax.swing.JLabel();
        imgJugador2 = new javax.swing.JLabel();
        imgJugador3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 84, 48));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Codigo de mesa:");
        jPanel2.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 230, 30));

        btnJugar.setContentAreaFilled(false);
        jPanel2.add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 150, 40));

        labelJugador4.setBackground(new java.awt.Color(255, 255, 255));
        labelJugador4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelJugador4.setForeground(new java.awt.Color(255, 255, 255));
        labelJugador4.setText("Jugador 4");
        jPanel2.add(labelJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        labelCodigoMesa.setBackground(new java.awt.Color(255, 255, 255));
        labelCodigoMesa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigoMesa.setForeground(new java.awt.Color(255, 255, 255));
        labelCodigoMesa.setText("xxxx-xxxx");
        jPanel2.add(labelCodigoMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        labelJugador3.setBackground(new java.awt.Color(255, 255, 255));
        labelJugador3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelJugador3.setForeground(new java.awt.Color(255, 255, 255));
        labelJugador3.setText("Jugador 3");
        jPanel2.add(labelJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        labelJugador1.setBackground(new java.awt.Color(255, 255, 255));
        labelJugador1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelJugador1.setForeground(new java.awt.Color(255, 255, 255));
        labelJugador1.setText("Jugador 1");
        jPanel2.add(labelJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        labelJugador2.setBackground(new java.awt.Color(255, 255, 255));
        labelJugador2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelJugador2.setForeground(new java.awt.Color(255, 255, 255));
        labelJugador2.setText("Jugador 2");
        jPanel2.add(labelJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));
        jPanel2.add(imgJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 80, 70));
        jPanel2.add(imgJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 80, 70));
        jPanel2.add(imgJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 80, 70));
        jPanel2.add(imgJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 80, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 720, 420));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regresar.png"))); // NOI18N
        btnRegresar.setContentAreaFilled(false);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 40));

        imgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenFondo.png"))); // NOI18N
        imgFondo.setToolTipText("");
        jPanel1.add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel imgJugador1;
    private javax.swing.JLabel imgJugador2;
    private javax.swing.JLabel imgJugador3;
    private javax.swing.JLabel imgJugador4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCodigoMesa;
    private javax.swing.JLabel labelJugador1;
    private javax.swing.JLabel labelJugador2;
    private javax.swing.JLabel labelJugador3;
    private javax.swing.JLabel labelJugador4;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }
}
