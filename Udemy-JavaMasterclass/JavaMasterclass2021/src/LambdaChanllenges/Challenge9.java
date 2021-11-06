package LambdaChanllenges;

import java.util.*;

public class Challenge9 {
    public static void main(String[] args) {
        List<String> topNames = Arrays.asList(
                "amelia",
                "oliver",
                "Charlie",
                "Anton"
        );
//        Lambda Version
//        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames.forEach(name ->
//                firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);
//        Stream Version
       topNames
               .stream()
               .map(name -> name.substring(0, 1) + name.substring(1))
               .sorted(String::compareTo)
               .forEach(System.out::println);
//       print number of names starting with "A"
        System.out.println(topNames
                .stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .count());

        System.out.println(topNames);
    }
}
