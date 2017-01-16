package org.redischool.services;

import org.redischool.models.TimeSheet;
import org.redischool.services.repository.TimeSheetRepository;
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
public class TimeSheetService {

    private final TimeSheetRepository timeSheetRepository;
    private final TimeSheetSearchRepository timeSheetSearchRepository;

    @Autowired
    public TimeSheetService(TimeSheetRepository timeSheetRepository, TimeSheetSearchRepository timeSheetSearchRepository) {
        this.timeSheetRepository = timeSheetRepository;
        this.timeSheetSearchRepository = timeSheetSearchRepository;
    }

    // TimeSheet repository
    @Transactional
    public TimeSheet saveTimeSheet(TimeSheet timeSheet) {
        return timeSheetRepository.save(timeSheet);
    }

    @Transactional
    public TimeSheet getTimeSheet(String tshId) {
        return timeSheetRepository.findOne(tshId);
    }

    @Transactional
    public List<TimeSheet> findAllTimeSheets() {
        return new ArrayList<>(timeSheetRepository.findAll());
    }

    @Transactional
    public List<TimeSheet> findAllTimeSheetsSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(timeSheetRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(timeSheetRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public void deleteTimeSheet(String tshId) {
        timeSheetRepository.delete(tshId);
    }

    @Transactional
    public void deleteAllTimeSheets() {
        timeSheetRepository.deleteAll();
    }


    //TimeSheet Search repository
    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionId(String sesId) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionId(sesId);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionIds(String sesIds) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionIds(sesIds);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionIdAndPresent(String sesId, Boolean pre) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionIdAndPresent(sesId, pre);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionIdsAndPresent(List<String> sesIds, Boolean pre) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionIdsAndPresent(sesIds, pre);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionDateAndId(String sesId, String sesDate) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionDateAndId(sesId, sesDate);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionTitle(String sesTitle) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionTitle(sesTitle);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionTitles(List<String> sesTitles) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionTitles(sesTitles);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionTitleAndPresent(String sesTitle, Boolean pre) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionTitleAndPresent(sesTitle, pre);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionTitlesAndPresent(List<String> sesTitles, Boolean pre) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionTitlesAndPresent(sesTitles, pre);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionDateAndTitle(String sesTitle, String sesDate) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionDateAndTitle(sesTitle, sesDate);
    }

    @Transactional
    public List<TimeSheet> findPersonsAndTheirPresentBySessionDate(String sesDate) {
        return timeSheetSearchRepository.searchPersonsAndTheirPresentBySessionDate(sesDate);
    }
}
