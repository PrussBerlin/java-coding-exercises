public class NumberToWords {

    public static void numberToWords(int number) {
        if(number < 0) {
            System.out.println("Invalid Value");
        } else if(number==0) {
            System.out.println("Zero");
        } else {
            int tmp = number;
            number = reverse(number);
            int lastDigit;

            while(number>0) {
                lastDigit = number % 10;
               switch(lastDigit) {
                   case 0:
                       System.out.println("Zero");
                       break;
                   case 1:
                       System.out.println("One");
                       break;
                   case 2:
                       System.out.println("Two");
                       break;
                   case 3:
                       System.out.println("Three");
                       break;
                   case 4:
                       System.out.println("Four");
                       break;
                   case 5:
                       System.out.println("Five");
                       break;
                   case 6:
                       System.out.println("Six");
                       break;
                   case 7:
                       System.out.println("Seven");
                       break;
                   case 8:
                       System.out.println("Eight");
                       break;
                   case 9:
                       System.out.println("Nine");
                       break;
                   default:
                       System.out.println("Zero");
                }
                number /= 10;
            }
            for(int i = getDigitCount(reverse(tmp)); i < getDigitCount(tmp); i++) {
                System.out.println("Zero");
            }
        }
    }

    public static int reverse(int number){
        boolean wasNegative = false;

        while(number<0) {
            number *= (-1);
            wasNegative = true;
            break;
        }
        int reversed = 0;
        int lastDigit = 0;
        while(number>0) {

            lastDigit = number % 10;
            reversed *= 10;
            reversed += lastDigit;
            number /= 10;

        } if(wasNegative) {
            return reversed*(-1);
        } else {
            return reversed;
        }

    }

    public static int getDigitCount(int number) {
        if(number<0) {
            return -1;
        } else if(number < 10) {
            return 1;
        } else {
            int i = 0;
            while(number>0) {
                number /= 10;
                i++;
            } return i;
        }
    }

    public static void main(String[] args) {
        numberToWords(900);
        //System.out.println(getDigitCount(0));
        //System.out.println(reverse(-122));
        //System.out.println(reverse(-123456));
    }
}
