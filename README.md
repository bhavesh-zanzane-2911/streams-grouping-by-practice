# Stream GroupingBy Practice

This project provides examples of utilizing Java Stream API's `groupingBy` collector to group objects based on certain criteria.

## Overview

The `StreamGroupingByPractice` class contains various methods for grouping employee details based on different attributes such as company name, employee name, and salary. Additionally, it demonstrates sorting employees within each group and finding employees with the highest and lowest salaries. The `EmployeeDetails` class represents the details of each employee.

## Methods

### 1. `getEmployeesGroupByCompanyInList(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns a map where the key is the company name and the value is a list of employees working for that company.

### 2. `getEmployeesGroupByNameInList(List<EmployeeDetails> employeeDetailsList)`

Groups employees by employee name and returns a map where the key is the employee name and the value is a list of their experiences.

### 3. `getEmployeesGroupByCompanyAndReturnSet(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns a map where the key is the company name and the value is a set of employees working for that company.

### 4. `getEmployeesGroupByCompanyAndReturnEmployeeCount(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns a map where the key is the company name and the value is the count of employees working for that company.

### 5. `getEmployeesGroupByCompanyAndSortByEmployeeNameAsc(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and sorts the employees in ascending order of their names within each group.

### 6. `getEmployeesGroupByCompanyAndSortBySalaryAsc(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and sorts the employees in ascending order of their salaries within each group.

### 7. `getEmployeesGroupByCompanyAndSortByEmployeeNameDesc(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and sorts the employees in descending order of their names within each group.

### 8. `getEmployeesGroupByCompanyAndSortBySalaryDesc(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and sorts the employees in descending order of their salaries within each group.

### 9. `getEmployeesGroupByCompanyAndReturnTheEmployeeWithHighestSalary(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns an employee with the highest salary from each group.

### 10. `getEmployeesGroupByCompanyAndReturnTheEmployeeWithHighestSalarySecondOption(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns an employee with the highest salary from each group using another approach.

### 11. `getEmployeesGroupByCompanyAndReturnTheEmployeeWithLowestSalary(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns an employee with the lowest salary from each group.

### 12. `getEmployeesGroupByCompanyAndReturnTheEmployeeWithLowestSalarySecondOption(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns an employee with the lowest salary from each group using another approach.

### 13. `getAverageSalaryOfEachDepartment(List<EmployeeDetails> employeeDetailsList)`

Groups employees by company name and returns the average salary of each department.

## Testing

The `StreamGroupingByPracticeTest` class contains unit tests for the methods in the `StreamGroupingByPractice` class, ensuring their correctness and functionality.

## Running the Tests

To run the tests, execute the test methods in the `StreamGroupingByPracticeTest` class.

## Dependencies

This project requires the `org.slf4j` library for logging purposes and the `org.junit.jupiter` library for testing.

