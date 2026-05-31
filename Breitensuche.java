import java.util.LinkedList;
import java.util.Queue;

//Breitensuche (Abkürzung: Breadth First Search)
// besucht zuerst alle direkten Nachbarn eines Knoten
public class Breitensuche {

    // führt eine Breitensuche ab dem angegeben Startknoten durch
    public static void Breitensuche(int[][] matrix, int start) {
        int n = matrix.length;

        boolean[] besucht = new boolean[n];

        // Warteschlange für die Breitensuche
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        besucht[start] = true;

        System.out.println("Breitensuche Reihenfolge:\n");

        // solange sich noch Knoten in der Warteschlange befinden
        while (!queue.isEmpty()) {
            int aktuell = queue.remove();
            System.out.println(aktuell + " ");

            for (int i = 0; i < n; i++) {
            // noch nicht besuchte Nachbarn zur Warteschlange hinzufügen
                if (matrix[aktuell][i] != 0 && !besucht[i]) {
                    queue.add(i);
                    besucht[i] = true;
                }
            }
        }
        System.out.println();
    }
}
