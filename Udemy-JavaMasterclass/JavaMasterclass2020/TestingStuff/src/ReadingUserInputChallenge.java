import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for(int i = 1; i <= 10; i++) {

            System.out.println("Enter number #" + i);

            if(scanner.hasNextInt()) {
                sum += scanner.nextInt();

            } else {
                System.out.println("Invalid number");
                i--;
            }

            scanner.nextLine();
        }
        System.out.println("sum = " + sum);
        scanner.close();
    }
}
