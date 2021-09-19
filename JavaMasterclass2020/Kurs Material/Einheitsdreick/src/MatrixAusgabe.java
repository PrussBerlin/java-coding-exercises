import java.util.Random;

/**
 * Programm zum Fuellen einer zweidimesionalen Reihung mit Zufallszahlen und
 * matrixgerechter Ausgabe am Bildschirm
 *
 * @author G. Goerlitz; Fabio Bacigalupo
 * @version 1.0, 01/2001
 */
public class MatrixAusgabe {

    private int anzZeilen;
    private int anzSpalten;
    private int[][] matrix;

    public MatrixAusgabe(int anzZeilen, int anzSpalten) {
        matrix = new int[anzZeilen][anzSpalten];
        this.anzZeilen = anzZeilen;
        this.anzSpalten = anzSpalten;
    }

    /**
     * accessor anzZeilen
     *
     * @return Anzahl Zeilen
     */
    public int getAnzZeilen() {
        return anzZeilen;
    }

    /**
     * accessor anzSpalten
     *
     * @return Anzahl Spalten
     */

    public int getAnzSpalten() {
        return anzSpalten;
    }

    /**
     * einlesen: Liest Zufallszahlen zwischen 0 und 9 in die Matrix ein
     */
    public void einlesen() {
        Random generator = new Random();
        for (int i = 0; i < anzZeilen; ++i) {
            for (int j = 0; j < anzSpalten; ++j) {
                matrix[i][j] = generator.nextInt(10);
            }
        }
    }

    /**
     * ausgeben: Gibt die Reihung matrixgerecht am Bildschirm aus
     */
    public void ausgeben() {
        for (int k = 0; k < anzZeilen; ++k) {
            for (int l = 0; l < anzSpalten; ++l) {
                System.out.print(matrix[k][l] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * ausgeben: Gibt die Reihung matrixgerecht am Bildschirm aus
     */
    public void ausgebenA() {
        // mit Benutzung von length
        for (int k = 0; k < matrix.length; ++k) {
            for (int l = 0; l < matrix[k].length; ++l) {
                System.out.print(matrix[k][l] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * ausgeben: Gibt die Reihung matrixgerecht am Bildschirm aus
     */
    public void ausgebenB() {
        // neue Schleife seit Java 5.0
        for (int[] zeile : matrix) {
            for (int zahl : zeile) {
                System.out.print(zahl + "\t");
            }
            System.out.println("");
        }
    }
}