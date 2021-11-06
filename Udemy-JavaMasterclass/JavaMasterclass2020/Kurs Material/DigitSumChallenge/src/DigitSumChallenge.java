public class DigitSumChallenge {

    public static int sumDigits(int number) {
        if(number<10) {
            return -1;
        }

        int sum = 0;

        while (number > 0) {
            //extract the least significant digit

            int digit = number % 10;
            sum += digit;

            System.out.println("number = " + number + '\n' + "digit = " + digit + '\n' + "sum = " + sum);

            //drop the least sig=nificant digit
            number /= 10; //same as number = number / 10
        }

        return sum;
    }

    public static int sumDigits2(int number) {
        if(number<10) {
            return -1;
        } else {
            int thousand = number / 1000;
            number = number % 1000;
            int hundred = number / 100;
            number = number % 100;
            int tenth = number / 10;
            int ones = number % 10;
            System.out.println("thousand = " + thousand + " hundred = " + hundred + " tenth = " + tenth + " ones = " + ones);
            return thousand + hundred + tenth + ones;
        }
    }

    public static void main(String[] args) {

        System.out.println(sumDigits(12345));
    }
}
