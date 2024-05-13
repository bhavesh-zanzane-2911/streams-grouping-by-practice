package org.bhavesh.stream.groupingby.practice;

import org.bhavesh.stream.groupingby.practice.model.EmployeeExperience;
import org.bhavesh.stream.groupingby.practice.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingByPractice {

    private static final Logger LOG = LoggerFactory.getLogger(StreamGroupingByPractice.class);

    public static List<EmployeeExperience> getEmployeeExperienceList(){

        return PersonService.getPersonsList()
                .stream()
                .flatMap(person -> person.getTotalExperience().stream())
                .toList();

    }

    /**
     * This method return employees group by company name
     * @param employeeExperienceList the list of employees and their experience
     * @return map of key-value pair where key is company name and value is their employees
     */

    public static Map<String, List<EmployeeExperience>> getEmployeesGroupByCompanyInList(List<EmployeeExperience> employeeExperienceList) {
        Map<String, List<EmployeeExperience>> employeesGroupByCompany = employeeExperienceList
                .stream()
                .collect(Collectors.groupingBy(EmployeeExperience::getCompanyName, Collectors.toList()));
        employeesGroupByCompany.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompany;
    }

    /**
     * This method return employees group by employee name
     * @param employeeExperienceList the list of employees and their experience
     * @return map of key-value pair where key is employee name and value is their experiences
     */

    public static Map<String, List<EmployeeExperience>> getEmployeesGroupByNameInList(List<EmployeeExperience> employeeExperienceList) {

        Map<String, List<EmployeeExperience>> employeesGroupByName = employeeExperienceList
                .stream()
                .collect(Collectors.groupingBy(EmployeeExperience::getEmployeeName, Collectors.toList()));
        employeesGroupByName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByName;
    }

    /**
     * This method return employees group by company name
     * @param employeeExperienceList the list of employees and their experience
     * @return map of key-value pair where key is company name and value is their employees
     */

    public static Map<String, Set<EmployeeExperience>> getEmployeesGroupByCompanyAndReturnSet(List<EmployeeExperience> employeeExperienceList) {
        Map<String, Set<EmployeeExperience>> employeesGroupByCompany = employeeExperienceList
                .stream()
                .collect(Collectors.groupingBy(EmployeeExperience::getCompanyName, Collectors.toSet()));
        employeesGroupByCompany.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompany;
    }

    /**
     * This method return employees group by company name
     * @param employeeExperienceList the list of employees and their experience
     * @return map of key-value pair where key is company name and value is their employees count
     */

    public static Map<String, Long> getEmployeesGroupByCompanyAndReturnEmployeeCount(List<EmployeeExperience> employeeExperienceList) {
        Map<String, Long> employeesGroupByCompany = employeeExperienceList
                .stream()
                .collect(Collectors.groupingBy(EmployeeExperience::getCompanyName, Collectors.counting()));
        employeesGroupByCompany.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompany;
    }

    /**
     * This method return employees group by company name and sort by employee name in Ascending order
     * @param employeeExperienceList the list of employees and their experience
     * @return map of key-value pair where key is company name and value is their employees in Ascending order of their name
     */


    public static Map<String, List<EmployeeExperience>> getEmployeesGroupByCompanyAndSortByEmployeeNameAsc(List<EmployeeExperience> employeeExperienceList) {
        Map<String, List<EmployeeExperience>> employeesGroupByCompanyNameAndSortByEmployeeName = employeeExperienceList
                .stream()
                .collect(Collectors.groupingBy(EmployeeExperience::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .sorted(Comparator.comparing(EmployeeExperience::getEmployeeName))
                                .toList()
                        )));
        employeesGroupByCompanyNameAndSortByEmployeeName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompanyNameAndSortByEmployeeName;
    }

    /**
     * This method return employees group by company name and sort by employee name in Descending order
     * @param employeeExperienceList the list of employees and their experience
     * @return map of key-value pair where key is company name and value is their employees in Descending order of their name
     */
    public static Map<String, List<EmployeeExperience>> getEmployeesGroupByCompanyAndSortByEmployeeNameDesc(List<EmployeeExperience> employeeExperienceList) {
        Map<String, List<EmployeeExperience>> employeesGroupByCompanyNameAndSortByEmployeeName = employeeExperienceList
                .stream()
                .collect(Collectors.groupingBy(EmployeeExperience::getCompanyName,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .sorted(Comparator.comparing(EmployeeExperience::getEmployeeName).reversed())
                                .toList()
                        )));
        employeesGroupByCompanyNameAndSortByEmployeeName.forEach((key, value) -> LOG.info("{} : {}", key, value));
        return employeesGroupByCompanyNameAndSortByEmployeeName;
    }
}