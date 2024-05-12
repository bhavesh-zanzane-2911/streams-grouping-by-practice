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
                employeeExperiences.add(new EmployeeExperience(101, "Amdocs", 2, Arrays.asList("Java", "Python")));
                employeeExperiences.add(new EmployeeExperience(102, "MediaOcean", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(103, "Citi", 4, Arrays.asList("Java", "Go")));
                return employeeExperiences;
            }
            case "Adesh" -> {

                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(201, "Impetus", 2, Arrays.asList("Java", "C")));
                employeeExperiences.add(new EmployeeExperience(202, "Amdocs", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(203, "Morgan", 4, Arrays.asList("Java", "Go")));
                return employeeExperiences;

            }
            case "Yogita" -> {
                List<EmployeeExperience> employeeExperiences = new ArrayList<>();
                employeeExperiences.add(new EmployeeExperience(301, "HSBC", 2, Arrays.asList("Java", "React")));
                employeeExperiences.add(new EmployeeExperience(302, "Amdocs", 3, Arrays.asList("Java", "CPP")));
                employeeExperiences.add(new EmployeeExperience(303, "HCL", 4, Arrays.asList("Java", "C")));
                return employeeExperiences;
            }
        }
        return new ArrayList<>();

    }

}
