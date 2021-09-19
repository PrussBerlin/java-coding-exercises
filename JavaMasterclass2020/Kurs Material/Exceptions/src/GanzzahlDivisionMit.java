import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Einfaches Programm fuer das Auffangen und Behandeln von Ausnahmen.
 *
 * @author S. Kaltofen
 * @version 2.5, 03/2012
 */
public class GanzzahlDivisionMit {
    public static void main(String[] args) {

        int ganz1, ganz2;
        System.out.println("Ausnahmebehandlung am Beispiel der Division\n");
        // Scanner-Klasse fuer die Standardeingabe erzeugen
        Scanner scan = new Scanner(System.in);
        try {
            // 1. int-Wert von der Konsole einlesen
            System.out.print("1. ganze Zahl: ");
            ganz1 = scan.nextInt();
            // 2. int-Wert von der Konsole einlesen
            System.out.print("\n2. ganze Zahl: ");
            ganz2 = scan.nextInt();
            System.out.println("\nErgebnis der Division: " + ganz1 / ganz2);
        } catch (InputMismatchException e) {
            System.out.println("Das war keine korrekte ganze Zahl");
        } catch (ArithmeticException e) {
            System.out.println("Die 2. Zahl ist 0.");
            System.out.println("Division durch 0 ist nicht ausfuehrbar!");
        } finally {
            System.out
                    .println("Anweisungen im finally-Block werden immer ausgefuehrt.");
        }
    } // main
} // class GanzzahlDivisionMit