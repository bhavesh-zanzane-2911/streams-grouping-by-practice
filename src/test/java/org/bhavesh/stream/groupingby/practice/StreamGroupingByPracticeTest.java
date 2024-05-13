package org.bhavesh.stream.groupingby.practice;

import org.bhavesh.stream.groupingby.practice.model.EmployeeDetails;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamGroupingByPracticeTest {

    private static final Logger LOG = LoggerFactory.getLogger(StreamGroupingByPracticeTest.class);

    @Test
    void testGetEmployeesGroupByCompany() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeDetails>> employeesGroupByCompany = StreamGroupingByPractice.getEmployeesGroupByCompanyInList(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompany.size(), "total unique companies are 8");
        assertEquals(5, employeesGroupByCompany.get("Amdocs").size(), "total employees worked in Amdocs 5");
    }

    @Test
    void testGetEmployeesGroupingByEmployeeName() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeDetails>> employeesGroupByEmployeeName = StreamGroupingByPractice.getEmployeesGroupByNameInList(employeeDetailsList);

        //Then
        assertEquals(5, employeesGroupByEmployeeName.size(), "total employees are 5");
        assertEquals(3, employeesGroupByEmployeeName.get("Bhavesh").size(), "Bhavesh has worked for 3 companies as of now");

    }


    @Test
    void testGetEmployeesGroupByCompanyAndReturnSet() {

        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Set<EmployeeDetails>> employeesGroupByCompany = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnSet(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompany.size(), "total employees are 8");
        assertEquals(1, employeesGroupByCompany.get("MediaOcean").size(), "Bhavesh has worked for mediaocean");

    }

    @Test
    void getEmployeesGroupByCompanyAndReturnEmployeeCount() {

        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Long> employeesGroupByCompany = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnEmployeeCount(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompany.size(), "total employees are 8");
        assertEquals(2, employeesGroupByCompany.get("HCL"), "Yogita and Sachin has worked for mediaocean");

    }

    @Test
    void testGetEmployeesGroupByCompanyAndSortByEmployeeNameAsc() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyAndSortByEmployeeName = StreamGroupingByPractice.getEmployeesGroupByCompanyAndSortByEmployeeNameAsc(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompanyAndSortByEmployeeName.size(), "total companies are 8");
        assertEquals(2, employeesGroupByCompanyAndSortByEmployeeName.get("HCL").size(), "Yogita and Sachin has worked for mediaocean");
        assertEquals("Sachin", employeesGroupByCompanyAndSortByEmployeeName.get("HCL").get(0).getEmployeeName(), "Sachin comes first in ascending order for HCL");

    }

    @Test
    void testGetEmployeesGroupByCompanyAndSortBySalaryAsc() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyAndSortBySalaryAsc = StreamGroupingByPractice.getEmployeesGroupByCompanyAndSortBySalaryAsc(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompanyAndSortBySalaryAsc.size(), "total companies are 8");
        assertEquals(5, employeesGroupByCompanyAndSortBySalaryAsc.get("Amdocs").size(), "5 employees has worked for Amdocs");
        assertEquals("Bhavesh", employeesGroupByCompanyAndSortBySalaryAsc.get("Amdocs").get(0).getEmployeeName(), "Bhavesh comes first in ascending order for Salary at Amdocs");

    }

    @Test
    void testGetEmployeesGroupByCompanyAndSortByEmployeeNameDesc() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyAndSortByEmployeeName = StreamGroupingByPractice.getEmployeesGroupByCompanyAndSortByEmployeeNameDesc(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompanyAndSortByEmployeeName.size(), "total companies are 8");
        assertEquals(2, employeesGroupByCompanyAndSortByEmployeeName.get("HCL").size(), "Yogita and Sachin has worked for HCL");
        assertEquals("Yogita", employeesGroupByCompanyAndSortByEmployeeName.get("HCL").get(0).getEmployeeName(), "Yogita comes first in descending order for HCL");

    }

    @Test
    void testGetEmployeesGroupByCompanyAndSortBySalaryDesc() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, List<EmployeeDetails>> employeesGroupByCompanyAndSortBySalaryDesc = StreamGroupingByPractice.getEmployeesGroupByCompanyAndSortBySalaryDesc(employeeDetailsList);

        //Then
        assertEquals(8, employeesGroupByCompanyAndSortBySalaryDesc.size(), "total companies are 8");
        assertEquals(5, employeesGroupByCompanyAndSortBySalaryDesc.get("Amdocs").size(), "5 employees has worked for Amdocs");
        assertEquals("Nutan", employeesGroupByCompanyAndSortBySalaryDesc.get("Amdocs").get(0).getEmployeeName(), "Bhavesh comes first in descending order for Salary at Amdocs");

    }

    @Test
    void testGetEmployeeWithHighestSalaryFromEachDepartment() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, EmployeeDetails> employeeWithHighestSalary = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnTheEmployeeWithHighestSalary(employeeDetailsList);

        //Then
        assertEquals(8, employeeWithHighestSalary.size(), "total companies are 8");
        assertEquals("Nutan", employeeWithHighestSalary.get("Amdocs").getEmployeeName(), "Nutan has highest salary from Amdocs");
        assertEquals(1450000.0, employeeWithHighestSalary.get("Amdocs").getSalary(), "Highest salary of Nutan is 1450000.0 from Amdocs");
        assertEquals("Sachin", employeeWithHighestSalary.get("HCL").getEmployeeName(), "Sachin has highest salary from HCL");
        assertEquals(1600000.0, employeeWithHighestSalary.get("HCL").getSalary(), "Highest salary of sachin is 1600000 from HCL");

    }

    @Test
    void testGetEmployeeWithHighestSalaryFromEachDepartmentSecondOption() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Optional<EmployeeDetails>> employeeWithHighestSalary = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnTheEmployeeWithHighestSalarySecondOption(employeeDetailsList);

        //Then
        assertEquals(8, employeeWithHighestSalary.size(), "total companies are 8");
        assertEquals("Nutan", employeeWithHighestSalary.get("Amdocs").get().getEmployeeName(), "Nutan has highest salary from Amdocs");
        assertEquals(1450000.0, employeeWithHighestSalary.get("Amdocs").get().getSalary(), "Highest salary of Nutan is 1450000.0 from Amdocs");
        assertEquals("Sachin", employeeWithHighestSalary.get("HCL").get().getEmployeeName(), "Sachin has highest salary from HCL");
        assertEquals(1600000.0, employeeWithHighestSalary.get("HCL").get().getSalary(), "Highest salary of sachin is 1600000 from HCL");

    }

    @Test
    void testGetEmployeeWithLowestSalaryFromEachDepartment() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, EmployeeDetails> employeeWithLowestSalary = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnTheEmployeeWithLowestSalary(employeeDetailsList);

        //Then
        assertEquals(8, employeeWithLowestSalary.size(), "total companies are 8");
        assertEquals("Bhavesh", employeeWithLowestSalary.get("Amdocs").getEmployeeName(), "Bhavesh has lowest salary from Amdocs");
        assertEquals(1000000.0, employeeWithLowestSalary.get("Amdocs").getSalary(), "lowest salary of Bhavesh is 1450000.0 from Amdocs");
        assertEquals("Yogita", employeeWithLowestSalary.get("HCL").getEmployeeName(), "Yogita has lowest salary from HCL");
        assertEquals(700000.0, employeeWithLowestSalary.get("HCL").getSalary(), "Lowest salary of sachin is 1600000 from HCL");

    }

    @Test
    void testGetEmployeeWithLowestSalaryFromEachDepartmentSecondOption() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Optional<EmployeeDetails>> employeeWithLowestSalary = StreamGroupingByPractice.getEmployeesGroupByCompanyAndReturnTheEmployeeWithLowestSalarySecondOption(employeeDetailsList);

        //Then
        assertEquals(8, employeeWithLowestSalary.size(), "total companies are 8");
        assertEquals("Bhavesh", employeeWithLowestSalary.get("Amdocs").get().getEmployeeName(), "Bhavesh has lowest salary from Amdocs");
        assertEquals(1000000.0, employeeWithLowestSalary.get("Amdocs").get().getSalary(), "lowest salary of Bhavesh is 1450000.0 from Amdocs");
        assertEquals("Yogita", employeeWithLowestSalary.get("HCL").get().getEmployeeName(), "Yogita has lowest salary from HCL");
        assertEquals(700000.0, employeeWithLowestSalary.get("HCL").get().getSalary(), "Lowest salary of sachin is 1600000 from HCL");

    }

    @Test
    void testGetEmployeeWithAverageSalaryFromEachDepartment() {
        //Given
        List<EmployeeDetails> employeeDetailsList = StreamGroupingByPractice.getEmployeeExperienceList();

        //When
        Map<String, Double> averageSalaryOfEachDepartment = StreamGroupingByPractice.getAverageSalaryOfEachDepartment(employeeDetailsList);

        //Then
        assertEquals(8, averageSalaryOfEachDepartment.size(), "total companies are 8");
        assertEquals(1190000.0, averageSalaryOfEachDepartment.get("Amdocs"), "Average salary of Amdocs  is 1190000.0");
        assertEquals(1150000.0, averageSalaryOfEachDepartment.get("HCL"), "Average salary of HCL is 1150000.0");

    }

}