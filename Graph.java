public class Graph {

    private int[][] matrix;
    private int anzahlKnoten;

    //Konstruktor: Sie speichert die Matrix und berechnet die Anzahl der Knoten
    public Graph(int[][] matrix) {
        setMatrix(matrix);
        setAnzahlKnoten(matrix.length);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getAnzahlKnoten() {
        return anzahlKnoten;
    }

    public void setAnzahlKnoten(int anzahlKnoten) {
        this.anzahlKnoten = anzahlKnoten;
    }

    // Gibt die Adjazenzmatrix auf der Konsole aus
    public void matrixAusgeben() {
        System.out.println("Adjazenzmatrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
