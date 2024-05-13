package org.bhavesh.stream.groupingby.practice;

import org.bhavesh.stream.groupingby.practice.model.EmployeeDetails;
import org.bhavesh.stream.groupingby.practice.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingByPractice {

    private static final Logger LOG = LoggerFactory.getLogger(StreamGroupingByPractice.class);

    public static List<EmployeeDetails> getEmployeeExperienceList(){

        return PersonService.getPersonsList()
                .stream()
                .flatMap(person -> person.getEmploymentDetailList().stream())
                .toList();

    }

    /**
     * This method return employees group by company name
     * @param employeeDetailsList the list of employees and their detail
     * @return map of key-value pair where key is company name and value is their employees
     */

    public static Map<String, List<EmployeeDetails>> getEmployeesGroupByCompanyInList(List<EmployeeDetails> employeeDetailsList) {
        Map<String, List<EmployeeDetails>> employeesGroupByCompany = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName, Collectors.toList()));
        employeesGroupByCompany.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompany;
    }

    /**
     * This method return employees group by employee name
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is employee name and value is their experiences
     */

    public static Map<String, List<EmployeeDetails>> getEmployeesGroupByNameInList(List<EmployeeDetails> employeeDetailsList) {

        Map<String, List<EmployeeDetails>> employeesGroupByName = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getEmployeeName, Collectors.toList()));
        employeesGroupByName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByName;
    }

    /**
     * This method return employees group by company name
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employees
     */

    public static Map<String, Set<EmployeeDetails>> getEmployeesGroupByCompanyAndReturnSet(List<EmployeeDetails> employeeDetailsList) {
        Map<String, Set<EmployeeDetails>> employeesGroupByCompany = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName, Collectors.toSet()));
        employeesGroupByCompany.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompany;
    }

    /**
     * This method return employees group by company name
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employees count
     */

    public static Map<String, Long> getEmployeesGroupByCompanyAndReturnEmployeeCount(List<EmployeeDetails> employeeDetailsList) {
        Map<String, Long> employeesGroupByCompany = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName, Collectors.counting()));
        employeesGroupByCompany.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompany;
    }

    /**
     * This method return employees group by company name and sort by employee name in Ascending order
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employees in Ascending order of their name
     */


    public static Map<String, List<EmployeeDetails>> getEmployeesGroupByCompanyAndSortByEmployeeNameAsc(List<EmployeeDetails> employeeDetailsList) {
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyNameAndSortByEmployeeName = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .sorted(Comparator.comparing(EmployeeDetails::getEmployeeName))
                                .toList()
                        )));
        employeesGroupByCompanyNameAndSortByEmployeeName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompanyNameAndSortByEmployeeName;
    }

    /**
     * This method return employees group by company name and sort by employee according to salary in Ascending order
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employees in Ascending order of their salary
     */


    public static Map<String, List<EmployeeDetails>> getEmployeesGroupByCompanyAndSortBySalaryAsc(List<EmployeeDetails> employeeDetailsList) {
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyNameAndSortByEmployeeName = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .sorted(Comparator.comparing(EmployeeDetails::getSalary))
                                .toList()
                        )));
        employeesGroupByCompanyNameAndSortByEmployeeName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompanyNameAndSortByEmployeeName;
    }

    /**
     * This method return employees group by company name and sort by employee name in Descending order
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employees in Descending order of their name
     */
    public static Map<String, List<EmployeeDetails>> getEmployeesGroupByCompanyAndSortByEmployeeNameDesc(List<EmployeeDetails> employeeDetailsList) {
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyNameAndSortByEmployeeName = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .sorted(Comparator.comparing(EmployeeDetails::getEmployeeName).reversed())
                                .toList()
                        )));
        employeesGroupByCompanyNameAndSortByEmployeeName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompanyNameAndSortByEmployeeName;
    }

    /**
     * This method return employees group by company name and sort by employee salary in Descending order
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employees in Descending order of their salary
     */
    public static Map<String, List<EmployeeDetails>> getEmployeesGroupByCompanyAndSortBySalaryDesc(List<EmployeeDetails> employeeDetailsList) {
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyNameAndSortByEmployeeName = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .sorted(Comparator.comparing(EmployeeDetails::getSalary).reversed())
                                .toList()
                        )));
        employeesGroupByCompanyNameAndSortByEmployeeName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompanyNameAndSortByEmployeeName;
    }

    /**
     * This method return employees group by company name and return an employee whose salary is highest in compartment
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employee with highest salary
     */
    public static Map<String, EmployeeDetails> getEmployeesGroupByCompanyAndReturnTheEmployeeWithHighestSalary(List<EmployeeDetails> employeeDetailsList) {
        Map<String, EmployeeDetails> employeeWithHighestSalaryFromEachDepartment = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                .max(Comparator.comparing(EmployeeDetails::getSalary))
                                .get()
                        )));
        employeeWithHighestSalaryFromEachDepartment.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeeWithHighestSalaryFromEachDepartment;
    }

    /**
     * This method return employees group by company name and return an employee whose salary is highest in compartment
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employee with highest salary
     */
    public static Map<String, Optional<EmployeeDetails>> getEmployeesGroupByCompanyAndReturnTheEmployeeWithHighestSalarySecondOption(List<EmployeeDetails> employeeDetailsList) {
        Map<String, Optional<EmployeeDetails>> employeesWithHighestSalaryFromEachDepartment = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.maxBy(Comparator.comparing(EmployeeDetails::getSalary))));
        employeesWithHighestSalaryFromEachDepartment.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesWithHighestSalaryFromEachDepartment;
    }

    /**
     * This method return employees group by company name and return an employee whose salary is lowest in company
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employee with lowest salary
     */
    public static Map<String, EmployeeDetails> getEmployeesGroupByCompanyAndReturnTheEmployeeWithLowestSalary(List<EmployeeDetails> employeeDetailsList) {
        Map<String, EmployeeDetails> employeeWithLowestSalaryFromEachDepartment = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                .min(Comparator.comparing(EmployeeDetails::getSalary))
                                .get()
                        )));
        employeeWithLowestSalaryFromEachDepartment.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeeWithLowestSalaryFromEachDepartment;
    }

    /**
     * This method return employees group by company name and return an employee whose salary is lowest in company
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is their employee with lowest salary
     */
    public static Map<String, Optional<EmployeeDetails>> getEmployeesGroupByCompanyAndReturnTheEmployeeWithLowestSalarySecondOption(List<EmployeeDetails> employeeDetailsList) {
        Map<String, Optional<EmployeeDetails>> employeeWithLowestSalaryFromEachDepartment = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.minBy(Comparator.comparing(EmployeeDetails::getSalary))));
        employeeWithLowestSalaryFromEachDepartment.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeeWithLowestSalaryFromEachDepartment;
    }

    /**
     * This method return employees group by company name and return an average salary of each department
     * @param employeeDetailsList the list of employees and their details
     * @return map of key-value pair where key is company name and value is an average salary of each department
     */
    public static Map<String, Double> getAverageSalaryOfEachDepartment(List<EmployeeDetails> employeeDetailsList) {
        Map<String, Double> averageSalaryFromEachDepartment = employeeDetailsList
                .stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getCompanyName,
                        Collectors.averagingDouble(EmployeeDetails::getSalary)));
        averageSalaryFromEachDepartment.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return averageSalaryFromEachDepartment;
    }
}