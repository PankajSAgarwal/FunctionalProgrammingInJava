package Chapter2;

import java.util.stream.Collectors;

import static Chapter2.Folks.friends;

public class PrintList {

    public static void main(String[] args) {
        for (String name : friends) {
            // adds an additional comma at the end of the list
            // Better use String.join(",", friends)
            System.out.print(name + ",");
        }
        // output : Brian,Nate,Neal,Raju,Sara,Scott,
        System.out.println();

        //output : Brian,Nate,Neal,Raju,Sara,Scott
        System.out.print(String.join(",",friends));
        System.out.println();

        System.out.println(friends.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(",")));
    }
}
