package Chapter2;

import java.util.function.Function;
import java.util.function.Predicate;

import static Chapter2.Folks.friends;

public class PickDifferentNames {
    // Not a good practice to pollute classes with static methods to cache each variable in the future
    public static Predicate<String> checkIfStartsWith(final String letter){
        return name->name.startsWith(letter);
    }

    // Refactoring to narrow scope , replacement for static function above
    //Listing 1
//    final Function<String,Predicate<String>> startsWithLetter =
//            (String letter)->{
//                Predicate<String> checkStarts = (String name)-> name.startsWith(letter);
//                return checkStarts;
//            };

    // Listing 2
    // Listing 1 refactored to concise and less verbose representation
//    final Function<String,Predicate<String>> startsWithLetter =
//            (String letter)-> (String name)->name.startsWith(letter);

    public static void main(String[] args) {
//        final long countFriendsStartWithN = Folks.friends.stream()
//                .filter(checkIfStartsWith("N")).count();
//        final long countFriendsStartWithB = Folks.friends.stream()
//                .filter(checkIfStartsWith("B")).count();
        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);


        final long countFriendsStartWithN = friends.stream().filter(
                startsWithLetter.apply("N")).count();

        final long countFriendsStartWithB = friends.stream().filter(
                startsWithLetter.apply("B")).count();


        System.out.println("countFriendsStartWithN = " + countFriendsStartWithN);
        System.out.println("countFriendsStartWithB = " + countFriendsStartWithB);
    }
}
