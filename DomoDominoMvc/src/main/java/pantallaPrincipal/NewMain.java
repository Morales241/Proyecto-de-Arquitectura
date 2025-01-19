/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pantallaPrincipal;

/**
 *
 * @author tacot
 */
public class NewMain {
    public static void main(String[] args) {
        int[][] tablero = {
            { 1, 1, 3, 3 }, 
            { 2, 2, 5, 5 }, 
            { 4, 4, 6, 6 }
        };

        detectarFichas(tablero);
    }

    public static void detectarFichas(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        boolean[][] visitado = new boolean[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!visitado[i][j]) {
                    int numFicha = matriz[i][j];

                    // Buscar continuación de la ficha (horizontal o vertical)
                    if (j + 1 < columnas && matriz[i][j + 1] == numFicha) {
                        System.out.println("Ficha: (" + numFicha + "," + numFicha + ") " +
                                "Inicio: [" + i + "][" + j + "] " +
                                "Fin: [" + i + "][" + (j + 1) + "]");
                        visitado[i][j] = true;
                        visitado[i][j + 1] = true;
                    } else if (i + 1 < filas && matriz[i + 1][j] == numFicha) {
                        System.out.println("Ficha: (" + numFicha + "," + numFicha + ") " +
                                "Inicio: [" + i + "][" + j + "] " +
                                "Fin: [" + (i + 1) + "][" + j + "]");
                        visitado[i][j] = true;
                        visitado[i + 1][j] = true;
                    }
                }
            }
        }
    }
}
