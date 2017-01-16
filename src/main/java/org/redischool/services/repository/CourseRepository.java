package org.redischool.services.repository;

import org.redischool.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by ReDI on 1/15/2017.
 */
public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findByName(String name);

    List<Course> findByDescription(String description);

    List<Course> findByStartDate(String startDate);

    List<Course> findByEndDate(String endDate);

    List<Course> findBySessionProWeek(String sessionProWeek);

    @Query("select c from course where start_date <= :sDate and end_date >= :eDate")
    List<Course> findBetweenTwoDates(@Param("sDate") String sDate, @Param("eDate") String eDate);

    @Query("select c from Courses where :month between month(c.start_date) and month(c.end_date)")
    List<Course> findByMonth(@Param("month") String month);

    @Query("select c from course c where c.person.person_id = :perId")
    List<Course> findByPersonId(@Param("perId") String perId);

    @Query("select c from course c where c.session.session_id = :sesId")
    List<Course> findBySessionId(@Param("sesId") String sesId);

    @Query("select c from course c where c.session.date = :sesDate")
    List<Course> findBySessionDate(@Param("sesDate") String sesDate);

    @Query("select c from course c where c.session.session_id = :sesId and c.session.date = :sesDate")
    List<Course> findBySessionIdAndDate(@Param("sesId") String sesId, @Param("sesDate") String sesDate);
}
