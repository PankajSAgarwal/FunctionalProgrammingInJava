package Chapter2;

import java.util.List;

import static Chapter2.Folks.friends;

public class PickAnElement {

    public static void pickName(final List<String> names, final String startingLetter) {
        String foundName = null;

        for (String name : names) {
            if(name.startsWith(startingLetter)){
                foundName = name;
                break;
            }
        }
        System.out.println(String.format("A name starting with %s: ",startingLetter));

        if(foundName != null){
            System.out.println(foundName);
        }else{
            System.out.println("No Name found");
        }

    }

    public static void main(String[] args) {
        pickName(friends,"N");
        pickName(friends,"Z");
    }
}
