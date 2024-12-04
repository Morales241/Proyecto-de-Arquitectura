package TableroMvc;

import dtos.Array;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;

import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TableroView extends JFrame implements TableroModel.Observer {

    private TableroModel model;
    private JPanel botonesPanel;
    private JPanel fichasJugadorPanel;
    private TableroPanel tableroPanel;

    public TableroView(TableroModel model) {
        this.model = model;
        this.model.agregarObserver(this);

        setSize(1200, 850);
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel del tablero (centro)
        tableroPanel = new TableroPanel(model.getArray());
        add(tableroPanel, BorderLayout.CENTER);

        // Panel contenedor para los botones y las fichas (orientación vertical)
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));

        add(panelInferior, BorderLayout.SOUTH);

        // Panel para los botones de extremos (inicialmente oculto)
        botonesPanel = new JPanel(new FlowLayout());
        botonesPanel.setVisible(false);
        panelInferior.add(botonesPanel);

        // Panel para las fichas del jugador con imagen de fondo
        fichasJugadorPanel = new JPanelWithBackground();
        panelInferior.add(fichasJugadorPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update() {
        // Aquí puedes actualizar la vista cuando se notifique un cambio en el modelo
        fichasJugadorPanel.removeAll(); // Limpiar el panel
        fichasJugadorPanel.revalidate();
        fichasJugadorPanel.repaint();
        tableroPanel.repaint();
    }

    // Clase para el panel con fondo de imagen
    public class JPanelWithBackground extends JPanel {

        private ImageIcon fondoImagen;

        public JPanelWithBackground() {
            this.fondoImagen = new ImageIcon(getClass().getResource("/imgPartidaFichas/FondoGeneral.png"));
            setPreferredSize(new Dimension(500, 200)); // Ajusta el tamaño del panel según sea necesario
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Dibujar la imagen de fondo en el panel
            g.drawImage(fondoImagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Clase TableroPanel restaurada
    public class TableroPanel extends JPanel {

        private final int[][] tablero;
        private final ImageIcon fondoImagen; // Imagen de fondo

        public TableroPanel(Array array) {
            this.tablero = array.obtenerTablero();
            this.fondoImagen = new ImageIcon(getClass().getResource("/imgPartidaFichas/imagenFondo.png")); // Ruta de la imagen
            setPreferredSize(new Dimension(800, 800)); // Tamaño del panel
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int cellSize = 50;
            int rows = tablero.length;
            int cols = tablero[0].length;

            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int tableroWidth = cols * cellSize;
            int tableroHeight = rows * cellSize;

            int offsetX = (panelWidth - tableroWidth) / 2;
            int offsetY = (panelHeight - tableroHeight) / 2;

            // Dibujar la imagen de fondo en el panel
            g.drawImage(fondoImagen.getImage(), 0, 0, getWidth(), getHeight(), this);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (tablero[i][j] != -1) {
                        g.setColor(Color.GRAY);
                        g.fillRect(offsetX + j * cellSize, offsetY + i * cellSize, cellSize, cellSize);
                        g.setColor(Color.BLACK);
                        g.drawRect(offsetX + j * cellSize, offsetY + i * cellSize, cellSize, cellSize);
                        g.drawString(String.valueOf(tablero[i][j]),
                                offsetX + j * cellSize + cellSize / 4,
                                offsetY + i * cellSize + cellSize / 2);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Crear el modelo (TableroModel) que será pasado al JFrame.
        Array array = new Array();
        TableroModel modelo = new TableroModel(array);

        // Crear la vista (el JFrame)
        TableroView vista = new TableroView(modelo);

        // Configurar la visibilidad y operaciones básicas del JFrame
        java.awt.EventQueue.invokeLater(() -> {
            vista.setVisible(true);
        });
    }
}
