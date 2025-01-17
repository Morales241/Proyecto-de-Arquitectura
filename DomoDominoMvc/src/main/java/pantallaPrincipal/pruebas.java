package pantallaPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;

/**
 *
 * @author tacot
 */
public class pruebas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scroll Horizontal con JLabels");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 150);

            JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            // Agregar botones con imágenes
            for (int i = 0; i <= 0; i++) {
                for (int j = i; j < 1; j++) {
                    JButton etiquetaAux = new JButton();

                    // Intentar cargar la imagen correctamente
                    ImageIcon icon = new ImageIcon("/Botones/aceptar.png"); // Verifica la ruta y la extensión
                    etiquetaAux.setIcon(icon);

                    etiquetaAux.setBorderPainted(false);
                    subPanel.add(etiquetaAux);
                }
            }

            subPanel.setPreferredSize(new Dimension(1000, 50));

            JScrollPane scrollPane = new JScrollPane(subPanel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

            frame.add(scrollPane);
            frame.setVisible(true);
        });
    }
}
