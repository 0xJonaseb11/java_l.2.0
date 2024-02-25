package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final String url = "jdbc:postgresql://localhost:5432/school_students"; 
    private static final String password = "12345678"; 
    private static final String student="school";

    // Method to establish a database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, student, password);
    }

    // Method to insert a new student into the database
    public static void addStudent(StudentModel student) {
        String sql = "INSERT INTO students (name, age, school, email, phoneNumber) VALUES (?,?,?,?,?);";
        		
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, student.getName());
        	 stmt.setInt(2, student.getAge());
        	 stmt.setString(3,student.getSchool());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getPhoneNumber());
            
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all students from the database
    public static List<StudentModel> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String email = rs.getString("email");
                String studentname = rs.getString("name");
                String mobile = rs.getString("phoneNumber");
                String school = rs.getString("school");
           
                int age=rs.getInt("age");
                
                StudentModel student = new StudentModel(studentname, age, school,email,mobile);
                System.out.print(student.age);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public static StudentModel getStudentByCode(String studentId) {
        String sql = "SELECT * FROM students WHERE code = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(studentId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	 String email = rs.getString("email");
                     String studentname = rs.getString("name");
                     String mobile = rs.getString("phoneNumber");
                     String school = rs.getString("school");
                
                     int age=rs.getInt("age");
                     
                     return new StudentModel(studentname, age, school,email,mobile);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;

    // Additional methods for update, delete, etc. can be added similarly
    }
}

    
