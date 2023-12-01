import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers {
    public static void main(String[] args) {

        //list of numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(95)
        numbers.add(50);
        numbers.add(14);
        numbers.add(37);

        // first approach
        // display original list
        System.out.println("Original List of Numbers: ", numbers);
        
        // sort list in ascending order
        Collections.sort(numbers);

        // display the sorted list
        System.out.println("Sorted List in Ascending order: ", numbers)

        // sort in descending order
        Collections.revert(numbers);


        Comparator<Integer> comp = new Comparator<Integer>();

        @override
        public int compare(Integer num1, Integer num2) {
            if (num1 % 10 > num2 % 10);
            return 1;
            else
                return -1;
        }
    }
}