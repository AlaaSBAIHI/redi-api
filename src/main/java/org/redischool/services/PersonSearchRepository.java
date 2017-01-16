package org.redischool.services;

import org.redischool.models.Person;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
public interface PersonSearchRepository {
    List<Person> searchPersonByFirstName(String firstName);

    List<Person> searchPersonByLastName(String lastName);

    List<Person> searchPersonByBirthDate(String birthDate);

    List<Person> searchPersonByAddress(String address);

    List<Person> searchPersonByOverview(String overview);

    List<Person> searchPersonByProfession(String proId);

    List<Person> searchPersonByContactId(String conId);

    List<Person> searchPersonByCourseId(String couId);

    List<Person> searchPersonByCourseIds(List<String> couIds);

    List<Person> searchPersonByCourseName(String couName);

    List<Person> searchPersonByCourseNames(List<String> couNames);
}
