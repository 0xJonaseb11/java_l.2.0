package com.jonas.jdbc.rca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	private String dburl = "jdbc:mysql://localhost:3306/studentdb";
	private String username = "root";
	private String password = "kayumba@";
	private String dbdriver = "com.mysql.cj.jdbc.Driver";
	private static final String INSERT_STUDENT_SQL = "INSERT INTO studentdb.student (name, age, dob, school, code, email, mobile) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_STUDENTS_SQL = "SELECT * FROM student;";
	private static final String DELETE_STUDENT_SQL = "DELETE FROM student WHERE id = ?";
	private static final String GET_STUDENT_SQL = "SELECT * FROM student WHERE id = ?";
	private static final String UPDATE_STUDENT_SQL = "UPDATE student SET name = ?, age = ?, dob = ?, school = ?, code = ?, email = ?, mobile = ? WHERE id = ?";

	public Connection getConnection() throws SQLException {
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = DriverManager.getConnection(dburl, username, password);

		// Create the table if it doesn't exist
		createStudentTableIfNotExists(connection);

		return connection;
	}

	private void createStudentTableIfNotExists(Connection connection) {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS studentdb.student (" +
				"id INT AUTO_INCREMENT PRIMARY KEY," +
				"name VARCHAR(255) NOT NULL," +
				"age INT NOT NULL," +
				"dob Date NOT NULL," +
				"school VARCHAR(255) NOT NULL," +
				"code VARCHAR(255) NOT NULL," +
				"email VARCHAR(255) NOT NULL," +
				"mobile VARCHAR(255) NOT NULL);";

		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public String insert(Student st) {
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(INSERT_STUDENT_SQL)) {

			stm.setString(1, st.getName());
			stm.setInt(2, st.getAge());
			stm.setDate(3, st.getDob());
			stm.setString(4, st.getSchool());
			stm.setString(5, st.getCode());
			stm.setString(6, st.getEmail());
			stm.setString(7, st.getMobile());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Data not added!";
		}
		return "successfully added!";
	}


	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(SELECT_ALL_STUDENTS_SQL);
				ResultSet res = stm.executeQuery()) {

			while (res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				int age = res.getInt("age");
				Date dob = res.getDate("dob");
				String school = res.getString("school");
				String code = res.getString("code");
				String email = res.getString("email");
				String mobile = res.getString("mobile");
				Student student = new Student(id, name, age,dob, school, code, email, mobile);
				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}


	public Student getStudent(int studentId) {
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(GET_STUDENT_SQL)) {

			stm.setInt(1, studentId);
			try (ResultSet res = stm.executeQuery()) {
				if (res.next()) {
					int id = res.getInt("id");
					String name = res.getString("name");
					int age = res.getInt("age");
					Date dob = res.getDate("dob");
					String school = res.getString("school");
					String code = res.getString("code");
					String email = res.getString("email");
					String mobile = res.getString("mobile");
					return new Student(id, name, age, dob, school, code, email, mobile);
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String updateStudent(Student st) {
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(UPDATE_STUDENT_SQL)) {

			stm.setString(1, st.getName());
			stm.setInt(2, st.getAge());
			stm.setDate(3, st.getDob());
			stm.setString(4, st.getSchool());
			stm.setString(5, st.getCode());
			stm.setString(6, st.getEmail());
			stm.setString(7, st.getMobile());
			stm.setInt(8, st.getId());

			int rowsAffected = stm.executeUpdate();

			if (rowsAffected > 0) {
				return "Student updated successfully!";
			} else {
				return "Student not found or not updated!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error updating student!";
		}
	}



	public String deleteStudent(int studentId) {
		try (Connection con = getConnection();
				PreparedStatement stm = con.prepareStatement(DELETE_STUDENT_SQL)) {

			stm.setInt(1, studentId);
			int rowsAffected = stm.executeUpdate();

			if (rowsAffected > 0) {
				return "Student deleted successfully!";
			} else {
				return "Student not found or not deleted!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error deleting student!";
		}
	}
}
