public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {

        if(number<0) {
            return -1;

        } else if(number < 10) {

           return number *= 2;

        } else {

            int lastDigit = number % 10;

            while(number > 9) {
                number /= 10;
            }
            return number+lastDigit;
        }
    }

    public static void main(String[] args) {
        //System.out.println(sumFirstAndLastDigit(95674));
        //System.out.println(2/10);
        int number =65748;
        int length = (Integer.toString(number).length()) -1 ;
        length = (int ) Math.pow(10, length);
        System.out.println("length = " + length);
        int firstDigit = number/length;
        System.out.println("first digit = " + firstDigit);

        String bsp = "6";
        System.out.println(bsp);
        bsp += "5";
        System.out.println(bsp);

        int lastdigit = number % 10;
        System.out.println("last digit " + lastdigit);
        number /=10;
        lastdigit = number % 10;
        System.out.println("last digit " + lastdigit);

     //   while(number>9) {
      //      number /= 10;
       //     System.out.println(number);
        //}
    }

}
