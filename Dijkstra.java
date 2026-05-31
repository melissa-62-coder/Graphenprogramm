// Dijkstra-Algorithmus:
// berechnet die kürzesten Wege von einem Startknoten
// zu allem anderen Knoten

public class Dijkstra {

    private static final int INF = 9999999;

    // berechnet die kürzesten Distanzen vom Startknoten
    public static void shortestPath(int[][] matrix, int start) {
        int n = matrix.length;

        int[] dist = new int[n];
        boolean[] besucht = new boolean[n];

        // alle Distanzen zunächst auf unendlich setzen
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            besucht[i] = false;
        }
        // Distanz vom Startknoten zu sich selbst ist 0
        dist[start] = 0;

        for (int anzahl = 0; anzahl < n - 1; anzahl++) {
        // nächsten Knoten mit der kleinsten Distanz auswählen
            int u = minDist(dist, besucht);
            besucht[u] = true;

            for (int v = 0; v < n; v++) {
            // prüft, ob über den aktuellen Knoten ein kürzerer Weg vorhanden ist
                if (!besucht[v] &&
                matrix[u][v] != 0 &&
                dist[u] != INF &&
                dist[u] + matrix[u][v] < dist[v]) {

                    dist[v] = dist[u] + matrix[u][v];
                }
            }
        }
        System.out.println("Dijkstra der kürzeste Wege von Knoten " + start + ":");

        for (int i = 0; i < n; i++) {
            System.out.println("Knoten " + i + ": " + dist[i]);
        }
    }

    // sucht den noch nicht besuchten Knoten
    // mit der kleinsten bekannten Distanz
    private static int minDist(int[] dist, boolean[] besucht) {
        int min = 999999;
        int index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!besucht[i] && dist[i] <= min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
