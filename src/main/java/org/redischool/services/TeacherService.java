package org.redischool.services;

import org.redischool.models.Teacher;
import org.redischool.services.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherSearchRepository teacherSearchRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherSearchRepository teacherSearchRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherSearchRepository = teacherSearchRepository;
    }

    // Teacher repository
    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher getTeacher(String teaId) {
        return teacherRepository.findOne(teaId);
    }

    @Transactional
    public List<Teacher> findAllTeachers() {
        return new ArrayList<>(teacherRepository.findAll());
    }

    @Transactional
    public List<Teacher> findAllTeachersSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(teacherRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(teacherRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public void deleteTeacher(String teaId) {
        teacherRepository.delete(teaId);
    }

    @Transactional
    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }

}
