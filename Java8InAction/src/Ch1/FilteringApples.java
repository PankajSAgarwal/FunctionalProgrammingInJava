package Ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        System.out.println("inventory = " + inventory);

        final List<Apple> greenApples = filterApples(inventory,FilteringApples::isGreenApple);
        System.out.println("greenApples = " + greenApples);

        final List<Apple> heavyApples = filterApples(inventory,FilteringApples::isHeavyApple);
        System.out.println("heavyApples = " + heavyApples);

        final List<Apple> greenApples2 = filterApples(inventory,(Apple a) -> "green".equals(a.getColor()));
        System.out.println("greenApples2 = " + greenApples2);

        final List<Apple> heavyApples2 = filterApples(inventory,(Apple a) -> a.getWeight() > 150);
        System.out.println("heavyApples2 = " + heavyApples2);

    }

    private static List<Apple> filterApples(final List<Apple> inventory, Predicate<Apple> p) {

        final List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }






    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }



        public String getColor() {
            return color;
        }



        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
