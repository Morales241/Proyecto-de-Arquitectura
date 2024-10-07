package InicioMvc;


import java.awt.event.ActionListener;
import mediador.IComponente;
import mediador.Mediador;
import observers.IObserver;

public class InicioView extends javax.swing.JFrame implements IObserver, IComponente{
    
    private InicioModel inicioModel;
    private Mediador mediador;
    
    /**
     * Creates new form InicioView
     */
    public InicioView(InicioModel inicioModel) {
        initComponents();
        this.inicioModel = inicioModel;
        inicioModel.agregarObservador(this);
    }

    public void btnJugar(ActionListener actionListener){
        btnJugar.addActionListener(actionListener);
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnJugar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnJugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jugar - copia.png"))); // NOI18N
        btnJugar.setBorderPainted(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setFocusPainted(false);
        btnJugar.setFocusable(false);
        jPanel1.add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 260, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/domodomino.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(String estado) {
        
    }
    
    @Override
    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}
