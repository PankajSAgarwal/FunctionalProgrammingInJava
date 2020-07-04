package Chapter2;

import java.util.Optional;

import static Chapter2.Folks.friends;

public class PickALongest {
    public static void main(String[] args) {
        System.out.println("//" + "START:SUM_OUTPUT");
        System.out.println("Total number of characters in all names: "
                + friends.stream()
                .mapToInt(name -> name.length())
                .sum());
        System.out.println("//" + "END:SUM_OUTPUT");

        System.out.println("//" + "START:REDUCE_OUTPUT");
        final Optional<String> aLongName = friends.stream()
                .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        // output : Brian
        aLongName.ifPresent(name -> System.out.println(String.format("A longest name : %s", name)));
        System.out.println("//" + "END:REDUCE_OUTPUT");

        final String SteveOrLonger = friends.stream()
                .reduce("Steve", (name1, name2) ->
                        name1.length() >= name2.length() ? name1 : name2);




    }
}
