public class LastDigitChecker {

    public static boolean hasSameLastDigit(int a, int b, int c) {
        if(a<10 || b<10 || c<10 || a>1000 || b>1000 || c>1000) {
            return false;
        } else {
            int rightMostA = a % 10;
            int rightMostB = b % 10;
            int rightMostC = c % 10;
            if(rightMostA == rightMostB || rightMostA == rightMostC || rightMostB == rightMostC) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isValid(int a) {
        if(a>=10 && a<=1000) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(12, 28, 34));
    }
}
