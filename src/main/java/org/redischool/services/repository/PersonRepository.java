package org.redischool.services.repository;

import org.redischool.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by ReDI on 1/15/2017.
 */
public interface PersonRepository extends JpaRepository<Person, String> {

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    List<Person> findByBirthDate(String birthDate);

    List<Person> findByAddress(String address);

    List<Person> findByOverview(String overview);

    @Query("select p from person where p.profession = :proId")
    List<Person> findByProfession(@PathParam("proId") String proId);

    @Query("select p from person where p.contact.contact_id = :conId")
    List<Person> findByContactId(@PathParam("conId") String conId);

    @Query("select p from person where p.course.course_id = :couId")
    List<Person> findByCourseId(@PathParam("couId") String couId);

    @Query("select p from person where p.course.course_id in :couId")
    List<Person> findByCourseIds(@PathParam("couIds") List<String> couIds);

    @Query("select p from person where p.course.name = :couName")
    List<Person> findByCourseName(@PathParam("couName") String couName);

    @Query("select p from person where p.course.name in :couNames")
    List<Person> findByCourseNames(@PathParam("couNames") List<String> couNames);
}
