package mvc;


public class StudentController {
    // Model object
    // view object

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // setters
    ///  ///////////////////////
    /// Control Model Object///
    /// //////////////////////
    public  void setStudentName(String name) {
        model.setName(name);
    }

    public  void setStudentRollNum(String rollNo) {
        model.setRollNo(rollNo);
    }

    // getters
    public String getStudentName() {
        return model.getName();
    }
    public String getStudentRollNo() {
        return model.getRollNo();
    }

    /// ///////////////////////////
    ///  Control View Object//////
    /// /////////////////////////
    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
