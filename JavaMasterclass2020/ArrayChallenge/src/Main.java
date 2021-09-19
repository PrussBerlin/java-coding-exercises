import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] arrayToBeSorted;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How many numbers you want to sort?\r");
        arrayToBeSorted = getIntegers(scanner.nextInt());
        System.out.println("Your array:");
        printArray(arrayToBeSorted);
        System.out.println("Sorted:");
        printArray(sortIntegerArray(arrayToBeSorted));
    }

    public static int[] getIntegers(int totalNumbers) {
        arrayToBeSorted = new int [totalNumbers];
        System.out.println("Please Type the numbers to Sort, abort by typing any letter:\r");

        for(int i = 0; i < arrayToBeSorted.length; i++) {

            arrayToBeSorted[i] = scanner.nextInt();
        }
        return arrayToBeSorted;
    }

    public static void printArray(int[] arrayToPrint) {

        for(int i = 0; i < arrayToPrint.length; i++) {

            System.out.print(arrayToPrint[i] + "|");
        }
        System.out.println();
    }

    public static int[] sortIntegerArray(int[] arrayToBeSorted) {

        int[] sortedArray = Arrays.copyOf(arrayToBeSorted, arrayToBeSorted.length);
        int tmp;
        boolean flag = true;

        while(flag) {
            flag = false;
            for(int i = 0; i < arrayToBeSorted.length-1; i++) {
                if(sortedArray[i] < sortedArray[i+1]) {
                    tmp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = tmp;
                    flag = true;
                }
            }
        }
        scanner.close();
        return sortedArray;
    }
}
