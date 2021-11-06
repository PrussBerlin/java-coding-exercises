import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Integer> intArrList = new ArrayList<Integer>();
//        Integer myIntValue = 10;
//        int k = 0;
//        for(int i = 0; i <= 10; i++) {
//            intArrList.add(Integer.valueOf(i));
//            k = myIntValue * intArrList.get(i);
//            System.out.println(k);
//        }

        ArrayList<Double> myDoubleValues= new ArrayList<>();
        for(double dbl = 0.0; dbl < 10.0; dbl = dbl+0.5) {
            myDoubleValues.add(dbl);
            System.out.println(myDoubleValues);
//            System.out.println(dbl);
        }
    }
}
