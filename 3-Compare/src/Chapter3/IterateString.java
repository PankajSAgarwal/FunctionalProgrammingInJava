package Chapter3;

public class IterateString {
    public static void printChar(int aChar){
        System.out.println((char)aChar);
    }
    public static void main(String[] args) {
        System.out.println("//" + "START:ITERATE_OUTPUT");

        final String str = "w00t";
        //output
//        119
//        48
//        48
//        116
        //str.chars().forEach(ch-> System.out.println(ch));// Conventional lambda expressions
        str.chars().forEach(System.out::println);//method references
        System.out.println("//" + "END:ITERATE_OUTPUT");
        System.out.println("//" + "START:FIX_OUTPUT");
        //output
//        w
//        0
//        0
//        t

        str.chars().forEach(IterateString::printChar);// method reference for static method
        System.out.println("//" + "END:FIX_OUTPUT");

        str.chars().mapToObj(ch->Character.valueOf((char) ch))
                .forEach(System.out::println);
        System.out.println("//" + "START:FILTER_OUTPUT");

        str.chars().filter(Character::isDigit)
        .forEach(IterateString::printChar);
        System.out.println("");
        System.out.println("//" + "END:FILTER_OUTPUT");

    }
}
