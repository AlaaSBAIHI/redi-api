package org.redischool.services;

import org.redischool.models.Contact;
import org.redischool.models.Person;
import org.redischool.services.repository.ContactRepository;
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
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactSearchService contactSearchService;

    @Autowired
    public ContactService(ContactRepository contactRepository, ContactSearchService contactSearchService) {
        this.contactRepository = contactRepository;
        this.contactSearchService = contactSearchService;
    }

    //Contact repository
    @Transactional
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public Contact getContact(String conId) {
        return contactRepository.findOne(conId);
    }

    @Transactional
    public List<Contact> findAllContacts() {
        return new ArrayList<>(contactRepository.findAll());
    }

    @Transactional
    public List<Contact> findAllContactsSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(contactRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(contactRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public void deleteContacts(String conId) {
        contactRepository.delete(conId);
    }

    @Transactional
    public void deleteAllContacts() {
        contactRepository.deleteAll();
    }

    @Transactional
    public Person getPerson(String conId) {
        return contactRepository.findOne(conId).getPerson();
    }


    // Contact Search Service
    @Transactional
    public List<Contact> findContactByTile(String title) {
        return contactSearchService.searchContactByTile(title);
    }

    @Transactional
    public Contact findContactByValue(String value) {
        return contactSearchService.searchContactByValue(value);
    }

    @Transactional
    public List<Contact> findContactByPersonId(String perId) {
        return contactSearchService.searchContactByPersonId(perId);
    }
}
