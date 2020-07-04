package Chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Chapter2.Folks.friends;

public class PickElements {
    public static void main(String[] args) {
        final List<String> startsWithN = new ArrayList<>();
        // traditional way
//        for (String name : friends) {
//            if(name.startsWith("N"))
//                startsWithN.add(name);
//
//        }
        
        // Using FP
        System.out.println("//" + "START:FILTER_OUTPUT");
        final List<String> filterStartsWithN = friends.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
        System.out.println(String.format("Found %d names ",filterStartsWithN.size()));
        System.out.println("//" + "END:FILTER_OUTPUT");

    }

}
