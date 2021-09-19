import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[]array = {0,1,2,3,4,5,7,8,9,10};

        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed Array = " + Arrays.toString(array));


    }

//    private static void reverse(int[] array) {
//
//        int maxIndex = array.length-1;
//        int halfLength = array.length / 2;
//
//        for(int i = 0; i < halfLength; i++) {
//                int tmp = array[i];
//                array[i] = array[maxIndex - i];
//                array[maxIndex - i] = tmp;
//        }
//    }

    private static void reverse(int[] array) {

        int maxIndex = array.length-1;

        for(int i = 0; i < (maxIndex-i); i++) {
            int tmp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = tmp;
        }
    }
}
