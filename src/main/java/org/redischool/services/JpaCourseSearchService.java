package org.redischool.services;

import org.redischool.models.Course;
import org.redischool.services.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class JpaCourseSearchService implements CourseSearchService {
    private final CourseRepository courseRepository;

    public JpaCourseSearchService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> searchCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public List<Course> searchCourseByDescription(String description) {
        return courseRepository.findByDescription(description);
    }

    @Override
    public List<Course> searchCourseByStartDate(String startDate) {
        return courseRepository.findByStartDate(startDate);
    }

    @Override
    public List<Course> searchCourseByEndDate(String endDate) {
        return courseRepository.findByEndDate(endDate);
    }

    @Override
    public List<Course> searchCourseBySessionProWeek(String sessionProWeek) {
        return courseRepository.findBySessionProWeek(sessionProWeek);
    }

    @Override
    public List<Course> searchCourseBetweenTwoDates(String sDate, String eDate) {
        return courseRepository.findBetweenTwoDates(sDate, eDate);
    }

    @Override
    public List<Course> searchCourseByMonth(String month) {
        return courseRepository.findByMonth(month);
    }

    @Override
    public List<Course> searchCourseByPersonId(String perId) {
        return courseRepository.findByPersonId(perId);
    }

    @Override
    public List<Course> searchCourseBySessionId(String sesId) {
        return courseRepository.findBySessionId(sesId);
    }

    @Override
    public List<Course> searchCourseBySessionDate(String sesDate) {
        return courseRepository.findBySessionDate(sesDate);
    }

    @Override
    public List<Course> searchCourseBySessionIdAndDate(String sesId, String sesDate) {
        return courseRepository.findBySessionIdAndDate(sesId, sesDate);
    }
}
