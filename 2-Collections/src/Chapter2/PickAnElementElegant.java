package Chapter2;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Optional;

import static Chapter2.Folks.friends;

public class PickAnElementElegant {

    public static void pickName(final List<String> names, final String startingLetter){
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();
        System.out.println(
                String.format(
                        "A name starting with %s: %s", startingLetter,
                        foundName.orElse("No Name Found")
                )
        );

    }

    public static void main(String[] args) {
        System.out.println("//" + "START:NAME_OUTPUT");
        pickName(friends,"N");
        pickName(friends,"Z");
        System.out.println("//" + "END:NAME_OUTPUT");

        final Optional<String> foundName = friends.stream()
                .filter(name -> name.startsWith("N"))
                .findFirst();
        System.out.println("//" + "START:CLOSURE_OUTPUT");
        foundName.ifPresent(name -> System.out.println("Hello " + name));
        System.out.println("//" + "END:CLOSURE_OUTPUT");


    }
}
