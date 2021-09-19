import java.util.Scanner;

public class ReadingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of Birth: ");

        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt) {

            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); //handle enter key issue, needed always after reading a number from scanner

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            int age = 2020 - yearOfBirth;

            if(age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + " and you are " + age + " years old.");
            } else {
                System.out.println("Invalid year of Birth");
            }
        } else {

            System.out.println("Unable to parse year of birth.");
        }

        scanner.close();

    }
}
