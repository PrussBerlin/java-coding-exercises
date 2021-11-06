import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        boolean hasNextInt;

        for(int i = 1; i<=10; i++) {

            System.out.println("Enter number " + "#" + i);
            hasNextInt = scanner.hasNextInt();

            if(!hasNextInt) {

                System.out.println("Not a number, please enter again " + "#");
                i--;

            } else {
                sum += scanner.nextInt();
            }
            scanner.nextLine();
        }

        System.out.println("The Sum of the numbers entered = " + sum);

        scanner.close();
    }


}
