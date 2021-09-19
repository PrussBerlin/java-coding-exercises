public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        if(number < 1) {
            return false;
        } else {
            int sum = 0;
            boolean isPerfect = false;
            for(int i = 1; i < number; i++) {
                if(number % i == 0) {
                    sum += i;
                            if(sum == number) {
                                isPerfect = true;
                            } else {
                                isPerfect = false;
                            }
                } else {
                    continue;
                }
            } return isPerfect;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
    }
}
