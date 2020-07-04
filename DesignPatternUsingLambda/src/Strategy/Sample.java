package Strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // total all values
        System.out.println(totalValues(numbers,e ->true));// add all numbers
        System.out.println(totalValues(numbers,e->e %2 == 0));// add all even numbers
        System.out.println(totalValues(numbers,e->e %2 != 0));// add all odd numbers
        // normal functions

        // higher-order functions


    }

    private static int totalValues(List<Integer> numbers,Predicate<Integer> selector) {
//        int result = 0;
//        for (int e : numbers) {
//            if(selector.test(e))
//            result += e;
//        }
//        return result;
        // Iterator + strategy
        /*return numbers.stream().filter(selector).reduce(0,Integer::sum);*/
        return numbers.stream().filter(selector)
                .mapToInt(e->e).sum();
    }


}
