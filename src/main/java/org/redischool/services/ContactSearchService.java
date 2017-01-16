package org.redischool.services;

import org.redischool.models.Contact;

import java.util.List;

/**
 * Created by ReDI on 1/16/2017.
 */
public interface ContactSearchService {
    List<Contact> searchContactByTile(String title);

    Contact searchContactByValue(String value);

    List<Contact> searchContactByPersonId(String perId);
}
