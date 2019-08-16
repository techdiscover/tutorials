package net.techdiscover.mysqlService;

import net.techdiscover.model.Employee;

import java.sql.*;
import java.util.List;

public class MySqlService {

    private Connection getConnectionToMySQL() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        return DriverManager.getConnection(url, "root", "");
    }

    public void saveEmployeesToDB(List<Employee> employees) throws SQLException {
        String query = " insert into employee (firstName, lastName, physicalAddress,emailAddress)"
                + " values (?, ?, ?, ?)";

        Connection connectionToMySQL = getConnectionToMySQL();
        try (connectionToMySQL; PreparedStatement preparedStmt = connectionToMySQL.prepareStatement(query);) {

            employees.forEach(employee -> {
                try {
                    preparedStmt.setString(1, employee.getFirstName());
                    preparedStmt.setString(2, employee.getLastName());
                    preparedStmt.setString(3, employee.getPhysicalAddress());
                    preparedStmt.setString(4, employee.getEmailAddress());

                    preparedStmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

        }

    }

    public void printValuesFromMySQL() throws SQLException {
        Connection connectionToMySQL = getConnectionToMySQL();
        try (connectionToMySQL; ResultSet rs = getConnectionToMySQL().createStatement().executeQuery("select * from employee")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getString(5));
            }
        }

    }
}
