
/**
 * Prueft, ob die in der Kommandozeile angegebenen Parameter ausreichen
 *
 * @author Fabio Bacigalupo
 * @version 1.0, 12/2002
 */

public class ArgsUsage {
    public static void main(String[] args) {
        // Anzahl der uebergebenen Argumente
        int anzArgumente = args.length;
        switch (anzArgumente) {
            case 3: {
                // Ausgeben der erhaltenen Kommandozeilenparameter
                for (int i = 0; i < args.length; i++) {
                    System.out.println(args[i]);
                }
                break;
            }
            default: {
                System.out.println("Usage: ArgsUsage Param1 Param2 Param3");
                break;
            }
        }
    }
}