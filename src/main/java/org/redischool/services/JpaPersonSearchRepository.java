package org.redischool.services;

import org.redischool.models.Person;
import org.redischool.services.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class JpaPersonSearchRepository implements PersonSearchRepository {

    private final PersonRepository personRepository;

    public JpaPersonSearchRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> searchPersonByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    @Override
    public List<Person> searchPersonByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    @Override
    public List<Person> searchPersonByBirthDate(String birthDate) {
        return personRepository.findByBirthDate(birthDate);
    }

    @Override
    public List<Person> searchPersonByAddress(String address) {
        return personRepository.findByAddress(address);
    }

    @Override
    public List<Person> searchPersonByOverview(String overview) {
        return personRepository.findByOverview(overview);
    }

    @Override
    public List<Person> searchPersonByProfession(String proId) {
        return personRepository.findByProfession(proId);
    }

    @Override
    public List<Person> searchPersonByContactId(String conId) {
        return personRepository.findByContactId(conId);
    }

    @Override
    public List<Person> searchPersonByCourseId(String couId) {
        return personRepository.findByCourseId(couId);
    }

    @Override
    public List<Person> searchPersonByCourseIds(List<String> couIds) {
        return personRepository.findByCourseIds(couIds);
    }

    @Override
    public List<Person> searchPersonByCourseName(String couName) {
        return personRepository.findByCourseName(couName);
    }

    @Override
    public List<Person> searchPersonByCourseNames(List<String> couNames) {
        return personRepository.findByCourseNames(couNames);
    }
}
