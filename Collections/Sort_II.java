import java.util.Comparator;

public class implements CompareGrade {

    @override
    public int compare(Student s1, Student s2) {
        if (s1.grade > s2.grade) {
            return 1;
            else 
            return -1;
        }
    }
}