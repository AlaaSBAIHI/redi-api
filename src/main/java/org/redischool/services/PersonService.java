package org.redischool.services;

import org.redischool.models.Contact;
import org.redischool.models.Course;
import org.redischool.models.Person;
import org.redischool.services.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonSearchRepository personSearchRepository;


    @Autowired
    public PersonService(PersonRepository personRepository, PersonSearchRepository personSearchRepository) {
        this.personRepository = personRepository;
        this.personSearchRepository = personSearchRepository;
    }

    // Person repository
    @Transactional
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person getPerson(String perId) {
        return personRepository.findOne(perId);
    }

    @Transactional
    public List<Person> findAllPersons() {
        return new ArrayList<>(personRepository.findAll());
    }

    @Transactional
    public List<Person> findAllPersonsSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(personRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(personRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public void deletePerson(String perId) {
        personRepository.delete(perId);
    }

    @Transactional
    public void deleteAllPersons() {
        personRepository.deleteAll();
    }

    @Transactional
    public Set<Contact> getContacts(String perId) {
        return personRepository.findOne(perId).getContacts();
    }

    @Transactional
    public Set<Course> getCourse(String perId) {
        return personRepository.findOne(perId).getCourses();
    }


    // Person Search repository
    @Transactional
    public List<Person> findPersonByFirstName(String firstName) {
        return personSearchRepository.searchPersonByFirstName(firstName);
    }

    @Transactional
    public List<Person> findPersonByLastName(String lastName) {
        return personSearchRepository.searchPersonByLastName(lastName);
    }

    @Transactional
    public List<Person> findPersonByBirthDate(String birthDate) {
        return personSearchRepository.searchPersonByBirthDate(birthDate);
    }

    @Transactional
    public List<Person> findPersonByAddress(String address) {
        return personSearchRepository.searchPersonByAddress(address);
    }

    @Transactional
    public List<Person> findPersonByOverview(String overview) {
        return personSearchRepository.searchPersonByOverview(overview);
    }

    @Transactional
    public List<Person> findPersonByProfession(String proId) {
        return personSearchRepository.searchPersonByProfession(proId);
    }

    @Transactional
    public List<Person> findPersonByContactId(String conId) {
        return personSearchRepository.searchPersonByContactId(conId);
    }

    @Transactional
    public List<Person> findPersonByCourseId(String couId) {
        return personSearchRepository.searchPersonByCourseId(couId);
    }

    @Transactional
    public List<Person> findPersonByCourseIds(List<String> couIds) {
        return personSearchRepository.searchPersonByCourseIds(couIds);
    }

    @Transactional
    public List<Person> findPersonByCourseName(String couName) {
        return personSearchRepository.searchPersonByCourseName(couName);
    }

    @Transactional
    public List<Person> findPersonByCourseNames(List<String> couNames) {
        return personSearchRepository.searchPersonByCourseNames(couNames);
    }
}

