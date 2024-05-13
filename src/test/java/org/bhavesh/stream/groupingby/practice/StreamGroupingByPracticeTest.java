package org.bhavesh.stream.groupingby.practice;

import org.bhavesh.stream.groupingby.practice.model.EmployeeExperience;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamGroupingByPracticeTest {

    private static final Logger LOG = LoggerFactory.getLogger(StreamGroupingByPracticeTest.class);

    @Test
    void testGetEmployeesGroupByCompany() {
        //Given
        List<EmployeeExperience> employeeExperienceList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeExperience>> employeesGroupByCompany = StreamGroupingByPractice.getEmployeesGroupByCompanyInList(employeeExperienceList);

        //Then
        assertEquals(8, employeesGroupByCompany.size(), "total unique companies are 8");
        assertEquals(5, employeesGroupByCompany.get("Amdocs").size(), "total employees worked in Amdocs 5");
    }

    @Test
    void testGetEmployeesGroupingByEmployeeName() {
        //Given
        List<EmployeeExperience> employeeExperienceList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeExperience>> employeesGroupByEmployeeName = StreamGroupingByPractice.getEmployeesGroupByNameInList(employeeExperienceList);

        //Then
        assertEquals(5, employeesGroupByEmployeeName.size(), "total employees are 5");
        assertEquals(3, employeesGroupByEmployeeName.get("Bhavesh").size(), "Bhavesh has worked for 3 companies as of now");

    }


    @Test
    void testGetEmployeesGroupByCompanyAndReturnSet() {

        //Given
        List<EmployeeExperience> employeeExperienceList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Set<EmployeeExperience>> employeesGroupByCompany = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnSet(employeeExperienceList);

        //Then
        assertEquals(8, employeesGroupByCompany.size(), "total employees are 8");
        assertEquals(1, employeesGroupByCompany.get("MediaOcean").size(), "Bhavesh has worked for mediaocean");

    }

    @Test
    void getEmployeesGroupByCompanyAndReturnEmployeeCount() {

        //Given
        List<EmployeeExperience> employeeExperienceList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Long> employeesGroupByCompany = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnEmployeeCount(employeeExperienceList);

        //Then
        assertEquals(8, employeesGroupByCompany.size(), "total employees are 8");
        assertEquals(2, employeesGroupByCompany.get("HCL"), "Yogita and Sachin has worked for mediaocean");

    }

    @Test
    void testGetEmployeesGroupByCompanyAndSortByEmployeeNameAsc() {
        //Given
        List<EmployeeExperience> employeeExperienceList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeExperience>> employeesGroupByCompanyAndSortByEmployeeName = StreamGroupingByPractice.getEmployeesGroupByCompanyAndSortByEmployeeNameAsc(employeeExperienceList);

        //Then
        assertEquals(8, employeesGroupByCompanyAndSortByEmployeeName.size(), "total companies are 8");
        assertEquals(2, employeesGroupByCompanyAndSortByEmployeeName.get("HCL").size(), "Yogita and Sachin has worked for mediaocean");
        assertEquals("Sachin", employeesGroupByCompanyAndSortByEmployeeName.get("HCL").get(0).getEmployeeName(), "Sachin comes first in ascending order for HCL");

    }

    @Test
    void testGetEmployeesGroupByCompanyAndSortByEmployeeNameDesc() {
        //Given
        List<EmployeeExperience> employeeExperienceList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeExperience>> employeesGroupByCompanyAndSortByEmployeeName = StreamGroupingByPractice.getEmployeesGroupByCompanyAndSortByEmployeeNameDesc(employeeExperienceList);

        //Then
        assertEquals(8, employeesGroupByCompanyAndSortByEmployeeName.size(), "total companies are 8");
        assertEquals(2, employeesGroupByCompanyAndSortByEmployeeName.get("HCL").size(), "Yogita and Sachin has worked for HCL");
        assertEquals("Yogita", employeesGroupByCompanyAndSortByEmployeeName.get("HCL").get(0).getEmployeeName(), "Yogita comes first in descending order for HCL");

    }
}