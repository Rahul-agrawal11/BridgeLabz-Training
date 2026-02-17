package ModelLayer;

import java.util.ArrayList;
import java.util.List;

/*
 * Model class for AddressBook
 * UC-6: Maintain multiple AddressBooks
 */

public class AddressBook {

	private String addressBookName;
	private List<Contact> contacts;

	// No-argument constructor
	public AddressBook() {
		this.contacts = new ArrayList<>();
	}

	// Constructor with address book name
	public AddressBook(String addressBookName) {
		this.addressBookName = addressBookName;
		this.contacts = new ArrayList<>();
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
