import java.util.Scanner;

public class InputCalculator {

        public static void inputThenPrintSumAndAverage() {

            Scanner scanner = new Scanner(System.in);

            int sum = 0;
            long avarage;
            int counter = 0;

            while(true) {

                boolean isAnInt = scanner.hasNextInt();

                if (isAnInt) {

                    sum += scanner.nextInt();
                    counter++;

                } else {

                    avarage = Math.round((double)sum/(double)counter);
                    System.out.println("SUM = " + sum + " AVG = " + avarage);

                    break;
                }

                scanner.nextLine();

            }

            scanner.close();
        }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
