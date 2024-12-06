package dao;

import model.MtEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MtEmployeeDAO {
    private Connection connection;
    public MtEmployeeDAO() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/test";
        String user = "postgres";
        String password = "random123";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public List<MtEmployee> getAllEmployees() throws SQLException {
        List<MtEmployee> employees = new ArrayList<>();
        String query = "SELECT employee_code, employee_name, employee_age, date_of_birth FROM Mt_employee";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                MtEmployee employee = new MtEmployee();
                employee.setEmployeeCode(rs.getInt("employee_code"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setEmployeeAge(rs.getInt("employee_age"));
                employee.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                employees.add(employee);
            }
        }

        return employees;
    }
    
    public static void main(String[] args) {
        try {
            MtEmployeeDAO dao = new MtEmployeeDAO();
            List<MtEmployee> employees = dao.getAllEmployees();
            for (MtEmployee employee : employees) {
                System.out.println("Employee Code: " + employee.getEmployeeCode() +
                                   ", Name: " + employee.getEmployeeName() +
                                   ", Age: " + employee.getEmployeeAge() +
                                   ", Date of Birth: " + employee.getDateOfBirth());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
