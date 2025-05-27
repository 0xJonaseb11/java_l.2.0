import java.util.HashMap;

public class StudentAges {
    public static void main(String[] args) {
        // Create a HashMap to store student names and their ages
        HashMap<String, Integer> ages = new HashMap<>();

        // Add student names with their corresponding ages
        ages.put("Alain", 18);
        ages.put("Jonas", 20);
        ages.put("Pascal", 19);

        // Print each student's age
        System.out.println("Student Ages:");
        System.out.println("Alain: " + ages.get("Alain"));
        System.out.println("Jonas: " + ages.get("Jonas"));
        System.out.println("Pascal: " + ages.get("Pascal"));
    }
}
