package ServiceLayer;

import DAOLayer.ContactDAO;
import ModelLayer.AddressBook;
import ModelLayer.Contact;
import java.util.List;

public class ContactService {

	private ContactDAO dao;

	public ContactService(ContactDAO dao) {
		this.dao = dao;
	}

	// UC1 - Method to create contact with different details
	public Contact createContact(String firstName, String lastName, String address, String city, String state,
			String zipCode, String phoneNumber, String email) {
		return new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
	}

	// UC2 - Method to add a new contact to address book
	public boolean addContact(AddressBook book, Contact contact) {
		if (isDuplicateContact(book, contact))
			return false;
		dao.add(book, contact);
		return true;
	}

	// UC5 - Method to add multiple person to Address Book
	public void addMultipleContacts(AddressBook book, List<Contact> contacts) {
		for (Contact c : contacts) {
			addContact(book, c);
		}
	}

	// UC4 - Method to delete a person using person's name
	public boolean deleteContact(AddressBook book, String firstName, String lastName) {
		for (Contact c : dao.getAll(book)) {
			if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
				return dao.remove(book, c);
			}
		}
		return false;
	}

	// UC7 - Method to ensure there is no Duplicate Entry of the same Person in a particular Address Book
	public boolean isDuplicateContact(AddressBook book, Contact contact) {
		return dao.getAll(book).contains(contact);
	}

	// UC3 - Method to edit existing contact person using their name
	public boolean editContact(AddressBook editBook, String ef, String el, Contact updated) {

		if (editBook == null || updated == null) {
			return false;
		}

		for (Contact c : editBook.getContacts()) {
			if (c.getFirstName().equalsIgnoreCase(ef) && c.getLastName().equalsIgnoreCase(el)) {

				c.setAddress(updated.getAddress());
				c.setCity(updated.getCity());
				c.setState(updated.getState());
				c.setZipCode(updated.getZipCode());
				c.setPhoneNumber(updated.getPhoneNumber());
				c.setEmail(updated.getEmail());

				return true; // contact updated
			}
		}

		return false; // contact not found
	}
}
