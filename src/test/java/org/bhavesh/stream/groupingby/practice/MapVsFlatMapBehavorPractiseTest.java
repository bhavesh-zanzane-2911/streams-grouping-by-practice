package org.bhavesh.stream.groupingby.practice;

import org.bhavesh.stream.groupingby.practice.model.EmployeeExperience;
import org.bhavesh.stream.groupingby.practice.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapVsFlatMapBehavorPractiseTest {

    @Test
    void testGetPersonWhoseNameIsBhavesh() {
        //Given
        String personName = "Bhavesh";

        //When
        Person personWhoseNameIsBhavesh = MapVsFlatMapBehavorPractise.getPersonByName(personName);

        //Then
        assertNotNull(personWhoseNameIsBhavesh, "Person with name bhavesh is found");
        assertEquals(1, personWhoseNameIsBhavesh.getAddharNo(), "addhar no should be 1");
        assertEquals(3, personWhoseNameIsBhavesh.getTotalExperience().size(), "total companies for which he worked is 3");
    }


    @Test
    void testGetAddharNumberWhoseNameIsBhavesh() {
        //Given
        String personName = "Bhavesh";

        //When
        Integer addharNumberOfBhavesh = MapVsFlatMapBehavorPractise.getAddharNumberByName(personName);

        //Then
        assertNotNull(addharNumberOfBhavesh, "Addhar no is not null");
        assertEquals(1, addharNumberOfBhavesh, "addhar no should be 1");
    }

    @Test
    void testGetExperienceOfBhavesh() {
        //Given
        String personName = "Bhavesh";

        //When
        List<List<EmployeeExperience>> listOfListExperiencesOfBhavesh = MapVsFlatMapBehavorPractise.getExperienceByNameUsingMap(personName);

        List<EmployeeExperience> listOfExperiencesOfBhavesh = MapVsFlatMapBehavorPractise.getExperienceByNameUsingFlatMap(personName);

        //Then
        assertNotNull(listOfListExperiencesOfBhavesh, "Addhar no is not null");
        assertEquals(3, listOfListExperiencesOfBhavesh.get(0).size(), "no of experiences are 3");
        assertNotNull(listOfExperiencesOfBhavesh, "Addhar no is not null");
        assertEquals(3, listOfExperiencesOfBhavesh.size(), "no of experiences are 3");
    }

    @Test
    void testGetCompaniesForWhichPersonWorked() {
        //Given
        String personName = "Bhavesh";

        //When
        List<String> listOfCompaniesOfBhavesh = MapVsFlatMapBehavorPractise.getCompaniesByNameUsingFlatMap(personName);

        //Then
        assertFalse(listOfCompaniesOfBhavesh.isEmpty(), "Companies list is not empty");
        assertEquals(3, listOfCompaniesOfBhavesh.size(), "no of companies are 3");
    }
}