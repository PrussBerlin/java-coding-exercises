import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Deklarieren, Ausloesen und Behandeln einer eigenen Ausnahme.
 *
 * @author S. Kaltofen
 * @version 1.6, 08/2012
 */
public class EigeneAusnahme {
    /* Vereinbarung einer eigenen Ausnahmeklasse als innere Klasse */
    static class ZahlIstDreizehn extends Exception {
        // static notwendig, weil diese Klasse von der static Klasse Einlesen
        // benutzt wird
        public ZahlIstDreizehn(String s) {
            super(s);
        }
    } // Ende class ZahlIstDreizehn

    public static class Einlesen {
        // static notwendig, weil diese Klasse von der static Methode main
        // benutzt wird
        /**
         * liest eine Zahl ausser 13 von der Tastatur und liefert diese als
         * Ergebnis. Wenn 13 gelesen wird eine Ausnahme vom Typ ZahlIstDreizehn
         * geworfen
         *
         * @return die eingegebene Zahl.
         * @throws ZahlIstDreizehn
         *             wenn die eingegebene Zahl 13 ist.
         */
        public static int liesEineZahl() throws ZahlIstDreizehn {
            int ganz;
            Scanner scan = new Scanner(System.in);
            ganz = scan.nextInt();
            // falls die eingelesene Zahl 13 ist, dann die eigene Ausnahme
            // werfen
            if (ganz == 13)
                throw new ZahlIstDreizehn("Verflixte 13!");
            return ganz;
        } // Ende Methode liesEineZahl
    } // Ende class Einlesen

    /**
     * main-Methode: Einlesen, evtl. Ausnahme werfen und behandeln
     *
     * @param args
     *            die ueblichen Argumente der main Methode
     */
    public static void main(String[] args) {
        int zahl;
        System.out
                .println("Programm wirft die eigene Ausnahme bei Eingabe der Zahl 13");
        System.out.print("Eingabe einer ganzen Zahl: ");
        try {
            zahl = Einlesen.liesEineZahl();
            // Einlesen ist die kritische Anweisung
        } // Behandlung der Ausnahmen:
        catch (EigeneAusnahme.ZahlIstDreizehn e) {
            // catch (ZahlIstDreizehn e) {
            // auch moeglich, da die main Methode innerhalb der Klasse
            // EigeneAusnahme ist
            System.out.println("Meine Exception trat auf: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Das war keine korrekte ganze Zahl");
        }
    } // Ende main
} // Ende class EigeneAusnahme