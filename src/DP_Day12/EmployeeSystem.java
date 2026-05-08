package DP_Day12;

import java.io.*;

public class EmployeeSystem {

    public static void main(String[] args) {

        Employee emp = new Employee(
                101,
                "Pratyush",
                "Software Development",
                "Java Developer",
                "Pratyush@gmail.com",
                "9876543210",
                "10-Jan-2025",
                "Kolkata Office",
                65000,
                10000
        );

        emp.addReport("Completed Java Project");
        emp.addReport("Attended Team Meeting");
        emp.addReport("Performance Rated Excellent");
        emp.addReport("Received Employee Bonus");

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("employee.txt"));

            out.writeObject(emp);

            out.close();

            System.out.println("Employee Object Saved Successfully!");

        }

        catch (IOException e) {

            System.out.println(e);
        }

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("employee.txt"));

            Employee e =
                    (Employee) in.readObject();

            in.close();

            System.out.println("\nEmployee Object Read Successfully!");

            e.displayEmployee();

        }

        catch (Exception e1) {

            System.out.println(e1);
        }
    }
}