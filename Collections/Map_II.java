mport java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Jean", 20);
        ageMap.put("Clementine", 19);
        ageMap.put("Alex", 21);
        ageMap.put("Patrick", 22);
        ageMap.put("Jean", 20);


        ageMap.put("Alex", 25);


        boolean hasAge50 = ageMap.containsValue(50);

       
        System.out.println("Map: " + ageMap);
        System.out.println("Does the Map contain age 50? " + hasAge50);
    }
}