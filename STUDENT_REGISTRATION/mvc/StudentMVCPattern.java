package mvc;


public class StudentMVCPattern {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Sebera");
        controller.setStudentRollNum("66666");

    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Jonas");
        student.setRollNo("99999");
        return student;
    }
}
