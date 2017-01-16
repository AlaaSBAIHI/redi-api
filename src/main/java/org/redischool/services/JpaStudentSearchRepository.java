package org.redischool.services;

import org.redischool.services.repository.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class JpaStudentSearchRepository implements StudentSearchRepository {

    private final StudentRepository studentRepository;

    public JpaStudentSearchRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
