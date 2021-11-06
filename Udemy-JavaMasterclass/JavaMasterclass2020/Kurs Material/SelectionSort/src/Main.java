public class Main {

    public static void main(String[] args) {

        int[] array = {9,5,6,8,3,1,2,3,4,5,6,7,8,9};

        System.out.println("Array unsortiert: ");

        for(int i = 0; i<array.length; i++) {
            System.out.print(array[i] + "|");
        }
        System.out.println();


        System.out.println("Array absteigend sortiert: ");
        for(int i = 0; i<array.length; i++) {
            System.out.print(array[i] + "|");
        }

    }
}
