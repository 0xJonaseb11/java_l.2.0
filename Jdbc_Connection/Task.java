import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement insertStatement = null;
        Statement retrieveStatement = null;
        ResultSet result = null;

        try {
            // Establish a database connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc-mysql",
                    "root",
                    "root"
            );

            // Insert data using PreparedStatement
            String insertQuery = "INSERT INTO students(name, age, school, dob) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertPreparedStatement = connection.prepareStatement(insertQuery)) {
                insertPreparedStatement.setString(1, "Jonas");
                insertPreparedStatement.setInt(2, 18);
                insertPreparedStatement.setString(3, "RCA");
                // Assuming you have a valid date for dob
                insertPreparedStatement.setDate(4, java.sql.Date.valueOf("2005-11-30"));

                // Execute the prepared statement
                int rowsAdded = insertPreparedStatement.executeUpdate();

                // Check if any rows were affected by the INSERT operation
                if (rowsAdded > 0) {
                    System.out.println("Data inserted successfully!");
                }
            }

            // Retrieve data
            retrieveStatement = connection.createStatement();
            result = retrieveStatement.executeQuery("SELECT * FROM students");

            // Process the ResultSet and print or use the retrieved data
            while (result.next()) {
                int code = result.getInt("code");
                String name = result.getString("name");
                int age = result.getInt("age");
                String school = result.getString("school");

                // Print or use the retrieved data as needed
                System.out.println("Code: " + code + ", Name: " + name + ", Age: " + age + ", School: " + school);
            }
        } catch (SQLException e) {
            // Handle SQL exceptions (e.g., connection issues, SQL errors)
            e.getCause();
        } finally {
            // Close resources in a finally block
            try {
                if (result != null) result.close();
                if (insertStatement != null) insertStatement.close();
                if (retrieveStatement != null) retrieveStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.getCause();
            }
        }
    }
}







