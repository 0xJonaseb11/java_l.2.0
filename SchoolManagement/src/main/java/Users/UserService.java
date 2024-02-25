package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String url = "jdbc:postgresql://localhost:5432/school_users"; 
    private static final String password = "12345678"; 
    private static final String user="school";

    // Method to establish a database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Method to insert a new user into the database
    public static void addUser(UserModel user) {
        String sql = "INSERT INTO users (email, username, password, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole().toString());

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

    // Method to retrieve all users from the database
    public static List<UserModel> getAllUsers() {
        List<UserModel> students = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role =rs.getString("role");
                UserModel user = new UserModel(email, username, password, role);
                students.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public static UserModel getUserById(String userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(userId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String email = rs.getString("email");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    return new UserModel(email, username, password, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;

    // Additional methods for update, delete, etc. can be added similarly
    }
}

    
