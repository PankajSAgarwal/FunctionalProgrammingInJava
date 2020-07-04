package Chapter2;
import java.awt.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static Chapter2.Folks.*;


public class PickElementsMultipleCollection {
    public static void main(String[] args) {

        // code duplication introduced with streams . Not a good practice
//        final long countFriendsStartN = friends.stream()
//                .filter(name -> name.startsWith("N"))
//                .count();
//        final long countEditorsStartN = editors.stream()
//                .filter(name -> name.startsWith("N"))
//                .count();
//        final long countComradesStartN = comrades.stream()
//                .filter(name -> name.startsWith("N"))
//                .count();

        final Predicate<String> startWithN = name->name.startsWith("N");
        final long countFriendsStartN = friends.stream().filter(startWithN).count();
        final long countEditorsStartN = editors.stream().filter(startWithN).count();
        final long countComradesStartN = comrades.stream().filter(startWithN).count();

        System.out.println(countFriendsStartN);
        System.out.println(countEditorsStartN);
        System.out.println(countComradesStartN);

    }
}
