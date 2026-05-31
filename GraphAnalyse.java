public class GraphAnalyse {

    // Repräsentiert eine unendlich große Distanz,
    // falls zwischen zwei Knoten kein direkter Weg vorhanden ist
    private static final int INF = 999999;

    // 1. Distanzberechnung

    // berechnet die kürzesten Wege zwischen allen Knoten
    public static int[][] distanzMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] dist = new int[n][n];

        // Distanzmatrix initialisieren
        // Direkte Kanten übernehmen, fehlende Kanten als INF markieren
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else
                    if (matrix[i][j] == 0) {
                    dist[i][j] = INF;
                } else {
                    dist[i][j] = matrix[i][j];
                }
            }
        }

        // prüft, für jeden Zwischenknoten,
        // ob dadurch ein kürzerer Weg entsteht
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                // falls der Weg über den Zwischenknoten kürzer ist,
                // wird die Distanz aktualisiert
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        return dist;
    }

    // 2. Exzentrizität

    // berechnet die Exzentrizität jedes Knotens.
    // Die Exzentrizität ist die größte Distanz zu einem anderen Knoten
    public static int[] exzentrizitaet(int[][] dist) {
        int n = dist.length;
        int[] ecc = new int[n];

        for (int i = 0; i < n; i++) {
        // speichert die größte gefundene Distanz
            int max = 0;

            for (int j = 0; j < n; j++) {
                if (dist[i][j] != INF && dist[i][j] > max) {
                    max = dist[i][j];
                }
            }
            ecc[i] = max;
        }
        return ecc;
    }


    // 3. Radius

    // Der Radius ist der kleinste Exzentrizität des Graphen.
    public static int radius(int[] ecc) {
        if (ecc.length == 0) {
            return 0;
        }
        int min = ecc[0];

        for (int i = 1; i < ecc.length; i++) {
            if (ecc[i] < min) {
                min = ecc[i];
            }
        }
        return min;
    }

    // 4. Durchmesser

    // Der Durchmesser ist die größte Exzentrizität des Graphen
    public static int durchmesser(int[] ecc) {
        int max = ecc[0];

        for (int i = 1; i < ecc.length; i++) {
            if (ecc[i] > max) {
                max = ecc[i];
            }
        }
        return max;
    }

    // 5. Zentrum

    // Das Zentrum besteht aus allen Knoten
    // deren Exzentrizität dem Radius entspricht
    public static void zentrum(int[] ecc, int radius) {
        System.out.println("Zentrum:");
        for (int i = 0; i < ecc.length; i++) {
            if (ecc[i] == radius) {
                System.out.println("Knoten " + i);
            }
        }
    }
}