package LambdaChanllenges;

import java.util.Arrays;

public class Challenge1 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String myString = "Lets split this up";
            Arrays.asList(myString.split(" ")).forEach(System.out::println);

        };
        runnable.run();
    }
}
