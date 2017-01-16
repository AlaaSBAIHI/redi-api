package org.redischool.services.repository;

import org.redischool.models.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ReDI on 1/15/2017.
 */
public interface TimeSheetRepository extends JpaRepository<TimeSheet, String> {

    //find Persons By Session Id
    //by Id
    @Query("select ts from time_sheet ts where ts.session.session_id = :sesId")
    List<TimeSheet> findPersonsAndTheirPresentBySessionId(@Param("sesId") String sesId);

    //by Ids
    @Query("select ts from time_sheet ts where ts.session.session_id in :sesIds")
    List<TimeSheet> findPersonsAndTheirPresentBySessionIds(@Param("sesIds") String sesIds);

    //by Id und present
    @Query("select ts from time_sheet ts where ts.session.session_id = :sesId and ts.present = :pre")
    List<TimeSheet> findPersonsAndTheirPresentBySessionIdAndPresent(@Param("sesId") String sesId, @Param("pre") Boolean pre);

    //by Ids und present
    @Query("select ts from time_sheet ts where ts.session.session_id in :sesIds and ts.present = :pre")
    List<TimeSheet> findPersonsAndTheirPresentBySessionIdsAndPresent(@Param("sesIds") List<String> sesIds, @Param("pre") Boolean pre);

    //by Id and date
    @Query("select ts from time_sheet ts where ts.session.session_id = :sesId and ts.session.date = :sesDate")
    List<TimeSheet> findPersonsAndTheirPresentBySessionDateAndId(@Param("sesId") String sesId, @Param("sesDate") String sesDate);


    //find Persons By Session Title
    //by title
    @Query("select ts from time_sheet ts where ts.session.title = :sesTitle")
    List<TimeSheet> findPersonsAndTheirPresentBySessionTitle(@Param("sesTitle") String sesTitle);

    //by titles
    @Query("select ts from time_sheet ts where ts.session.title in :sesTitles")
    List<TimeSheet> findPersonsAndTheirPresentBySessionTitles(@Param("sesTitles") List<String> sesTitles);

    //by Title und present
    @Query("select ts from time_sheet ts where ts.session.title = :sesTitle and ts.present = :pre")
    List<TimeSheet> findPersonsAndTheirPresentBySessionTitleAndPresent(@Param("sesTitle") String sesTitle, @Param("pre") Boolean pre);

    //by Titles und present
    @Query("select ts from time_sheet ts where ts.session.title in :sesTitles and ts.present = :pre")
    List<TimeSheet> findPersonsAndTheirPresentBySessionTitlesAndPresent(@Param("sesTitles") List<String> sesTitles, @Param("pre") Boolean pre);


    //by Title and date
    @Query("select ts from time_sheet ts where ts.session.title = :sesTitle and ts.session.date = :sesDate")
    List<TimeSheet> findPersonsAndTheirPresentBySessionDateAndTitle(@Param("sesTitle") String sesTitle, @Param("sesDate") String sesDate);

    //by date
    @Query("select ts from time_sheet ts where ts.session.date = :sesDate")
    List<TimeSheet> findPersonsAndTheirPresentBySessionDate(@Param("sesDate") String sesDate);
}