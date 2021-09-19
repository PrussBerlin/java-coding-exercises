public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second) {
        if(first<10 || second<10) {
            return -1;
        } else {
            int ggT = 1;
            for(int i = 2; i <= first; i++) {
                if((first%i)==0 && (second%i)==0) {
                    ggT = i;
                } else continue;
            } return ggT;
        }
    }


    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(360, 12));
    }
}
