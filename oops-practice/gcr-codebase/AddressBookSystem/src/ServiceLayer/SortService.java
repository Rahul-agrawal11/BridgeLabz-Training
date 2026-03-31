package ServiceLayer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ModelLayer.Contact;

public class SortService {

    /* ************************************************
     * UC-11
     * Sort contacts alphabetically by person's name
     ************************************************ */
    public List<Contact> sortByName(List<Contact> contacts) {

        /* Sort contacts using first name */
        Collections.sort(contacts, Comparator.comparing(Contact::getFirstName));

        /* Return sorted contact list */
        return contacts;
    }

    /* ************************************************
     * UC-12
     * Sort contacts by city
     ************************************************ */
    public List<Contact> sortByCity(List<Contact> contacts) {

        /* Sort contacts using city */
        Collections.sort(contacts, Comparator.comparing(Contact::getCity));

        /* Return sorted contact list */
        return contacts;
    }

    /* ************************************************
     * UC-12
     * Sort contacts by state
     ************************************************ */
    public List<Contact> sortByState(List<Contact> contacts) {

        /* Sort contacts using state */
        Collections.sort(contacts, Comparator.comparing(Contact::getState));

        /* Return sorted contact list */
        return contacts;
    }

    /* ************************************************
     * UC-12
     * Sort contacts by zip code
     ************************************************ */
    public List<Contact> sortByZip(List<Contact> contacts) {

        /* Sort contacts using zip code */
        Collections.sort(contacts, Comparator.comparing(Contact::getZipCode));

        /* Return sorted contact list */
        return contacts;
    }
}

