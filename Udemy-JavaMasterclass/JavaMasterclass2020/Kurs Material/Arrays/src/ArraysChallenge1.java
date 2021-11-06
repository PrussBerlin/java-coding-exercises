import java.util.Scanner;

public class ArraysChallenge1 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How many numbers do you want to enter?");
        int a = scanner.nextInt();
        int[] array = getIntegers(a);
        System.out.print("Your numbers: ");
        printArray(array);
        System.out.print("your numbers sorted: ");
        printArray(sortIntegers(array));


    }

    public static int[] getIntegers(int capacity) {

        int[] values = new int[capacity];
        System.out.println("Enter " + capacity + " integer values.\r");
        for (int i = 0; i < values.length; i++) {
            System.out.print("#"+ (i+1) + " ");
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] sortIntegers(int[] array) {

        boolean flag = true;
        int tmp;

        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] < array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    flag = true;
                }
            }
        }
        return array;
    }
}
