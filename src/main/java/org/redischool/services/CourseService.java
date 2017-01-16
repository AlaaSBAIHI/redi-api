package org.redischool.services;

import org.redischool.models.Course;
import org.redischool.models.Person;
import org.redischool.models.Session;
import org.redischool.services.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ReDI on 1/15/2017.
 */
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseSearchService courseSearchService;


    @Autowired
    public CourseService(CourseRepository courseRepository, CourseSearchService courseSearchService) {
        this.courseRepository = courseRepository;
        this.courseSearchService = courseSearchService;
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    }

    // Course repository
    @Transactional
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public Course getCourse(String couId) {
        Course course = courseRepository.findOne(couId);
        course.getSessions().size();
        course.getPersons().size();
        return course;
    }

    @Transactional
    public List<Course> findAllCourses() {
        return new ArrayList<>(courseRepository.findAll());
    }

    @Transactional
    public List<Course> findAllCoursesSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(courseRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(courseRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public void deleteCourse(String couId) {
        courseRepository.delete(couId);
    }

    @Transactional
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

    @Transactional
    public Set<Person> getPersons(String couId) {
        return courseRepository.findOne(couId).getPersons();
    }

    @Transactional
    public Set<Session> getSessions(String couId) {
        return courseRepository.findOne(couId).getSessions();
    }


    // Course Search Service
    @Transactional
    public List<Course> findCourseByName(String name) {
        return courseSearchService.searchCourseByName(name);
    }

    @Transactional
    public List<Course> findCourseByDescription(String description) {
        return courseSearchService.searchCourseByDescription(description);
    }

    @Transactional
    public List<Course> findCourseByStartDate(String startDate) {
        return courseSearchService.searchCourseByStartDate(startDate);
    }

    @Transactional
    public List<Course> findCourseByEndDate(String endDate) {
        return courseSearchService.searchCourseByEndDate(endDate);
    }

    @Transactional
    public List<Course> findCourseBySessionProWeek(String sessionProWeek) {
        return courseSearchService.searchCourseBySessionProWeek(sessionProWeek);
    }

    @Transactional
    public List<Course> findCourseBetweenTwoDates(String sDate, String eDate) {
        return courseSearchService.searchCourseBetweenTwoDates(sDate, eDate);
    }

    @Transactional
    public List<Course> findCourseByMonth(String month) {
        return courseSearchService.searchCourseByMonth(month);
    }

    @Transactional
    public List<Course> findCourseByPersonId(String perId) {
        return courseSearchService.searchCourseByPersonId(perId);
    }

    @Transactional
    public List<Course> findCourseBySessionId(String sesId) {
        return courseSearchService.searchCourseBySessionId(sesId);
    }

    @Transactional
    public List<Course> findCourseBySessionDate(String sesDate) {
        return courseSearchService.searchCourseBySessionDate(sesDate);
    }

    @Transactional
    public List<Course> findCourseBySessionIdAndDate(String sesId, String sesDate) {
        return courseSearchService.searchCourseBySessionIdAndDate(sesId, sesDate);
    }
}
