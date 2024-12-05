package dtos;

public class ArregloDto {

    private int[][] tablero;
    private int extremoIzquierdo;
    private int extremoDerecha;
    private int extremo1Columna;
    private int extremo1Fila;
    private int extremo2Columna;
    private int extremo2Fila;

    public ArregloDto(int[][] tablero, int extremoIzquierdo, int extremoDerecha,int extremo1Columna, int extremo1Fila,int extremo2Columna, int extremo2Fila) {
        this.tablero = tablero;
        this.extremoIzquierdo = extremoIzquierdo;
        this.extremoDerecha = extremoDerecha;
        this.extremo1Columna = extremo1Columna;
        this.extremo1Fila = extremo1Fila;
        this.extremo2Columna = extremo2Columna;
        this.extremo2Fila = extremo2Fila;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int getExtremoIzquierdo() {
        return extremoIzquierdo;
    }

    public void setExtremoIzquierdo(int extremoIzquierdo) {
        this.extremoIzquierdo = extremoIzquierdo;
    }

    public int getExtremoDerecha() {
        return extremoDerecha;
    }

    public void setExtremoDerecha(int extremoDerecha) {
        this.extremoDerecha = extremoDerecha;
    }

    public int getExtremo1Columna() {
        return extremo1Columna;
    }

    public void setExtremo1Columna(int extremo1Columna) {
        this.extremo1Columna = extremo1Columna;
    }

    public int getExtremo1Fila() {
        return extremo1Fila;
    }

    public void setExtremo1Fila(int extremo1Fila) {
        this.extremo1Fila = extremo1Fila;
    }

    public int getExtremo2Columna() {
        return extremo2Columna;
    }

    public void setExtremo2Columna(int extremo2Columna) {
        this.extremo2Columna = extremo2Columna;
    }

    public int getExtremo2Fila() {
        return extremo2Fila;
    }

    public void setExtremo2Fila(int extremo2Fila) {
        this.extremo2Fila = extremo2Fila;
    }

}
