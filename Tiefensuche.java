public class Tiefensuche {

        // startet die Tiefensuche
        public static void Tiefensuche(int[][] matrix, int start) {
            boolean[] besucht = new boolean[matrix.length];

            System.out.println("Tiefensuche Reihenfolge:\n");

            TiefensucheRekursiv(matrix, start, besucht);

            System.out.println();
        }

        //Rekursive Methode für die Tiefensuche
        public static void TiefensucheRekursiv(int[][] matrix, int knoten, boolean[] besucht) {
            // aktuellen Knoten als besucht markieren
            besucht[knoten] = true;
            System.out.println(knoten + " ");

            for (int i = 0; i < matrix.length; i++) {
            // Rekursiver Aufruf für alle noch nicht besuchten Nachbarn
                if (matrix[knoten][i] != 0 && !besucht[i]) {
                    TiefensucheRekursiv(matrix, i, besucht);
                }
            }
        }
    }
