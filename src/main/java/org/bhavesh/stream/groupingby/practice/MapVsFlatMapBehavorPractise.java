package org.bhavesh.stream.groupingby.practice;

import org.bhavesh.stream.groupingby.practice.model.EmployeeExperience;
import org.bhavesh.stream.groupingby.practice.model.Person;
import org.bhavesh.stream.groupingby.practice.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class MapVsFlatMapBehavorPractise {

    private static final Logger LOG = LoggerFactory.getLogger(MapVsFlatMapBehavorPractise.class);

    public static Person getPersonByName(String name){
        List<Person> personsList = PersonService.getPersonsList();
        //filter out companies for which Bhavesh has worked
        Optional<Person> firstPerson = personsList.stream()
                .filter(person -> name.equals(person.getName()))
                .findFirst();
        return firstPerson.orElseThrow(RuntimeException::new);
    }

    public static Integer getAddharNumberByName(String name){
        List<Person> personsList = PersonService.getPersonsList();
        //filter out companies for which Bhavesh has worked
        Optional<Integer> addharNumberOptional = personsList.stream()
                .filter(person -> name.equals(person.getName()))
                .map(Person::getAddharNo)
                .findFirst();
        return addharNumberOptional.orElseThrow(RuntimeException::new);
    }

    public static List<List<EmployeeExperience>> getExperienceByNameUsingMap(String name){
        List<Person> personsList = PersonService.getPersonsList();
        //filter out companies for which Bhavesh has worked using Map
        return personsList.stream()
                .filter(person -> name.equals(person.getName()))
                .map(Person::getTotalExperience)
                .toList();
    }

    public static List<EmployeeExperience> getExperienceByNameUsingFlatMap(String name){
        List<Person> personsList = PersonService.getPersonsList();
        //filter out companies for which Bhavesh has worked using Flat Map
        //flat map takes stream as a input
        return  personsList.stream()
                .filter(person -> name.equals(person.getName()))
                .flatMap(person -> person.getTotalExperience().stream())
                .toList();

    }

    public static List<String> getCompaniesByNameUsingFlatMap(String name){
        List<Person> personsList = PersonService.getPersonsList();
        //filter out companies for which Bhavesh has worked using Flat Map
        return personsList.stream()
                .filter(person -> name.equals(person.getName()))
                .flatMap(person -> person.getTotalExperience().stream())
                .map(EmployeeExperience::getCompanyName)
                .toList();

    }



}