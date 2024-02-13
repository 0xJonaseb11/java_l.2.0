package com.jonas.jdbc.rca;

import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

public class UserDao {
	private String dburl = "jdbc:mysql://localhost:3306/studentdb";
	private String username = "root";
	private String password = "";
	private String dbdriver = "com.mysql.cj.jdbc.Driver";
	private static final String INSERT_STUDENT_SQL = "INSERT INTO studentdb.users (name, email, password, role) VALUES (?, ?, ?, ?);";
	private static final String CHECK_CREDENTIALS_AND_ROLE_SQL =
			"SELECT * FROM studentdb.users WHERE email = ?;";
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = DriverManager.getConnection(dburl, username, password);

		// Create the table if it doesn't exist
		createUsersTableIfNotExists(connection);

		return connection;
	}

	private void createUsersTableIfNotExists(Connection connection) {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS studentdb.users (" +
				"id INT AUTO_INCREMENT PRIMARY KEY," +
				"name VARCHAR(255) NOT NULL," +
				"email VARCHAR(255) NOT NULL," +
				"password VARCHAR(255) NOT NULL," +
				"role VARCHAR(255) NOT NULL)";
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




	public String insert(User u) {
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(INSERT_STUDENT_SQL)) {

			stm.setString(1, u.getUsername());
			stm.setString(2, u.getEmail());
			String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
			stm.setString(3, hashedPassword);
			stm.setString(4, u.getRole());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Data not added!";
		}
		return "successfully added!";
	}

	public User checkCredentialsAndRole(String email, String plainPassword) {
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(CHECK_CREDENTIALS_AND_ROLE_SQL)) {

			stm.setString(1, email);

			try (ResultSet resultSet = stm.executeQuery()) {
				if (resultSet.next()) {
					String hashedPassword = resultSet.getString("password");
					if (BCrypt.checkpw(plainPassword, hashedPassword)) {
						String username = resultSet.getString("name");
						String role = resultSet.getString("role");
						return new User(username, email, hashedPassword, role);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String determineUserRole(User user) {
		if (user != null && user.getRole() != null) {
			return user.getRole();
		}
		return "guest";
	}
}
