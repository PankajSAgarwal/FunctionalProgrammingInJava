package Chapter2;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.function.Consumer;

import static Chapter2.Folks.friends;

public class Iteration {
    public static void main(String[] args) {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
        System.out.println("***for(string:strings*****");
        for (String name : friends) {
            System.out.println(name);
        }
        System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

        //more verbose
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println( name);

            }
        });

        System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

        System.out.println("//" + "START:INTERNAL_OUTPUT");
        friends.forEach((final String name)-> System.out.println(name));
        System.out.println("//" + "END:INTERNAL_OUTPUT");

        friends.forEach((name)-> System.out.println(name));
        friends.forEach(name -> System.out.println(name));
        friends.forEach(System.out::println);// method reference



    }
}
