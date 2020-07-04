package Chapter2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import static Chapter2.Folks.friends;

public class Transform {
    public static void main(String[] args) {
        final List<String> upperCaseNames = new ArrayList<>();
        // Traditional Imperative
        /*for (String name : friends) {
            upperCaseNames.add(name.toUpperCase());
        }
        System.out.println(upperCaseNames);*/

        /*friends.forEach(name->upperCaseNames.add(name.toUpperCase()));
        System.out.println(upperCaseNames);*/

        // Using streams

        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name + ' '));
        System.out.println();
    }
   



}
