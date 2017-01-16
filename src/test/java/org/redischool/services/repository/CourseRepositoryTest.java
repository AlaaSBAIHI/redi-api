package org.redischool.services.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.models.Course;
import org.redischool.models.Person;
import org.redischool.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by ReDI on 1/15/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {


    @Autowired
    private CourseRepository courseRepository;
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void shouldFindOnId() {
        Person person = Person.builder().id("id").firstName("Alaa").build();
        Person person1 = Person.builder().id("id1").firstName("Alaa").build();
        Teacher teacher = (Teacher) Teacher.builder().id("id2").firstName("ALaa").build();
        Set<Person> persons = new HashSet<>();
        persons.add(person);
        persons.add(person1);
        persons.add(teacher);


        personRepository.save(persons);

        Course courses = Course.builder().id("test").name("test").persons(persons).build();

        courseRepository.save(courses);

        Course course = courseRepository.findOne("test");
        assertEquals(course, courses);
    }

}