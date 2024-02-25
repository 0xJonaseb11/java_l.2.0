package student;

public class StudentModel {
    int code;
    String name;
    int age;
    String school;
    String email;
    String phoneNumber;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StudentModel(String name, int age, String school,String email,String phoneNumber) {
        
        this.name = name;
        this.age = age;
        this.school = school;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

	public StudentModel() {
		// TODO Auto-generated constructor stub
	}
}
