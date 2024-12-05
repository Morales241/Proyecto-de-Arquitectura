package TableroMvc;

import dtos.ArregloDto;
import dtos.FichaDto;
import eventos.PonerFichaDto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import mediador.IComponente;
import mediador.IMediador;
import observers.IEventoPedirFichaAlPozo;
import observers.IEventoPonerFicha;
import observers.IEventoValidarFichas;
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
    private JButton botonPozo;
    private IEventoValidarFichas eventoValidarFichas;
    private IEventoPedirFichaAlPozo eventoTomarFichaDelPozo;
    
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
        layeredPane.add(botonesPanel, JLayeredPane.POPUP_LAYER);
        
        fichasJugadorPanel = new JPanelWithBackground();
        fichasJugadorPanel.setBounds(100, 550, 960, 120);
        layeredPane.add(fichasJugadorPanel, JLayeredPane.PALETTE_LAYER);
        
        botonPozo = new JButton();
        botonPozo.setEnabled(false);
        botonPozo.addActionListener(l -> ejecutarObserverValidarFichas(null));
        
        
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
            
            if (model.isTurno()) {
                
                fichaLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        fichaSeleccionada = ficha;
                        mostrarBotonesSeleccion(fichaLabel);
                    }
                });
            }
            
            fichasJugadorPanel.add(fichaLabel);
        } else {
            System.err.println("Imagen no encontrada para: " + rutaImagen);
        }
    }
    
    private void mostrarBotonesSeleccion(JButton fichaLabel) {
        botonesPanel.removeAll();
        
        botonesPanel.setOpaque(false);
        
        botonesPanel.setBounds(450, 490, 200, 60);
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
        
        botonesPanel.setOpaque(false);
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
    Graphics2D g2d = (Graphics2D) g.create();

    int cellWidth = 40;
    int cellHeight = 40;

    int rows = tablero.length;
    int cols = tablero[0].length;

    int panelWidth = getWidth();
    int panelHeight = getHeight();
    int tableroWidth = cols * cellWidth;
    int tableroHeight = rows * cellHeight;

    int offsetX = (panelWidth - tableroWidth) / 2;
    int offsetY = (panelHeight - tableroHeight) / 2;

    g.drawImage(fondoImagen.getImage(), 0, 0, getWidth(), getHeight(), this);

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            int valor = tablero[i][j];
            if (valor != -1) {  
                int lado1 = valor / 10;
                int lado2 = valor % 10;

                String rutaImagen;
                if (lado1 == lado2) {
                    rutaImagen = String.format("/imgPartidaFichas/fichaMula%d.png", lado1);
                } else {
                    rutaImagen = String.format("/imgPartidaFichasSeparadas/ficha_%d.png", valor);
                }

                URL recurso = getClass().getResource(rutaImagen);

                if (recurso != null) {
                    ImageIcon fichaIcono = new ImageIcon(recurso);

                    g2d.translate(offsetX + j * cellWidth + cellWidth / 2.0, offsetY + i * cellHeight + cellHeight / 2.0);

                    g2d.drawImage(fichaIcono.getImage(), -cellWidth / 2, -cellHeight / 2, cellWidth, cellHeight, this);

                    g2d.translate(-(offsetX + j * cellWidth + cellWidth / 2.0), -(offsetY + i * cellHeight + cellHeight / 2.0));
                }
            }
        }
    }

    g2d.dispose();
}
}
    
    private class Actualizar implements IObserver {
        
        @Override
        public void actualizar() {
            
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
            
            ArregloDto nuevoArray = model.getArray();
            if (nuevoArray != null) {
                tableroPanel.tablero = nuevoArray.getTablero();
            }
            tableroPanel.repaint();
            
            fichasJugadorPanel.removeAll();
            for (FichaDto ficha : model.getJugador().getFichas()) {
                agregarFichaAlPanel(ficha);
            }
            
            layeredPane.add(nombreJugador, JLayeredPane.PALETTE_LAYER);
            fichasJugadorPanel.revalidate();
            fichasJugadorPanel.repaint();
            
            if (!model.isTurno()) {
                
                for (Component component : fichasJugadorPanel.getComponents()) {
                    
                    if (component instanceof JButton button) {
                        button.setEnabled(false);
                        
                    }
                }
            }
            
            if (!model.isPozo()) {
                
                botonPozo.setEnabled(true);
                botonPozo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ejecutarObserverTomarFichaDelPozo();
                    }
                });
                
            }
        }
        
    }
         public void agregarObserverTomarFichaDelPozo(IEventoPedirFichaAlPozo eventoTomarFichaDelPozo) {
        this.eventoTomarFichaDelPozo = eventoTomarFichaDelPozo;
    }
        
        public void ejecutarObserverTomarFichaDelPozo() {
        if (eventoTomarFichaDelPozo != null) {
            eventoTomarFichaDelPozo.pedirFicha();
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
    
    public void agregarObserverValidarFichas(IEventoValidarFichas listener) {
        this.eventoValidarFichas = listener;
    }

    public void ejecutarObserverValidarFichas(List<FichaDto> fichas) {
        if (eventoValidarFichas != null) {
            eventoValidarFichas.validarFichas(fichas);
        }
    }
}