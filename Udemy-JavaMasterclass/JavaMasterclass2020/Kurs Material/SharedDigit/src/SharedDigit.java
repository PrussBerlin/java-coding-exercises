public class SharedDigit {

    public static boolean hasSharedDigit(int n, int m) {
        if(n < 10 || n > 99 || m < 10 || m > 99) {
            return false;
        } else {
            int lastDigitN = n % 10;
            int lastDigitM = m % 10;
            if(lastDigitN == lastDigitM || lastDigitN == (m/10) || lastDigitM == (n/10) || (n/10) == (m/10)){
            return true;
            } else {
                return false;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 13));
    }
}
