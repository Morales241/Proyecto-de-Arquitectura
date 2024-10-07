/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TableroMvc;

import dtos.Arreglo;
import dtos.JugadorDto;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import mediador.IComponente;
import mediador.Mediador;
import observers.IObservable;
import observers.IObserver;
import pozo.Ficha;

public class TableroView extends javax.swing.JFrame implements IObservable, IComponente {

    private List<IObserver> observadores = new ArrayList<>();
    private TableroModel tableroModel;
    private Arreglo array;
    private JugadorDto jugador;
    private Mediador mediador;

    /**
     * Creates new form TableroView
     *
     * @param tableroModel
     * @param array
     * @param jugador
     */
    public TableroView(TableroModel tableroModel, Arreglo array, JugadorDto jugador) {
        this.setSize(1200, 850);
        this.tableroModel = tableroModel;
        this.array = array;
        this.jugador = jugador;
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

      
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 750)); 

       
        JPanel fichasJugadorPanel = new JPanel();
        fichasJugadorPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
        fichasJugadorPanel.setOpaque(false);

    
        fichasJugadorPanel.setBounds(0, 650, 1000, 100); 

   
        layeredPane.add(fichasJugadorPanel, Integer.valueOf(2)); 

    
        TableroPanel tableroPanel = new TableroPanel(array);
        tableroPanel.setBounds(200, 150, 600, 400); 
        tableroPanel.setOpaque(false); 
        layeredPane.add(tableroPanel, Integer.valueOf(1));

       
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/fondoPrueba1.png")));
        backgroundLabel.setBounds(0, 0, 1000, 750);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        
        getContentPane().add(layeredPane, BorderLayout.CENTER);

        for (Ficha ficha : jugador.getFichas()) {
            JLabel fichaLabel = new JLabel(ficha.getIcono());
            fichaLabel.setTransferHandler(new FichaTransferHandler(ficha, fichaLabel, fichasJugadorPanel));
            fichaLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JComponent comp = (JComponent) e.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, e, TransferHandler.MOVE);
                }
            });
            fichasJugadorPanel.add(fichaLabel);
        }

        add(fichasJugadorPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Configuramos el drag-and-drop para el tablero
        new DropTarget(tableroPanel, new DropTargetListener() {
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
            }

            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragExit(DropTargetEvent dte) {
            }

            @Override
            public void drop(DropTargetDropEvent dtde) {
                System.out.println("Ficha soltada en el tablero");
                try {
                    Transferable transferable = dtde.getTransferable();
                    ImageIcon icon = (ImageIcon) transferable.getTransferData(DataFlavor.imageFlavor);

                    
                    Point dropPoint = dtde.getLocation();
                    int fila = dropPoint.y / 40; 
                    int columna = dropPoint.x / 40;

             
                    if (esPosicionValida(fila, columna)) {
                        Ficha fichaColocada = encontrarFichaPorIcono(icon);
                        if (fichaColocada != null) {

                            array.colocarFichaHorizontal(fichaColocada, fila, columna);
                            jugador.getFichas().remove(fichaColocada);

                            tableroPanel.repaint();
                            tableroPanel.revalidate();

                            removerFichaDelPanel(fichaColocada, fichasJugadorPanel);

                            fichasJugadorPanel.revalidate();
                            fichasJugadorPanel.repaint();
                        }
                    } else {
                        System.out.println("Posición inválida para colocar la ficha.");
                    }
                    dtde.dropComplete(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    dtde.dropComplete(false);
                }
            }
           

            private boolean esPosicionValida(int fila, int columna) {
          
                return array.estaVacio(fila, columna) && array.estaVacio(fila, columna + 1);
            }

           
            private Ficha encontrarFichaPorIcono(ImageIcon icon) {
                for (Ficha ficha : jugador.getFichas()) {
                    if (ficha.getIcono().getImage().equals(icon.getImage())) {
                        return ficha;
                    }
                }
                return null;
            }

          
            private void removerFichaDelPanel(Ficha fichaColocada, JPanel fichasJugadorPanel) {
                for (Component component : fichasJugadorPanel.getComponents()) {
                    if (component instanceof JLabel) {
                        JLabel label = (JLabel) component;
                        if (((ImageIcon) label.getIcon()).getImage().equals(fichaColocada.getIcono().getImage())) {
                            fichasJugadorPanel.remove(label);
                            break;
                        }
                    }
                }
            }
        });
    }

    private TableroView() {
        initComponents();
    }

    public class TableroPanel extends JPanel {

        private int[][] tablero;

        public TableroPanel(Arreglo array) {
            this.tablero = array.obtenerTablero();
            setPreferredSize(new Dimension(800, 800));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = 40;

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                    if (tablero[i][j] != 0) { 
                        g.drawString(String.valueOf(tablero[i][j]), j * cellSize + cellSize / 4, i * cellSize + cellSize / 2);
                    }
                }
            }
        }
    }

    class FichaTransferHandler extends TransferHandler {

        private Ficha ficha;
        private JLabel fichaLabel;
        private JPanel fichasJugadorPanel;

        public FichaTransferHandler(Ficha objetoFicha, JLabel objetofichaLabel, JPanel objetofichasJugadorPanel) {
            this.ficha = objetoFicha;
            this.fichaLabel = objetofichaLabel;
            this.fichasJugadorPanel = objetofichasJugadorPanel;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new Transferable() {
                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[]{DataFlavor.imageFlavor};
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return DataFlavor.imageFlavor.equals(flavor);
                }

                @Override
                public Object getTransferData(DataFlavor flavor) {
                    if (DataFlavor.imageFlavor.equals(flavor)) {
                        return ficha.getIcono();
                    }
                    return null;
                }
            };
        }

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nWFiIuU.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void agregarObservador(IObserver observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObserver observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        observadores.forEach(IObserver -> {
            IObserver.actualizar(mensaje);
        });
    }

    @Override
    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
