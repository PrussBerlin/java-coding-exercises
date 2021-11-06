public class Insertionsort {

    public static void insertionsort(int[] array) {

        for(int i = 1; i < array.length; i++) {

            int tmp = array[i];
            int j = i;
            while((j>0) && (array[j-1]>tmp)) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = tmp;
        }
    }


}
