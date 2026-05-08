package DP_Day12;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Employee implements Serializable {

    private int empId;
    private String empName;
    private String department;
    private String designation;
    private String email;
    private String phoneNumber;
    private String joiningDate;
    private String officeLocation;
    private double salary;
    private double bonus;

    private ArrayList<String> workReports =
            new ArrayList<>();

    public Employee(int empId,
                    String empName,
                    String department,
                    String designation,
                    String email,
                    String phoneNumber,
                    String joiningDate,
                    String officeLocation,
                    double salary,
                    double bonus) {

        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.joiningDate = joiningDate;
        this.officeLocation = officeLocation;
        this.salary = salary;
        this.bonus = bonus;

        workReports.add("Employee Joined Company");
    }

    public void addReport(String report) {
        workReports.add(report);
    }

    public void displayEmployee() {

        System.out.println("\n========== EMPLOYEE DETAILS ==========");

        System.out.println("Employee ID      : " + empId);
        System.out.println("Employee Name    : " + empName);
        System.out.println("Department       : " + department);
        System.out.println("Designation      : " + designation);
        System.out.println("Email            : " + email);
        System.out.println("Phone Number     : " + phoneNumber);
        System.out.println("Joining Date     : " + joiningDate);
        System.out.println("Office Location  : " + officeLocation);
        System.out.println("Salary           : " + salary);
        System.out.println("Bonus            : " + bonus);

        System.out.println("\n========== WORK REPORTS ==========");

        for (String r : workReports) {
            System.out.println(r);
        }
    }
}