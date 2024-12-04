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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.net.URL;
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

        tableroPanel = new TableroPanel(null);
        tableroPanel.setBounds(0, 0, 1200, 700);
        layeredPane.add(tableroPanel, JLayeredPane.DEFAULT_LAYER);

        botonesPanel = new JPanel(new FlowLayout());
        botonesPanel.setVisible(false);
        layeredPane.add(botonesPanel, JLayeredPane.DEFAULT_LAYER);

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

        JLabel avatarJugador = new JLabel();
        String rutaImagen2 = "/imgPartidaFichas/avatar1.png";
        URL recurso2 = getClass().getResource(rutaImagen2);
        if (recurso2 != null) {
            ImageIcon icono2 = new ImageIcon(recurso2);
            avatarJugador.setIcon(icono2);
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen2);
        }
        avatarJugador.setBounds(0, 550, 110, 110);
        layeredPane.add(avatarJugador, JLayeredPane.PALETTE_LAYER);
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

        private final int[][] tablero;
        private final ImageIcon fondoImagen;

      public TableroPanel(ArregloDto array) {
    if (array == null || array.getTablero() == null) {
        this.tablero = new int[10][10];
    } else {
        this.tablero = array.getTablero();
    }
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

    private class Actualizar implements IObserver {

        @Override
        public void actualizar() {
            // Aquí puedes actualizar la vista cuando se notifique un cambio en el modelo
            fichasJugadorPanel.removeAll(); // Limpiar el panel
            for (FichaDto ficha : model.getJugador().getFichas()) {
                agregarFichaAlPanel(ficha); // Volver a agregar las fichas
            }
            fichasJugadorPanel.revalidate();
            fichasJugadorPanel.repaint();
            tableroPanel.repaint();
        }

    }

    public void agregarObserverPonerFicha(IEventoPonerFicha eventoPonerFicha) {
        this.eventoPonerFicha = eventoPonerFicha;

    }

    public void ejectutarPonerFicha(PonerFichaDto ponerFicha) {
        if (this.eventoPonerFicha != null) {
            eventoPonerFicha.ponerFicha(ponerFicha);
        }
    }
}
