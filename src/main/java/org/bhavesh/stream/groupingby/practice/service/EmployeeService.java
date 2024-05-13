package org.bhavesh.stream.groupingby.practice.service;

import org.bhavesh.stream.groupingby.practice.model.EmployeeDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeService {

    public  static List<EmployeeDetails> getEmployeeExperience(String employeeName){
        switch (employeeName) {
            case "Bhavesh" -> {
                List<EmployeeDetails> employeeDetails = new ArrayList<>();
                employeeDetails.add(new EmployeeDetails(101,"Bhavesh", "Amdocs", 2,1000000.0, Arrays.asList("Java", "Python")));
                employeeDetails.add(new EmployeeDetails(201, "Bhavesh","MediaOcean", 3,1100000.0, Arrays.asList("Java", "CPP")));
                employeeDetails.add(new EmployeeDetails(301, "Bhavesh","Citi", 4,1200000.0, Arrays.asList("Java", "Go")));
                return employeeDetails;
            }
            case "Adesh" -> {

                List<EmployeeDetails> employeeDetails = new ArrayList<>();
                employeeDetails.add(new EmployeeDetails(401, "Adesh","Impetus", 2,1300000.0, Arrays.asList("Java", "C")));
                employeeDetails.add(new EmployeeDetails(102, "Adesh","Amdocs", 3, 1400000.0,Arrays.asList("Java", "CPP")));
                employeeDetails.add(new EmployeeDetails(501, "Adesh","Morgan", 4, 1500000.0,Arrays.asList("Java", "Go")));
                return employeeDetails;

            }
            case "Yogita" -> {
                List<EmployeeDetails> employeeDetails = new ArrayList<>();
                employeeDetails.add(new EmployeeDetails(601, "Yogita","HSBC", 2, 1700000.0,Arrays.asList("Java", "React")));
                employeeDetails.add(new EmployeeDetails(103, "Yogita","Amdocs", 3, 1000000.0,Arrays.asList("Java", "CPP")));
                employeeDetails.add(new EmployeeDetails(701, "Yogita","HCL", 4, 700000.0,Arrays.asList("Java", "C")));
                return employeeDetails;
            }

            case "Nutan" -> {
                List<EmployeeDetails> employeeDetails = new ArrayList<>();
                employeeDetails.add(new EmployeeDetails(104, "Nutan","Amdocs", 2,1450000.0, Arrays.asList("Java", "React")));
                employeeDetails.add(new EmployeeDetails(801, "Nutan","Accolite", 3, 1900000.0,Arrays.asList("Java", "CPP")));
                employeeDetails.add(new EmployeeDetails(502, "Nutan","Morgan", 4, 1700000.0,Arrays.asList("Java", "C")));
                return employeeDetails;
            }

            case "Sachin" -> {
                List<EmployeeDetails> employeeDetails = new ArrayList<>();
                employeeDetails.add(new EmployeeDetails(105, "Sachin","Amdocs", 2, 1100000.0,Arrays.asList("Java", "React")));
                employeeDetails.add(new EmployeeDetails(702, "Sachin","HCL", 3, 1600000.0,Arrays.asList("Java", "CPP")));
                employeeDetails.add(new EmployeeDetails(602, "Sachin","HSBC", 4, 1800000.0,Arrays.asList("Java", "C")));
                return employeeDetails;
            }
        }
        return new ArrayList<>();

    }

}
