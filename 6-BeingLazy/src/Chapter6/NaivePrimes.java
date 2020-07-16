package Chapter6;

import java.util.ArrayList;
import java.util.List;
import static Chapter6.PrimeFinder.*;

public class NaivePrimes {

    public static List<Integer> concat(final int number ,
                                       final List<Integer> numbers){
        final List<Integer> values = new ArrayList<>();
        values.add(number);
        values.addAll(numbers);
        return values;
    }

    // don't try this at home

    public static List<Integer> primes(final int number){
        if(isPrime(number))
            return concat(number,primes(number + 1));
        else
            return primes(number + 1);
    }

    public static void main(String[] args) {
        try {
            primes(1);
        } catch (StackOverflowError e) {
            System.out.println(e);;
        }
    }
}
