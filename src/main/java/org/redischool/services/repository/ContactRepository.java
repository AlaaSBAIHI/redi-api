package org.redischool.services.repository;

import org.redischool.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ReDI on 1/15/2017.
 */
public interface ContactRepository extends JpaRepository<Contact, String> {

    List<Contact> findByTile(String title);

    Contact findByValue(String value);

    @Query("select c from contact c where c.person.person_id = :perId")
    List<Contact> findByPersonId(@Param("perId") String perId);


}
