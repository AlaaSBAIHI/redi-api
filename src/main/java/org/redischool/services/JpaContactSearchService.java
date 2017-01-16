package org.redischool.services;

import org.redischool.models.Contact;
import org.redischool.services.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
@Service
public class JpaContactSearchService implements ContactSearchService {
    private final ContactRepository contactRepository;

    public JpaContactSearchService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> searchContactByTile(String title) {
        return contactRepository.findByTile(title);
    }

    @Override
    public Contact searchContactByValue(String value) {
        return contactRepository.findByValue(value);
    }

    @Override
    public List<Contact> searchContactByPersonId(String perId) {
        return contactRepository.findByPersonId(perId);
    }
}
