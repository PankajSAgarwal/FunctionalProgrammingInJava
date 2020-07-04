package Chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {
    public static void printPeople(final String message,
                                   final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {

        final List<Person> people = Arrays.asList(
                new Person("John", 30),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)

        );
        System.out.println("//" + "START:AGE_ASCEND_OUTPUT");
        /*List<Person> ascendingAge =
                people.stream()
                        .sorted((person1,person2)->person1.ageDifference(person2))
                        .collect(Collectors.toList());*/
        List<Person> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .collect(Collectors.toList());
        printPeople("Sorted in ascending order by age: ", ascendingAge);
        System.out.println("//" + "END:AGE_ASCEND_OUTPUT");

        System.out.println("//" + "START:AGE_DESCEND_OUTPUT");
        printPeople("Sorted in descending order by age: ",
                people.stream()
                        .sorted((person1, person2) -> person2.ageDifference(person1))
                        .collect(Collectors.toList()));
        System.out.println("//" + "END:AGE_DESCEND_OUTPUT");
        // Using comparator reversed with just one comapartor
        System.out.println("//" + "START:REVERSE_ORDER_OUTPUT");

        Comparator<Person> compareAscending =
                (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        printPeople("Sorted in ascending order by age: ",
                people.stream().sorted(compareAscending).collect(Collectors.toList()));

        printPeople("Sorted in descending order by age: ",
                people.stream().sorted(compareDescending).collect(Collectors.toList()));
        System.out.println("//" + "END:REVERSE_ORDER_OUTPUT");

        System.out.println("//" + "START:NAME_ASCEND_OUTPUT");
        printPeople("Sorted in ascending order by name:",
                people.stream().sorted((person1, person2) ->
                        person1.getName().compareTo(person2.getName())).collect(Collectors.toList()));

        System.out.println("//" + "START:YOUNGEST_OUTPUT");
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest " + youngest));
        System.out.println("//" + "END:YOUNGEST_OUTPUT");

        System.out.println("//" + "START:ELDEST_OUTPUT");
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> System.out.println("eldest " + eldest));
        System.out.println("//" + "END:ELDEST_OUTPUT");

        final Function<Person, String> byName = person -> person.getName();
        printPeople("Sorting by Name", people.stream().sorted(Comparator.comparing(byName)).collect(Collectors.toList()));

        final Function<Person, String> byTheirName = person -> person.getName();
        final Function<Person, Integer> byAge = person -> person.getAge();
        printPeople("Sorted in ascending order by age and name: ", people.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                .collect(Collectors.toList())
        );

    }

}
