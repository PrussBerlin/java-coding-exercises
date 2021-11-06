import java.util.Scanner;

public class MinMaxChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int min = 0;
        int max = 0;
        boolean firstNumberFlag = true;

            while (true) {

                System.out.println("Enter number between 0 and 999: ");

                boolean isAnInt = scanner.hasNextInt();

                if(isAnInt) {

                int number = scanner.nextInt();
                scanner.nextLine();

                if(firstNumberFlag) {
                        min = number;
                        max = number;
                        firstNumberFlag = false;
                    }

                if (number < min) {
                    min = number;

                } if (number > max) {
                    max = number;
                  }
                } else {
                    System.out.println("min = " + min);
                    System.out.println("max = " + max);
                    break; }
            }


        scanner.close();


    }

    public static void main(String[] args) {
        System.out.println();
    }
}
