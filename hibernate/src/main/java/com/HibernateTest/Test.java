package com.HibernateTest;
import com.Models.Student;
import com.hibernate.Utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        try  {
            performUserOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void performUserOperation() {
        try (Scanner scanner = new Scanner(System.in)) {
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            Session session = sessionFactory.openSession();
            while (true) {
                System.out.println("Choose operation:");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        createStudent(session);
                        break;
                    case 2:
                        readStudent(session);
                        break;
                    case 3:
                        updateStudent(session);
                        break;
                    case 4:
                        deleteStudent(session);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    }
    private static void createStudent(Session session) {
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setStudentId(5); // Assuming you want to create a student with ID 5
        student.setFirstName("Jonas");
        student.setLastName("jonas");
        student.setStudentEmail("jonassebera@gmail.com");
        session.persist(student);
        transaction.commit();
        System.out.println("Student created successfully.");
    }
    private static void readStudent(Session session) {
        Student student = session.get(Student.class, 5); // Assuming you want to read a student with ID 5
        if (student != null) {
            System.out.println("Student details:");
            System.out.println("ID: " + student.getStudentId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Email: " + student.getStudentEmail());
        } else {
            System.out.println("Student not found.");
        }
    }
    private static void updateStudent(Session session) {
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 5); // Assuming you want to update a student with ID 5
        if (student != null) {
            student.setFirstName("UpdatedFirstName");
            session.merge(student);
            transaction.commit();
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    private static void deleteStudent(Session session) {
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 5); // Assuming you want to delete a student with ID 5
        if (student != null) {
            session.delete(student);
            transaction.commit();
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}