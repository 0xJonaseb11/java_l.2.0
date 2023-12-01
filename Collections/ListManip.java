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
        