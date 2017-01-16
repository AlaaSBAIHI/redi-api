package org.redischool.services;

import org.redischool.services.repository.TeacherRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class JpaTeacherSearchRepository implements StudentSearchRepository {

    private final TeacherRepository teacherRepository;

    public JpaTeacherSearchRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;

    }
}
