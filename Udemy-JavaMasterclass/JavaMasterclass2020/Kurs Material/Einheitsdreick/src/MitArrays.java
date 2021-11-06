
import java.util.Arrays;
public class MitArrays {

    public static int [] [] einheitsDreick(int n) {
        // die obergeordnete Reihung erzeugen
        int  [] [] dreieck = new int  [n] [];
        for (int i =0; i< n ; i++) {
            // jede Elementsreihung erzeugen
            dreieck  [i] = new int [i+1]; // Laenge ist i+1
            for (int j =0; j< i ; j++) {
                dreieck  [i] [j]= 0;
            }
            dreieck  [i] [i]= 1;
        }
        return dreieck;
    }

    public static void ausgeben(int [] [] array){
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        ausgeben(einheitsDreick(5));
        //andere Moeglichekit:
        System.out.println(Arrays.deepToString(einheitsDreick(5)));

    }

}