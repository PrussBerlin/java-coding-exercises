public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {
        if(number < 0) {
            return -1;
        } else {

            int lastdigit;
            int sum = 0;

            while(number > 0) {
                lastdigit = number % 10;
                if((lastdigit % 2) == 0){
                    sum += lastdigit;
                    number /= 10;
                } else {
                    number /= 10;
                }
            } return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(1234));
    }
}
