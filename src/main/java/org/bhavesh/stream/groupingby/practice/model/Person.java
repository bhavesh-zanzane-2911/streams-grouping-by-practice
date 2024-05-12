package org.bhavesh.stream.groupingby.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Person {

    private Integer addharNo;
    private String name;
    private List<EmployeeExperience> totalExperience;
}
