
/**
 * Zeigt, wie die in der Kommandozeile
 * angegebenen Parameter auf dem Bildschirm
 * ausgegeben werden koennen.
 *
 * @author A. Schmidt
 * @version 1.0, 01/2001
 */

public class Args {
    public static void main(String[] args) {
        // Ausgeben der erhaltenen Kommandozeilenparameter
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}