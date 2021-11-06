
/**
 * Hier wird gezeigt, wie String-Objekte vereinbart werden und wie diese
 * initialisiert werden.
 *
 * @author A. Schmidt
 * @version 1.0 01/2001
 */

public class Deklaration01 {
    public static void main(String[] args) {
        // Zuerst generieren wir uns ein paar Hilfsgrössen um unsere
        // String-Objekte
        // zu initialisieren.
        char[] char01 = new char[] { 'S', 't', 'r', 'i', 'n', 'g', ' ', '0',
                '4' };
        byte[] byte01 = new byte[] { 83, 116, 114, 105, 110, 103, 32, 48, 53 };

        // Nun vereinbaren wir ein paar String-Objekte und initialisieren diese
        // auf unterschiedliche Weise.
        String str01 = "String 01"; // mit einem String-Literal ohne new
        String str02 = new String("String 02"); // mit einem String-Literal mit
        // new
        String str03 = new String(char01); // mit einer Reihung von char
        String str04 = new String(byte01); // mit einer Reihung von byte
        String str05 = new String(str01); // mit einem andem String

        // Ausgeben der String-Objekte auf dem Bildschirm.
        System.out.println("1) Inhalt String 01 \t= " + str01);
        System.out.println("2) Inhalt String 02 \t= " + str02);
        System.out.println("3) Inhalt String 03 \t= " + str03);
        System.out.println("4) Inhalt String 04 \t= " + str04);
        System.out.println("5) Inhalt String 05 \t= " + str05);
    }
}