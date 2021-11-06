public class Main {

    public static void main(String[] args) {

        int[] array = {1,4,7,8,55,7,-5,2};

        System.out.println("Unsortiertes Array: ");
        for(int i = 0; i<array.length;i++) {
            System.out.print(array[i] + "|");
        }
        Insertionsort.insertionsort(array);
        System.out.println("Sortiertes Array: ");
        for(int i = 0; i<array.length;i++) {
            System.out.print(array[i] + "|");
        }
    }
}
