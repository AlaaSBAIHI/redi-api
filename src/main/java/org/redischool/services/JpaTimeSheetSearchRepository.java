package org.redischool.services;

import org.redischool.models.TimeSheet;
import org.redischool.services.repository.TimeSheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class JpaTimeSheetSearchRepository implements TimeSheetSearchRepository {

    private final TimeSheetRepository timeSheetRepository;

    public JpaTimeSheetSearchRepository(TimeSheetRepository timeSheetRepository) {
        this.timeSheetRepository = timeSheetRepository;
    }


    //search Persons By Session Id
    //by Id
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionId(String sesId) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionId(sesId);
    }

    //by Id
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionIds(String sesIds) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionIds(sesIds);
    }

    //by Id and present
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionIdAndPresent(String sesId, Boolean pre) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionIdAndPresent(sesId, pre);
    }

    //by Ids and present
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionIdsAndPresent(List<String> sesIds, Boolean pre) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionIdsAndPresent(sesIds, pre);
    }

    //by Id and date
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionDateAndId(String sesId, String sesDate) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionDateAndId(sesId, sesDate);
    }

    //search Persons By Session Title
    //by title
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionTitle(String sesTitle) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionTitle(sesTitle);
    }

    //by titles
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionTitles(List<String> sesTitles) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionTitles(sesTitles);
    }

    //by title and present
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionTitleAndPresent(String sesTitle, Boolean pre) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionTitleAndPresent(sesTitle, pre);
    }

    //by titles and present
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionTitlesAndPresent(List<String> sesTitles, Boolean pre) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionTitlesAndPresent(sesTitles, pre);
    }

    //by title and date
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionDateAndTitle(String sesTitle, String sesDate) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionDateAndTitle(sesTitle, sesDate);
    }

    //by date
    @Override
    public List<TimeSheet> searchPersonsAndTheirPresentBySessionDate(String sesDate) {
        return timeSheetRepository.findPersonsAndTheirPresentBySessionDate(sesDate);
    }
}
