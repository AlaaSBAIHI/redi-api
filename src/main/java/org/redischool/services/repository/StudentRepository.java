package org.redischool.services.repository;

import org.redischool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ReDI on 1/15/2017.
 */
public interface StudentRepository extends JpaRepository<Student, String> {
}
