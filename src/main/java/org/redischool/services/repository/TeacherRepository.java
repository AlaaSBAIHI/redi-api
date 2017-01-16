package org.redischool.services.repository;

import org.redischool.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ReDI on 1/15/2017.
 */
public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
