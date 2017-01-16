package org.redischool.services;

import org.redischool.models.Student;
import org.redischool.services.repository.StudentRepository;
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
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentSearchRepository studentSearchRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentSearchRepository studentSearchRepository) {
        this.studentRepository = studentRepository;
        this.studentSearchRepository = studentSearchRepository;
    }

    // Student repository
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student getStudent(String stuId) {
        return studentRepository.findOne(stuId);
    }

    @Transactional
    public List<Student> findAllStudents() {
        return new ArrayList<>(studentRepository.findAll());
    }

    @Transactional
    public List<Student> findAllStudentsSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(studentRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(studentRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public void deleteStudent(String stuId) {
        studentRepository.delete(stuId);
    }

    @Transactional
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
