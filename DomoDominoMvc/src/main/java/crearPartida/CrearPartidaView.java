package crearPartida;

import eventos.JugadorCrearPartidaDto;
import eventos.NodoDto;
import javax.swing.*;
import mediador.IComponente;
import mediador.IMediador;
import observers.IEventoSeleccion;
import observersLogicaAServidorCentral.IEventoCrearPartida;
import observers.IObserver;

/**
 *
 * @author tacot
 */
public class CrearPartidaView extends javax.swing.JFrame implements IComponente {

    private IMediador mediador;
    private final CrearPartidaModel modelo;
    private IEventoCrearPartida observerCrearPartida;
    private IEventoSeleccion observerSeleccionIzquierda;
    private IEventoSeleccion observerSeleccionDerecha;
    private IObserver observerRegresar;

    /**
     * Creates new form CrearMesaView
     *
     * @param mesaModel
     */
    public CrearPartidaView(CrearPartidaModel modelo) {
        initComponents();
        this.modelo = modelo;
        modelo.agregarIEventoNombreInvalido(new accionNombreInvalido());
        modelo.agregarObservadorCambioAvatar(new accionSeleccionAvatar());
        actualizarAvatar();
        etiquetaAvatar.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearPartida = new javax.swing.JButton();
        cbxNumeroFichas = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        etiquetaAvatar = new javax.swing.JLabel();
        flechaSeleccionIzq = new javax.swing.JButton();
        flechaSeleccionDer = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(174, 70, 43));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setToolTipText("Nombre del jugador");
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ingreseNombre.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 200, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fichasIniciales.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        btnCrearPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crearPartida.png"))); // NOI18N
        btnCrearPartida.setBorder(null);
        btnCrearPartida.setContentAreaFilled(false);
        btnCrearPartida.setFocusPainted(false);
        btnCrearPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPartidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 190, 70));

        cbxNumeroFichas.setBackground(new java.awt.Color(174, 70, 43));
        cbxNumeroFichas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxNumeroFichas.setForeground(new java.awt.Color(255, 255, 255));
        cbxNumeroFichas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        cbxNumeroFichas.setBorder(null);
        jPanel1.add(cbxNumeroFichas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 180, -1));

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
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/selecciona avatar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));
        jPanel1.add(etiquetaAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 110, 120));

        flechaSeleccionIzq.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        flechaSeleccionIzq.setForeground(new java.awt.Color(255, 231, 202));
        flechaSeleccionIzq.setText("<");
        flechaSeleccionIzq.setBorderPainted(false);
        flechaSeleccionIzq.setContentAreaFilled(false);
        flechaSeleccionIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flechaSeleccionIzqActionPerformed(evt);
            }
        });
        jPanel1.add(flechaSeleccionIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 110, 110));

        flechaSeleccionDer.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        flechaSeleccionDer.setForeground(new java.awt.Color(253, 231, 194));
        flechaSeleccionDer.setText(">");
        flechaSeleccionDer.setBorderPainted(false);
        flechaSeleccionDer.setContentAreaFilled(false);
        flechaSeleccionDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flechaSeleccionDerActionPerformed(evt);
            }
        });
        jPanel1.add(flechaSeleccionDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 110, 110));

        fondo.setForeground(new java.awt.Color(174, 70, 43));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo_CrearPartida.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPartidaActionPerformed
        int avatar = 0;
        Icon icono = etiquetaAvatar.getIcon();
       icono.toString();
        if (icono instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) icono;
            String descripcion = imageIcon.getDescription();
           

            if(descripcion.contains("avatar1.png")){
                avatar = 1;
            }else if(descripcion.contains("avatar2.png")){
                avatar = 2;
            }else if(descripcion.contains("avatar3.png")){
                avatar = 3;
            }else if(descripcion.contains("avatar4.png")){
                avatar = 4;
            }
        }
        ejecutarAccionCrearPartida(this.txtNombre.getText(), Integer.parseInt(String.valueOf(this.cbxNumeroFichas.getSelectedItem())), avatar);
    }//GEN-LAST:event_btnCrearPartidaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ejecutarAccionRegresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void flechaSeleccionIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flechaSeleccionIzqActionPerformed
        ejecutarAccionSeleccionIzquierda();
    }//GEN-LAST:event_flechaSeleccionIzqActionPerformed

    private void flechaSeleccionDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flechaSeleccionDerActionPerformed
        ejecutarAccionSeleccionDerecha();
    }//GEN-LAST:event_flechaSeleccionDerActionPerformed

    public void validarDatos() {
        JOptionPane.showMessageDialog(null, "No se permiten caracteres especiales(solo '_') ni espacios, el nombre tiene que ser mayor a 3 y menor a 15 caracteres");
    
    }

    public void actualizarAvatar() {
        System.out.println(modelo.getRutaAvatarActual());
        etiquetaAvatar.setIcon(cargarIconoAvatar(modelo.getRutaAvatarActual()));
    }
    
    

    public void agregarIEventoCrearPartida(IEventoCrearPartida listener) {
        this.observerCrearPartida = listener;

    }

    public void ejecutarAccionCrearPartida(String nombre, int numFichas, int avatar) {
        if (observerCrearPartida != null) {

            JugadorCrearPartidaDto jugador = new JugadorCrearPartidaDto(numFichas, new NodoDto(nombre, avatar), "");

            observerCrearPartida.crearPartida(jugador);
        }
    }

    public void agregarIEventoRegresar(IObserver listener) {
        this.observerRegresar = listener;

    }

    public void agregarIEventoSeleccionIzquierda(IEventoSeleccion listener) {
        this.observerSeleccionIzquierda = listener;
    }

    public void agregarIEventoSeleccionDerecha(IEventoSeleccion listener) {
        this.observerSeleccionDerecha = listener;
    }

    public void ejecutarAccionSeleccionIzquierda() {
        if (observerSeleccionIzquierda != null) {
            observerSeleccionIzquierda.actualizarAvatar();
        }
    }

    public void ejecutarAccionSeleccionDerecha() {
        if (observerSeleccionDerecha != null) {
            observerSeleccionDerecha.actualizarAvatar();
        }
    }

    public void ejecutarAccionRegresar() {
        if (observerRegresar != null) {
            observerRegresar.actualizar();
        }
    }

    private ImageIcon cargarIconoAvatar(String ruta) {
        java.net.URL imgURL = getClass().getResource(ruta);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + ruta);
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPartida;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxNumeroFichas;
    private javax.swing.JLabel etiquetaAvatar;
    private javax.swing.JButton flechaSeleccionDer;
    private javax.swing.JButton flechaSeleccionIzq;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setMediador(IMediador mediador) {
        this.mediador = mediador;
    }

    private class accionNombreInvalido implements IObserver {

        @Override
        public void actualizar() {
            validarDatos();
        }
    }

    private class accionSeleccionAvatar implements IObserver {

        @Override
        public void actualizar() {
           actualizarAvatar();
        }
    }

}