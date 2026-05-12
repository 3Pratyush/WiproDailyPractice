package DP_Day17;

import java.sql.*;

public class EmployeeCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/JDBC_Employee_DB";
    static final String USER = "root";
    static final String PASSWORD = "Lostfiber@8";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            insertEmployees(con);

            fetchEmployees(con);

            updateSalary(con, 103, 85000);

            deleteEmployee(con, 104);

            countEmployees(con);

            highestSalaryEmployee(con);

            loginValidation(con, "rahul", "rahul123");

            departmentWiseEmployees(con);

            searchEmployeeProcedure(con, 101);

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void insertEmployees(Connection con) throws Exception {

        String query = "INSERT INTO Employees VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, 106);
        ps.setString(2, "Kunal");
        ps.setString(3, "HR");
        ps.setDouble(4, 55000);
        ps.setString(5, "kunal");
        ps.setString(6, "kunal123");
        ps.executeUpdate();

        System.out.println("Employee Inserted");
    }

    public static void fetchEmployees(Connection con) throws Exception {

        String query = "SELECT * FROM Employees WHERE salary > 50000";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            System.out.println(
                rs.getInt("emp_id") + " " +
                rs.getString("emp_name") + " " +
                rs.getDouble("salary")
            );
        }
    }

    public static void deleteEmployee(Connection con, int id) throws Exception {

        String query = "DELETE FROM Employees WHERE emp_id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        ps.executeUpdate();

        System.out.println("Employee Deleted");
    }

    public static void updateSalary(Connection con, int id, double salary) throws Exception {

        String query = "UPDATE Employees SET salary=? WHERE emp_id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setDouble(1, salary);
        ps.setInt(2, id);

        ps.executeUpdate();

        System.out.println("Salary Updated");
    }

    public static void countEmployees(Connection con) throws Exception {

        String query = "SELECT COUNT(*) FROM Employees";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            System.out.println("Total Employees: " + rs.getInt(1));
        }
    }

    public static void highestSalaryEmployee(Connection con) throws Exception {

        String query = "SELECT * FROM Employees WHERE salary=(SELECT MAX(salary) FROM Employees)";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            System.out.println(
                "Highest Salary Employee: " +
                rs.getString("emp_name")
            );
        }
    }

    public static void loginValidation(Connection con, String user, String pass) throws Exception {

        String query = "SELECT * FROM Employees WHERE username=? AND password=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, user);
        ps.setString(2, pass);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Login");
        }
    }

    public static void departmentWiseEmployees(Connection con) throws Exception {

        String query = "SELECT department, COUNT(*) FROM Employees GROUP BY department";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            System.out.println(
                rs.getString(1) + " : " + rs.getInt(2)
            );
        }
    }

    public static void searchEmployeeProcedure(Connection con, int id) throws Exception {

        CallableStatement cs = con.prepareCall("{call SearchEmployee(?)}");

        cs.setInt(1, id);

        ResultSet rs = cs.executeQuery();

        while(rs.next()) {
            System.out.println(
                rs.getInt("emp_id") + " " +
                rs.getString("emp_name")
            );
        }
    }
}
