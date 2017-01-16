package org.redischool.services;

import org.redischool.models.Course;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
public interface CourseSearchService {
    List<Course> searchCourseByName(String name);

    List<Course> searchCourseByDescription(String description);

    List<Course> searchCourseByStartDate(String startDate);

    List<Course> searchCourseByEndDate(String endDate);

    List<Course> searchCourseBySessionProWeek(String sessionProWeek);

    List<Course> searchCourseBetweenTwoDates(String sDate, String eDate);

    List<Course> searchCourseByMonth(String month);

    List<Course> searchCourseByPersonId(String perId);

    List<Course> searchCourseBySessionId(String sesId);

    List<Course> searchCourseBySessionDate(String sesDate);

    List<Course> searchCourseBySessionIdAndDate(String sesId, String sesDate);
}
