public class Main {

    public static void main(String[] args) {

        int[] myIntArray = new int[10]; //1. Art der Deklaration, Array mit 10 Elementen, Index 0-9
        myIntArray[0] = 45; //1. Art zu initialisieren,
        myIntArray[1] = 20;
        myIntArray[5] = 50; //Element 6, weil Index bei 0 losgeht

        int[] anotherIntArray = {1,2,3,4,5,6,7,8,9,10}; // 2. Art zu deklarieren und gleichzeitig initialisieren,
        // speichert gleich die Werte und sagt wie groß das Array sein soll

        int[] thirdArray = new int[25]; //1.Art der Deklaration

       for(int i = 0; i<thirdArray.length; i++) {  //3. Art der Initialisierung. Loop, Element i bekommt ein Vielfaches von i zugewiesen

           thirdArray[i] = i*10;
       }

        printArray(anotherIntArray);
    }
    public static void printArray(int[] array) {
        for(int i=0; i<array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }
}
