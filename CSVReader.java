import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// Sie liest eine Adjazenzmatrix aus einer CSV-Datei ein.
// Die Werte müssen durch Semikolon getrennt sein.
public class CSVReader {

    // Sie liest die CSV-Datei und erstellt daraus eine zweidimensionale Matrix
    public static int[][] readFile(String filename) {
        ArrayList<int[]> lines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;
            // Datei zeilenweise einlesen
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                // Zeile anhand des Semikolons aufteilen
                String[] parts = line.split(";");
                int[] data = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                // String-Werte in Integer-Werte umwandeln
                    data[i] = Integer.parseInt(parts[i].trim());
                }
                // Die gelesene Zeile zur Liste hinzufügen
                lines.add(data);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Fehler beim Lesen der Datei!");
        }

        int[][] matrix = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i);
        }
        return matrix;
    }
}