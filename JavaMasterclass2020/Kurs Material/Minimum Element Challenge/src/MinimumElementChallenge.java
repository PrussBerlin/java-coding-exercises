import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter count: ");
        int[] array = readIntegers(scanner.nextInt());
        System.out.println(Arrays.toString(array));

        System.out.println("Min= " + findMin(array));
        scanner.close();
    }

    private static int[] readIntegers(int count) {

        int[] allTheNumbers = new int[count];

        System.out.println("Please enter " + count + " Integers:\r");

        for(int i = 0; i < count; i++) {
            allTheNumbers[i] = scanner.nextInt();
        }
        return allTheNumbers;

    }

    private static int findMin(int[] array) {

        int min = array[0];

        for(int i = 1; i < array.length; i++) {

            if (array[i]<min) {
                min = array[i];
            }
        }
        return min;
    }


}
