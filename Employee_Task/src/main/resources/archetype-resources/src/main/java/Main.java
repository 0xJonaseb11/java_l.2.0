package com.employee;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Employee";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String outputFileName = "employee_data_" + i + ".xlsx";
            executorService.submit(() -> {
                try (Connection connection = getConnection()) {
                    exportEmployeeData(connection, outputFileName);
                } catch (SQLException e) {
                    System.err.println("Error creating database connection: " + e.getMessage());
                }
            });
        }
        executorService.shutdown();
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    private static void exportEmployeeData(Connection connection, String outputFileName) {
        String query = "SELECT id, name, department, salary FROM employees";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
             Workbook workbook = new XSSFWorkbook()) {

            // Create Excel sheet and populate data
            Sheet sheet = workbook.createSheet("Employee Data");
            createHeaderRow(sheet);

            int rowNum = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(resultSet.getInt("id"));
                row.createCell(1).setCellValue(resultSet.getString("name"));
                row.createCell(2).setCellValue(resultSet.getString("department"));
                row.createCell(3).setCellValue(resultSet.getDouble("salary"));
            }

            // Write to the Excel file
            try (FileOutputStream fileOut = new FileOutputStream(outputFileName)) {
                workbook.write(fileOut);
            }
            System.out.println("Export completed for: " + outputFileName);
        } catch (SQLException | IOException e) {
            System.err.println("Error exporting data: " + e.getMessage());
        }
    }

    private static void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Department");
        headerRow.createCell(3).setCellValue("Salary");
    }
}