import java.util.Arrays;

public class ReferenceTypes {

    public static void main(String[] args) {

        int[] array = new int[5];
        System.out.println(Arrays.toString(array));
        int[] newArray = new int[5];
        newArray = array;
        System.out.println(Arrays.toString(newArray));
        newArray [0]= 1;
        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(array));

        modifyArray(array);
        System.out.println("newArray after modify " + Arrays.toString(newArray));
        System.out.println("array after modify " +Arrays.toString(array));



    }
    private static void modifyArray(int[] parameterArray) {
        parameterArray[2] = 4;
        parameterArray = new int[] {1,2,3,4,5,6,7,8,9};
        System.out.println("Paramarray " + Arrays.toString(parameterArray));
    }
}
