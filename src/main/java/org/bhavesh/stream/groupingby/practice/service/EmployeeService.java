package org.bhavesh.stream.groupingby.practice.service;

import org.bhavesh.stream.groupingby.practice.model.EmployeeExperience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeService {

    public  static List<EmployeeExperience> getEmployeeExperience(String employeeName){
        switch (employeeName) {
            case "Bhavesh" -> {
                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(101,"Bhavesh", "Amdocs", 2, Arrays.asList("Java", "Python")));
                employeeExperiences.add(new EmployeeExperience(201, "Bhavesh","MediaOcean", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(301, "Bhavesh","Citi", 4, Arrays.asList("Java", "Go")));
                return employeeExperiences;
            }
            case "Adesh" -> {

                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(401, "Adesh","Impetus", 2, Arrays.asList("Java", "C")));
                employeeExperiences.add(new EmployeeExperience(102, "Adesh","Amdocs", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(501, "Adesh","Morgan", 4, Arrays.asList("Java", "Go")));
                return employeeExperiences;

            }
            case "Yogita" -> {
                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(601, "Yogita","HSBC", 2, Arrays.asList("Java", "React")));
                employeeExperiences.add(new EmployeeExperience(103, "Yogita","Amdocs", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(701, "Yogita","HCL", 4, Arrays.asList("Java", "C")));
                return employeeExperiences;
            }

            case "Nutan" -> {
                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(104, "Nutan","Amdocs", 2, Arrays.asList("Java", "React")));
                employeeExperiences.add(new EmployeeExperience(801, "Nutan","Accolite", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(502, "Nutan","Morgan", 4, Arrays.asList("Java", "C")));
                return employeeExperiences;
            }

            case "Sachin" -> {
                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(105, "Sachin","Amdocs", 2, Arrays.asList("Java", "React")));
                employeeExperiences.add(new EmployeeExperience(702, "Sachin","HCL", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(602, "Sachin","HSBC", 4, Arrays.asList("Java", "C")));
                return employeeExperiences;
            }
        }
        return new ArrayList<>();

    }

}
