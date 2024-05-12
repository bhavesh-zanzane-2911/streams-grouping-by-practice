package org.bhavesh.stream.groupingby.practice.service;

import org.bhavesh.stream.groupingby.practice.model.Person;

import java.util.Arrays;
import java.util.List;

import static org.bhavesh.stream.groupingby.practice.service.EmployeeService.*;

public class PersonService {

    public static List<Person> getPersonsList(){
        Person p1=new Person(1, "Bhavesh",getEmployeeExperience("Bhavesh"));
        Person p2=new Person(2, "Adesh",getEmployeeExperience("Adesh"));
        Person p3=new Person(3, "Yogita",getEmployeeExperience("Yogita"));
        return Arrays.asList(p1,p2,p3);
    }



}
