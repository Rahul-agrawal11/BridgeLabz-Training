package ServiceLayer;

import java.util.ArrayList;
import java.util.List;

import ModelLayer.AddressBook;
import ModelLayer.Contact;

public class SearchService {

    /* ************************************************
     * UC-8, UC-9
     * Search and view all contacts belonging to a
     * given city across multiple AddressBooks
     ************************************************ */
    public List<Contact> searchByCity(List<AddressBook> books, String city) {

        /* List to store all matching contacts */
        List<Contact> result = new ArrayList<>();

        /* Loop through all AddressBooks */
        for (AddressBook book : books) {

            /* Loop through all Contacts in each AddressBook */
            for (Contact c : book.getContacts()) {

                /* Check if contact belongs to the given city */
                if (c.getCity().equalsIgnoreCase(city)) {
                    result.add(c);
                }
            }
        }

        /* Return all matching contacts */
        return result;
    }

    /* ************************************************
     * UC-8, UC-9
     * Search and view all contacts belonging to a
     * given state across multiple AddressBooks
     ************************************************ */
    public List<Contact> searchByState(List<AddressBook> books, String state) {

        /* List to store all matching contacts */
        List<Contact> result = new ArrayList<>();

        /* Loop through all AddressBooks */
        for (AddressBook book : books) {

            /* Loop through all Contacts in each AddressBook */
            for (Contact c : book.getContacts()) {

                /* Check if contact belongs to the given state */
                if (c.getState().equalsIgnoreCase(state)) {
                    result.add(c);
                }
            }
        }

        /* Return all matching contacts */
        return result;
    }

    /* ************************************************
     * UC-10
     * Count total number of contacts belonging to a
     * given city across multiple AddressBooks
     ************************************************ */
    public int countByCity(List<AddressBook> books, String city) {

        /* Variable to store total count */
        int count = 0;

        /* Loop through all AddressBooks */
        for (AddressBook book : books) {

            /* Loop through all Contacts in each AddressBook */
            for (Contact c : book.getContacts()) {

                /* Increment count if city matches */
                if (c.getCity().equalsIgnoreCase(city)) {
                    count++;
                }
            }
        }

        /* Return total count for the city */
        return count;
    }

    /* ************************************************
     * UC-10
     * Count total number of contacts belonging to a
     * given state across multiple AddressBooks
     ************************************************ */
    public int countByState(List<AddressBook> books, String state) {

        /* Variable to store total count */
        int count = 0;

        /* Loop through all AddressBooks */
        for (AddressBook book : books) {

            /* Loop through all Contacts in each AddressBook */
            for (Contact c : book.getContacts()) {

                /* Increment count if state matches */
                if (c.getState().equalsIgnoreCase(state)) {
                    count++;
                }
            }
        }

        /* Return total count for the state */
        return count;
    }
}