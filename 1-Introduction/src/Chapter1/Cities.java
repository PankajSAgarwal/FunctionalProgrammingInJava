package Chapter1;

import java.util.Arrays;
import java.util.List;

public class Cities {
    public static void findChicagoImperative(final List<String> cities){
        boolean found = false;
        for (String city : cities) {
            if(city.equals("Chicago")){
                found = true;
                break;
            }

        }
        System.out.println("Found Chicago?:"+ found);
    }

    public static void findChicagoDeclerative(final List<String> cities){
        System.out.println("Found Chicago?:"+cities.contains("Chicago"));
    }

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Hyderabad","Mumbai","Chicago","Singapore");
        findChicagoImperative(cities);
        findChicagoDeclerative(cities);
    }
}
