import com.fpruss.udemy.challenges.packagechallenge.Series;

public class Main {
    public static void main(String[] args) {

//        System.out.println(Series.nSum(10));
//        System.out.println(Series.factorialRec(10));
//        System.out.println(Series.factorialIterative(10));
//        System.out.println(Series.fibonacciIterative(10));
//        System.out.println(Series.fibonacciRec(10));
        for(int i = 0; i <= 10; i++) {
            System.out.println(Series.nSum(i));
        }
        System.out.println("************");
        for(int i = 0; i <= 10; i++) {
            System.out.println(Series.factorialIterative(i));
        }
        System.out.println("************");
        for(int i = 0; i <= 10; i++) {
            System.out.println(Series.factorialRec(i));
        }
        System.out.println("************");
        for(int i = 0; i <= 10; i++) {
            System.out.println(Series.fibonacciRec(i));
        }
        System.out.println("************");
        for(int i = 0; i <= 10; i++) {
            System.out.println(Series.fibonacciIterative(i));
        }
    }
}
