package TableroMvc;

import dtos.ArrayDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import javax.swing.*;

public class TableroView extends JFrame implements TableroModel.Observer {

    private TableroModel model;
    private List<FichaDto> fichas;
    private JPanel fichasJugadorPanel;
    private TableroPanel tableroPanel;
    private FichaDto fichaSeleccionada = null;
    private JPanel botonesPanel;
    private JLayeredPane layeredPane;

    public TableroView(TableroModel model) {
        this.model = model;
        this.model.agregarObserver(this);
        fichas = model.getJugador().repartirFichas();
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

        botonesPanel = new JPanel(new GridLayout(1, 2));
        botonesPanel.setBounds(450, 500, 300, 50);
        botonesPanel.setVisible(false);
        layeredPane.add(botonesPanel, JLayeredPane.POPUP_LAYER);

        JButton botonPozo = new JButton();
        botonPozo.setEnabled(false);
        String rutaImagen = "/imgPartidaFichas/Pozo.png";
        URL recurso = getClass().getResource(rutaImagen);
        if (recurso != null) {
            ImageIcon icono = new ImageIcon(recurso);
            botonPozo.setIcon(icono);
            botonPozo.setContentAreaFilled(false);
            botonPozo.setBorderPainted(false);
            botonPozo.setPreferredSize(new Dimension(110, 110));
        }
        botonPozo.setBounds(1080, 550, 110, 110);
        layeredPane.add(botonPozo, JLayeredPane.PALETTE_LAYER);

        JLabel avatarJugador = new JLabel();
        String rutaImagen2 = "/imgPartidaFichas/avatar1.png";
        URL recurso2 = getClass().getResource(rutaImagen2);
        if (recurso != null) {
            ImageIcon icono2 = new ImageIcon(recurso2);
            avatarJugador.setIcon(icono2);
        }
        avatarJugador.setBounds(0, 550, 110, 110);
        layeredPane.add(avatarJugador, JLayeredPane.PALETTE_LAYER);

        for (FichaDto ficha : fichas) {
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

            fichaLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    fichaSeleccionada = ficha;
                    mostrarBotonesSeleccion();
                }
            });

            fichasJugadorPanel.add(fichaLabel);
        }
    }

    @Override
    public void update() {
        fichasJugadorPanel.removeAll();
        for (FichaDto ficha : model.getJugador().getFichas()) {
            agregarFichaAlPanel(ficha);
        }
        fichasJugadorPanel.revalidate();
        fichasJugadorPanel.repaint();
        tableroPanel.repaint();
    }

    private void mostrarBotonesSeleccion() {
        botonesPanel.removeAll();

        JButton botonExtremo1 = new JButton("Extremo 1");
        botonExtremo1.addActionListener(e -> mostrarBotonesDireccion(true));
        botonesPanel.add(botonExtremo1);

        JButton botonExtremo2 = new JButton("Extremo 2");
        botonExtremo2.addActionListener(e -> mostrarBotonesDireccion(false));
        botonesPanel.add(botonExtremo2);

        botonesPanel.setVisible(true);
        botonesPanel.revalidate();
        botonesPanel.repaint();
    }

    private void mostrarBotonesDireccion(boolean extremoIzquierdo) {
        botonesPanel.removeAll();

        String[] direcciones = {"Arriba", "Abajo", "Izquierda", "Derecha"};
        for (String direccion : direcciones) {
            JButton botonDireccion = new JButton(direccion);
            botonDireccion.addActionListener(e -> colocarFicha(extremoIzquierdo, direccion));
            botonesPanel.add(botonDireccion);
        }

        botonesPanel.setVisible(true);
        botonesPanel.revalidate();
        botonesPanel.repaint();
    }

    private void colocarFicha(boolean extremoIzquierdo, String direccion) {
        if (fichaSeleccionada != null) {
            boolean colocada;
            if (extremoIzquierdo) {
                colocada = model.getArray().colocarFichaExtremoIzquierdo(fichaSeleccionada);
            } else {
                colocada = model.getArray().colocarFichaExtremoDerecho(fichaSeleccionada);
            }

            if (colocada) {
                model.getJugador().getFichas().remove(fichaSeleccionada);
                fichaSeleccionada = null;
                update();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo colocar la ficha.");
            }
        }
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
        TableroModel modelo = new TableroModel(array, jugador);
        TableroView vista = new TableroView(modelo);
        java.awt.EventQueue.invokeLater(() -> vista.setVisible(true));
    }
}
