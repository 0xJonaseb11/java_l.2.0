import java.util.ArrayList;
import java.util.List;

public class ListManipulation {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Lidvine");
        list1.add("Regis");
        list1.add("Ritha");
        list1.add("Exauce");
        list1.add("Linda");

        List<String> list2 = new ArrayList<>();
        list2.add("Mustapha");
        list2.add("Faith");
        list2.add("Divine");

        // Put Gisele between Ritha and Exauce
        
        list1.add(list1.indexOf("Ritha") + 1, "Gisele");

        // Update Faith to "Faith Mbabazi"
        
        int faithIndex = list2.indexOf("Faith");
        if (faithIndex != -1) {
            list2.set(faithIndex, "Faith Mbabazi");
        }

        // Remove Mustapha
        
        list2.remove("Mustapha");

        // Check if we have Alice
        
        boolean hasAlice = list1.contains("Alice");
        System.out.println("Does list1 contain Alice? " + hasAlice);

        // Add the second list to list1
        
        list1.addAll(list2);

        // Print the modified lists
        System.out.println("Modified list1: " + list1);
        System.out.println("Modified list2: " + list2);
    }
}