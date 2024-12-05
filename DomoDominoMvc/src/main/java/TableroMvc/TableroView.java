package TableroMvc;

import dtos.ArregloDto;
import dtos.FichaDto;
import dtos.JugadorDto;
import eventos.PonerFichaDto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import mediador.IComponente;
import mediador.IMediador;
import observers.IEventoPonerFicha;
import observers.IObserver;

public class TableroView extends JFrame implements IComponente {

    private TableroModel model;
    private JPanel fichasJugadorPanel;
    private IMediador mediador;
    private TableroPanel tableroPanel;
    private FichaDto fichaSeleccionada = null;
    private JPanel botonesPanel;
    private JLayeredPane layeredPane;
    private IObserver actualizar;
    private IEventoPonerFicha eventoPonerFicha;

    public TableroView(TableroModel model) {
        this.model = model;
        this.model.agregarObserverActualizar(new Actualizar());

        this.setSize(1210, 730);
        setTitle("Tablero de Dominó");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarPaneles();

        if (model.getJugador() != null && model.getJugador().getFichas() != null) {
            for (FichaDto ficha : model.getJugador().getFichas()) {
                if (ficha != null) {
                    agregarFichaAlPanel(ficha);
                }
            }
        }

        setLocationRelativeTo(null);

    }

    private void inicializarPaneles() {
        layeredPane = new JLayeredPane();
        setContentPane(layeredPane);

        tableroPanel = new TableroPanel(null, null);
        tableroPanel.setBounds(0, 0, 1200, 700);
        layeredPane.add(tableroPanel, JLayeredPane.DEFAULT_LAYER);

        botonesPanel = new JPanel(new FlowLayout());
        botonesPanel.setVisible(false);
        layeredPane.add(botonesPanel, JLayeredPane.POPUP_LAYER);

        fichasJugadorPanel = new JPanelWithBackground();
        fichasJugadorPanel.setBounds(100, 550, 960, 120);
        layeredPane.add(fichasJugadorPanel, JLayeredPane.PALETTE_LAYER);

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
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen);
        }
        botonPozo.setBounds(1080, 550, 110, 110);
        layeredPane.add(botonPozo, JLayeredPane.PALETTE_LAYER);

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
                    mostrarBotonesSeleccion(fichaLabel);
                }
            });

            fichasJugadorPanel.add(fichaLabel);
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen);
        }
    }

    private void mostrarBotonesSeleccion(JButton fichaLabel) {
        botonesPanel.removeAll();

        botonesPanel.setBounds(fichaLabel.getX(), fichaLabel.getY() + 20, 200, 50);
        botonesPanel.setBackground(Color.LIGHT_GRAY);

        botonesPanel.setLayout(new FlowLayout());

        // Botones para los extremos
        JButton botonExtremo1 = new JButton("Extremo 1");
        botonExtremo1.addActionListener(e -> mostrarBotonesDireccion(true));
        botonesPanel.add(botonExtremo1);

        JButton botonExtremo2 = new JButton("Extremo 2");
        botonExtremo2.addActionListener(e -> mostrarBotonesDireccion(false));
        botonesPanel.add(botonExtremo2);

        botonesPanel.setVisible(true);
        botonesPanel.revalidate();
        botonesPanel.repaint();
        layeredPane.moveToFront(botonesPanel);
    }

    private void mostrarBotonesDireccion(boolean extremoIzquierdo) {
        botonesPanel.removeAll();
        // Botones para seleccionar dirección
        String[] direcciones = {"Arriba", "Abajo", "Izquierda", "Derecha"};
        for (String direccion : direcciones) {
            JButton botonDireccion = new JButton(direccion);

            botonDireccion.addActionListener(e -> ejectutarPonerFicha(new PonerFichaDto(fichaSeleccionada, extremoIzquierdo, direccion)));
            botonesPanel.add(botonDireccion);
        }
        botonesPanel.setVisible(true);
        botonesPanel.revalidate();

        botonesPanel.repaint();
    }

    @Override
    public void setMediador(IMediador mediadorp) {
        mediador = mediadorp;
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

        private int[][] tablero;
        private List<PonerFichaDto> fichasTablero;
        private final ImageIcon fondoImagen;

        public TableroPanel(ArregloDto array, List<PonerFichaDto> fichasTableroP) {
            if (array == null || array.getTablero() == null) {
                this.tablero = new int[10][10];
                this.fichasTablero = new ArrayList<>();
            } else {
                this.fichasTablero = fichasTableroP;
                this.tablero = array.getTablero();
            }
            this.fondoImagen = new ImageIcon(getClass().getResource("/imgPartidaFichas/imagenFondo.png"));
            setPreferredSize(new Dimension(1200, 700));
        }

        @Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int cellSize = 50;

        // Dibujar matriz
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                g2d.setColor(Color.YELLOW);
                g2d.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g2d.setColor(Color.GREEN);
                g2d.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);

                if (tablero[i][j] != 0) {
                    g2d.setColor(Color.BLUE);
                    g2d.drawString(String.valueOf(tablero[i][j]), j * cellSize + 20, i * cellSize + 30);
                }
            }
        }

        // Dibujar piezas
        Color[] colors = {Color.CYAN, Color.GREEN, Color.PINK, Color.YELLOW, Color.MAGENTA};
        for (int idx = 0; idx < fichasTablero.size(); idx++) {
            PonerFichaDto ficha = fichasTablero.get(idx);
            int fila = ficha.getFila();
            int columna = ficha.getColumna();
            String orientacion = ficha.getDireccion();
            int lado1 = ficha.getFicha().getLado1();
            int lado2 = ficha.getFicha().getLado2();
            int[] lados = {lado1, lado2};
            g2d.setColor(colors[idx % colors.length]);

            if (orientacion.equals("vertical")) {
                g2d.fillRect(columna * cellSize, fila * cellSize, cellSize, cellSize * 2);
            } else if (orientacion.equals("horizontal")) {
                g2d.fillRect(columna * cellSize, fila * cellSize, cellSize * 2, cellSize);
            }

            g2d.setColor(Color.BLUE);
            g2d.drawRect(columna * cellSize, fila * cellSize, cellSize, orientacion.equals("vertical") ? cellSize * 2 : cellSize);
            g2d.drawString(String.valueOf(lados[0]), columna * cellSize + 20, fila * cellSize + 30);
            if (orientacion.equals("vertical")) {
                g2d.drawString(String.valueOf(lados[1]), columna * cellSize + 20, (fila + 1) * cellSize + 30);
            } else {
                g2d.drawString(String.valueOf(lados[1]), (columna + 1) * cellSize + 20, fila * cellSize + 30);
            }
        }
    }
    }

    private class Actualizar implements IObserver {

        @Override
        public void actualizar() {
            ArregloDto nuevoArray = model.getArray();
            List<PonerFichaDto> nuevasFichas = model.getFichasTablero();
            if (nuevoArray != null) {
                tableroPanel.tablero = nuevoArray.getTablero();
                tableroPanel.fichasTablero = nuevasFichas;
            }
            tableroPanel.revalidate();
            tableroPanel.repaint();

            JLabel avatarJugador = new JLabel();
            String rutaImagen2 = String.format("/imgPartidaFichas/avatar%d.png", model.getJugador().getAvatar());
            URL recurso2 = getClass().getResource(rutaImagen2);
            if (recurso2 != null) {
                ImageIcon icono2 = new ImageIcon(recurso2);
                avatarJugador.setIcon(icono2);
            } else {
                System.err.println("Imagen no encontrada para: " + rutaImagen2);
            }
            avatarJugador.setBounds(0, 550, 110, 110);
            layeredPane.add(avatarJugador, JLayeredPane.PALETTE_LAYER);

            JLabel nombreJugador = new JLabel();

            nombreJugador.setText(model.getJugador().getNombre());

            avatarJugador.setBounds(0, 250, 110, 110);
            layeredPane.add(nombreJugador, JLayeredPane.PALETTE_LAYER);

            JLabel avatarJugadorContrincante = new JLabel();
            String rutaImagen3 = String.format("/imgPartidaFichas/avatar%d.png", model.getCompañeros().get(0).getAvatar());
            URL recurso3 = getClass().getResource(rutaImagen3);
            if (recurso3 != null) {
                ImageIcon icono3 = new ImageIcon(recurso3);
                avatarJugadorContrincante.setIcon(icono3);
            } else {
                System.err.println("Imagen no encontrada para: " + rutaImagen2);
            }
            avatarJugador.setBounds(550, 50, 110, 110);
            layeredPane.add(avatarJugadorContrincante, JLayeredPane.PALETTE_LAYER);

            JLabel nombreJugadorContrincante = new JLabel();

            nombreJugadorContrincante.setText(model.getCompañeros().get(0).getNombre());

            avatarJugador.setBounds(550, 0, 110, 110);
            layeredPane.add(nombreJugador, JLayeredPane.PALETTE_LAYER);

            fichasJugadorPanel.removeAll();
            for (FichaDto ficha : model.getJugador().getFichas()) {
                agregarFichaAlPanel(ficha);
            }
            
            nombreJugador.setBounds(550, 20, 110, 110);
            layeredPane.add(nombreJugador, JLayeredPane.PALETTE_LAYER);
            fichasJugadorPanel.revalidate();
            fichasJugadorPanel.repaint();
            
        }
    }
    

    public void agregarObserverPonerFicha(IEventoPonerFicha eventoPonerFicha) {
        this.eventoPonerFicha = eventoPonerFicha;

    }

    public void ejectutarPonerFicha(PonerFichaDto ponerFicha) {
        if (this.eventoPonerFicha != null) {
            eventoPonerFicha.ponerFicha(ponerFicha);
            botonesPanel.setVisible(false);
        }
    }
}
