
public class Main {
    public static void main(String[] args) {

        //CSV-Datei wird eingelesen und als Matrix gespeichert
        int[][] matrix = CSVReader.readFile("src/graph.csv");
        if (matrix.length == 0) {
            System.out.println("Matrix ist leer, Datei nicht gefunden oder falsch!");
            return;
        }

        // Graph-Objekt wird erstellt
        Graph graph = new Graph(matrix);

        //Adjazenzmatrix wird ausgegeben
        graph.matrixAusgeben();

        //Distanzmatrix berechnen
        int[][] distanz = GraphAnalyse.distanzMatrix(matrix);
        System.out.println("Distanzmatrix:\n");

        for (int i = 0; i < distanz.length; i++) {
            for (int j = 0; j < distanz[i].length; j++) {
                if (distanz[i][j] == 999999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distanz[i][j] + " ");
                }
            }
            System.out.println();
        }

        // Exzentrizität berechnen
        int[] ecc = GraphAnalyse.exzentrizitaet(distanz);

        System.out.println("Exzentrizität:\n");
        for (int i = 0; i < ecc.length; i++) {
            System.out.println("Knoten " + i + ": " + ecc[i]);
        }

        // Radius und Durchmesser berechnen
        int radius = GraphAnalyse.radius(ecc);
        int durchmesser = GraphAnalyse.durchmesser(ecc);

        System.out.println("Radius:\n" + radius);
        System.out.println("Durchmesser: " + durchmesser);

        //Zentrum
        GraphAnalyse.zentrum(ecc, radius);

        // Breitensuche ab Knoten 0
        Breitensuche.Breitensuche(matrix, 0);
        // Tiefensuche ab Knoten 0
        Tiefensuche.Tiefensuche(matrix, 0);
        // Dijkstra kürzeste Wege ab Startknoten
        Dijkstra.shortestPath(matrix, 0);
    }
}