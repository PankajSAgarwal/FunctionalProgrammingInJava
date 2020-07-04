package Chapter3;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class OlderThan20 {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 30),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );
        {
            System.out.println("//" + "START:MUTABLE_OUTPUT");
            List<Person> olderThan20 = new ArrayList<>();
        /*The collect() method takes a stream of elements and collects or gathers them into a result container. To do that, the method needs to know three things:
            • How to make a result container (for example, using the ArrayList::new method) • How to add a single element to a result container (for example, using the
              ArrayList::add method)
            • How to merge one result container into another (for example, using the
              ArrayList::addAll method)*/
        // Not thread safe for parallel execution

        people.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(person -> olderThan20.add(person));
        System.out.println("People older than 20: " + olderThan20);
        System.out.println("//" + "END:MUTABLE_OUTPUT");
    }
        {

            // Thread safe for parallel execution
            System.out.println("//" + "START:COLLECT_OUTPUT");
            List<Person> olderThan20 = people.stream().filter(person -> person.getAge() > 20)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            System.out.println("People older than 20 " + olderThan20);
            System.out.println("//" + "END:COLLECT_OUTPUT");
        }
        {
            System.out.println("//" + "START:COLLECT_TO_LIST_OUTPUT");
            List<Person> olderThan20 = people.stream()
                    .filter(person -> person.getAge() > 20)
                    .collect(toList());
            System.out.println("People older than 20 " + olderThan20);
            System.out.println("//" + "END:COLLECT_TO_LIST_OUTPUT");

        }
        {
            System.out.println("//" + "START:GROUP_BY_OUTPUT");
            Map<Integer,List<Person>> peopleByAge = people.stream()
                    .collect(groupingBy(Person::getAge));
            System.out.println("Grouped By Age :"+peopleByAge);
            System.out.println("//" + "END:GROUP_BY_OUTPUT");
        }
        {
            System.out.println("//" + "START:GROUP_BY_AGE_NAME_OUTPUT");
            Map<Integer, List<String>> nameOfPeopleByAge =
                    people.stream()
                            .collect(
                                    groupingBy(Person::getAge, mapping(Person::getName, toList()))
                            );
            System.out.println("People grouped by age: " + nameOfPeopleByAge);
            System.out.println("//" + "END:GROUP_BY_AGE_NAME_OUTPUT");
        }
        {
            System.out.println("//" + "START:OLDEST_IN_EACH_LETTER_OUTPUT");
            Comparator<Person> byAge = Comparator.comparing(Person::getAge);
            Map<Character,Optional<Person>> oldestPersonOfEachLetter =
                    people.stream()
                            .collect(groupingBy(person -> person.getName().charAt(0),
                                    reducing(BinaryOperator.maxBy(byAge))));
            System.out.println("Oldest person of each letter:");
            System.out.println(oldestPersonOfEachLetter);
            System.out.println("//" + "END:OLDEST_IN_EACH_LETTER_OUTPUT");


        }
    }
}
