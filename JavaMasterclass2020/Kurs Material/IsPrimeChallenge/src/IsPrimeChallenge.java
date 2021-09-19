public class IsPrimeChallenge {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 0; i <= 53; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println("Number " + i + " is Prime Number");
                if(count == 4) {
                    System.out.println("Exiting For Loop");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {

        if(n < 2) {
            return false;
        }

        for(int i=2; i <= (long) Math.sqrt(n); i++) {
            System.out.println("Looping " + i);
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
