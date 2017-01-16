package org.redischool.services;

import org.redischool.models.TimeSheet;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
public interface TimeSheetSearchRepository {

    //search Persons By Session Id
    //by Id
    List<TimeSheet> searchPersonsAndTheirPresentBySessionId(String sesId);

    //by Ids
    List<TimeSheet> searchPersonsAndTheirPresentBySessionIds(String sesIds);

    //by Id and present
    List<TimeSheet> searchPersonsAndTheirPresentBySessionIdAndPresent(String sesId, Boolean pre);

    //by Ids and present
    List<TimeSheet> searchPersonsAndTheirPresentBySessionIdsAndPresent(List<String> sesIds, Boolean pre);

    //by Id and date
    List<TimeSheet> searchPersonsAndTheirPresentBySessionDateAndId(String sesId, String sesDate);


    //search Persons By Session Title
    //by title
    List<TimeSheet> searchPersonsAndTheirPresentBySessionTitle(String sesTitle);

    //by titles
    List<TimeSheet> searchPersonsAndTheirPresentBySessionTitles(List<String> sesTitles);

    //by Title und present
    List<TimeSheet> searchPersonsAndTheirPresentBySessionTitleAndPresent(String sesTitle, Boolean pre);

    //by Titles und present
    List<TimeSheet> searchPersonsAndTheirPresentBySessionTitlesAndPresent(List<String> sesTitles, Boolean pre);


    //by Title and date
    List<TimeSheet> searchPersonsAndTheirPresentBySessionDateAndTitle(String sesTitle, String sesDate);

    //by date
    List<TimeSheet> searchPersonsAndTheirPresentBySessionDate(String sesDate);
}
