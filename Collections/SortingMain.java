import java.util.ArrayList;

public class SortingMain {
    public static void main(String[] args) {
        list<Student> list = new ArrayList<>();
        list.add(new Student("Louange", "Bizimana", 88, 17));
        list.add(new Student("Jonas", "Sebera", 90, 18));
        list.add(new Student("Jean", "Mugabe", 80, 12));

        Collections.sort(list, new CompareGrade());

        for (Student s : list) {
            System.out.println(s);

        }
    }
};