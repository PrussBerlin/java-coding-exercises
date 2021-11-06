package LambdaChanllenges;

import java.util.function.Supplier;

public class Challenge5 {

    public static void main(String[] args) {
        Supplier<String> iLoveJava = () -> "I Love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }
}
