create database EmployeeDetails;
USE EmployeeDetails;
CREATE TABLE Employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(100),
    department VARCHAR(50),
    salary DECIMAL(10,2),
    email VARCHAR(100),
    joining_date DATE
);
INSERT INTO Employees (emp_name, department, salary, email, joining_date)
VALUES
('Rohit', 'IT', 30000, 'rohit@gmail.com', '2024-01-10'),
('Hardik', 'HR', 40000, 'hardik@gmail.com', '2023-11-15'),
('Surya', 'Testing', 30000, NULL, '2024-03-20'),
('Virat', 'IT', 30000, 'virat@gmail.com', '2022-09-18'),
('Rahul', 'Testing', 30000, 'rahul@gmail.com', '2023-05-11');
Select *from Employees where department = 'IT';

Update Employees set salary = salary + 5000 where department = 'Testing'
and emp_id>0;

Delete from Employees where emp_id=3;

Select *from employees order by salary desc;

Select *from employees order by salary desc limit 2;

Select count(*) as total_employees from Employees;

SELECT AVG(salary) AS average_salary FROM Employees;

SELECT MAX(salary) AS highest_salary, MIN(salary) AS lowest_salary
FROM Employees;

SELECT department, COUNT(*) AS total_employees FROM Employees
GROUP BY department;

SELECT department, COUNT(*) AS total_employees FROM Employees
GROUP BY department HAVING COUNT(*) > 1;

SELECT * FROM Employees WHERE email IS NULL;

SELECT * FROM Employees WHERE emp_name LIKE 'R%';

SELECT * FROM Employees WHERE salary BETWEEN 40000 AND 60000;

SELECT * FROM Employees WHERE department IN ('HR', 'IT');

ALTER TABLE Employees ADD mobile_number VARCHAR(15);

ALTER TABLE Employees RENAME COLUMN emp_name TO employee_name;

ALTER TABLE Employees DROP COLUMN mobile_number;

TRUNCATE TABLE Employees;

DROP TABLE Employees;

CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    department_name VARCHAR(50)
);

INSERT INTO Department VALUES
(1, 'IT'),
(2, 'HR'),
(3, 'Testing');

ALTER TABLE Employees ADD dept_id INT;

SELECT emp_name, department_name FROM Employees e JOIN Department d
ON e.dept_id = d.dept_id;

SELECT * FROM Employees WHERE salary > (SELECT AVG(salary)
FROM Employees);

SELECT email, COUNT(*) AS total FROM Employees GROUP BY email
HAVING COUNT(*) > 1;

SELECT * FROM Employees;

DELETE FROM Employees WHERE email IS NULL and emp_id>0;

CREATE TABLE Employees_Backup AS SELECT * FROM Employees;