import java.sql.*;
import java.util.Scanner;
public class Task {
    public static String jdbcURL = "jdbc:mysql://localhost:3306/jdbc";
    public static String jdbcUsername = "root";
    public static String jdbcPassword = "";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO students (code, name, age, school) VALUES (?, ?, ?, ?)");

            System.out.print("Enter name: ");

            String nameInput = scanner.nextLine();
            System.out.print("Enter age: ");
            int ageInput = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter school: ");

            String schoolInput = scanner.nextLine();
            System.out.print("Enter code: ");

            int codeInput = scanner.nextInt();
            scanner.nextLine();
            preparedStatement.setInt(1, codeInput);
            preparedStatement.setString(2, nameInput);
            preparedStatement.setInt(3, ageInput);
            preparedStatement.setString(4, schoolInput);
            preparedStatement.executeUpdate();
            System.out.println("Record inserted successfully.");
            String selectQuery = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("Records in the database:");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String school = resultSet.getString("school");
                String code = resultSet.getString("code");
                System.out.println(
                        "name: " + name + ", Age: " + age + ", School: " + school + ", Code: " + code);
            }
            resultSet.close();
            statement.close();
            connection.close();
            scanner.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}