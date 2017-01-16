package org.redischool.services.repository;

import org.redischool.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by ReDI on 1/15/2017.
 */
public interface SessionRepository extends JpaRepository<Session, String> {

    List<Session> findByTitle(String title);

    List<Session> findByTime(String time);

    List<Session> findByLocation(String location);

    List<Session> findByDuration(String duration);

    List<Session> findByDate(String date);

    @Query("select s from session s where s.course.course_id = :couId")
    List<Session> findByCourseId(@PathParam("couId") String couId);

    @Query("select s from session s where s.course.course_id in :couIds")
    List<Session> findByCourseIds(@PathParam("couIds") List<String> couIds);

    @Query("select s from session s where s.course.name = :couName")
    List<Session> findByCourseName(@PathParam("couName") String couName);

    @Query("select s from session s where s.course.name in :couNames")
    List<Session> findByCourseNames(@PathParam("couNames") List<String> couNames);

}
