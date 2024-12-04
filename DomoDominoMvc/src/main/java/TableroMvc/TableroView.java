package TableroMvc;

import dtos.ArrayDto;
import dtos.FichaDto;
import dtos.JugadorDto;
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
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class TableroView extends JFrame implements TableroModel.Observer {

    private TableroModel model;
    private JPanel fichasJugadorPanel;
    private TableroPanel tableroPanel;
    private FichaDto fichaSeleccionada = null;

    private JLayeredPane layeredPane;

    public TableroView(TableroModel model) {
        this.model = model;
        this.model.agregarObserver(this);

       this.setSize(1210, 730);
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

  
        layeredPane = new JLayeredPane();
        setContentPane(layeredPane);

        
        tableroPanel = new TableroPanel(model.getArray());
        tableroPanel.setBounds(0, 0, 1200, 700); 
        layeredPane.add(tableroPanel, JLayeredPane.DEFAULT_LAYER);


        fichasJugadorPanel = new JPanelWithBackground();
        fichasJugadorPanel.setBounds(100, 550, 960, 120);
        layeredPane.add(fichasJugadorPanel, JLayeredPane.PALETTE_LAYER);


        JButton botonPozo = new JButton();
        String rutaImagen = "/imgPartidaFichas/Pozo.png";
        URL recurso = getClass().getResource(rutaImagen);
        if (recurso != null) {
            ImageIcon icono = new ImageIcon(recurso);
            botonPozo.setIcon(icono);
        
            botonPozo.setContentAreaFilled(false);
            botonPozo.setBorderPainted(false);
            botonPozo.setPreferredSize(new Dimension(110, 110));
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen);
        }
        botonPozo.setBounds(1080, 550, 110, 110);
        layeredPane.add(botonPozo, JLayeredPane.PALETTE_LAYER);

       JLabel avatarJugador = new JLabel();
        String rutaImagen2 = "/imgPartidaFichas/avatar1.png";
        URL recurso2 = getClass().getResource(rutaImagen2);
        if (recurso != null) {
            ImageIcon icono2 = new ImageIcon(recurso2);
            avatarJugador.setIcon(icono2);
      
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen);
        }
         avatarJugador.setBounds(0, 550, 110, 110);
layeredPane.add(avatarJugador, JLayeredPane.PALETTE_LAYER);

        for (FichaDto ficha : model.getJugador().getFichas()) {
            if (ficha != null) {
                agregarFichaAlPanel(ficha);
            }
        }

       
 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarFichaAlPanel(FichaDto ficha) {
        String rutaImagen = String.format("/imgPartidaFichas/ficha%d_%d.png", ficha.getLado1(), ficha.getLado2());
        URL recurso = getClass().getResource(rutaImagen);

        if (recurso != null) {
            ImageIcon icono = new ImageIcon(recurso);
            JButton fichaLabel = new JButton(icono);
            fichaLabel.setContentAreaFilled(false);
            fichaLabel.setBorderPainted(false);
            fichasJugadorPanel.add(fichaLabel);
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen);
        }
    }

    public void update() {
        System.out.println("Fichas actuales: " + model.getJugador().getFichas().size());
        fichasJugadorPanel.removeAll();
        for (FichaDto ficha : model.getJugador().getFichas()) {
            agregarFichaAlPanel(ficha);
        }
        fichasJugadorPanel.revalidate();
        fichasJugadorPanel.repaint();
        tableroPanel.repaint();
    }

    public class JPanelWithBackground extends JPanel {

        private ImageIcon fondoImagen;

        public JPanelWithBackground() {
            this.fondoImagen = new ImageIcon(getClass().getResource("/imgPartidaFichas/FondoGeneral.png"));
            setPreferredSize(new Dimension(100, 100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(fondoImagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Clase TableroPanel restaurada
    public class TableroPanel extends JPanel {

        private final int[][] tablero;
        private final ImageIcon fondoImagen;

        public TableroPanel(ArrayDto array) {
            this.tablero = array.obtenerTablero();
            this.fondoImagen = new ImageIcon(getClass().getResource("/imgPartidaFichas/imagenFondo.png"));
            setPreferredSize(new Dimension(1200, 700)); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int cellSize = 40;
            int rows = tablero.length;
            int cols = tablero[0].length;

            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int tableroWidth = cols * cellSize;
            int tableroHeight = rows * cellSize;

            int offsetX = (panelWidth - tableroWidth) / 2;
            int offsetY = (panelHeight - tableroHeight) / 2;

          
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
       
        ArrayDto array = new ArrayDto();
        JugadorDto jugador = new JugadorDto("Favela");

        jugador.agregarFichas(jugador.repartirFichas());

        TableroModel modelo = new TableroModel(array, jugador);

      
        TableroView vista = new TableroView(modelo);

      
        java.awt.EventQueue.invokeLater(() -> {
            vista.setVisible(true);
        });
    }
}
