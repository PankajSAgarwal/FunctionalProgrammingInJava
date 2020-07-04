package Iterator;

import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        //external iterators

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }

//        for (int e : numbers) {
//            System.out.println(e);
//        }
        // Internal iterators
        numbers.forEach(e-> System.out.println(e));
        numbers.forEach(System.out::println);
    }
}
