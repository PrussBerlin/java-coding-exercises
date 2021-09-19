public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        //make negative number positive (Betrag)
        if(number < 0) {
            number *= (-1);
        }
        //reverse variable, um später zu vergleichen
        int num = number;
        int reverse = 0;

        while(num > 0) {

            int lastDigit = num % 10;
            reverse *= 10;
            System.out.println(reverse);
            reverse += lastDigit;
            num /= 10;
        }
        if(number == reverse) {
            return true;
        } else {
            return false;
        }

    }
}
