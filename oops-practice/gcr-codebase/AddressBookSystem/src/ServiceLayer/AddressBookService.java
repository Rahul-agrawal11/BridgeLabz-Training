package ServiceLayer;

import DAOLayer.AddressBookDAO;
import ModelLayer.AddressBook;
import java.util.ArrayList;

public class AddressBookService {

	private AddressBookDAO dao;

	public AddressBookService(AddressBookDAO dao) {
		this.dao = dao;
	}

	// UC6 - Create multiple address book and each with unique name
	public boolean createAddressBook(String name) {
		if (dao.exists(name))
			return false;
		dao.save(new AddressBook(name));
		return true;
	}

	// Method to find existed address book
	public AddressBook getAddressBook(String name) {
		return dao.findByName(name);
	}

	// Method to check if there is address book exist or not using its name
	public boolean addressBookExists(String name) {
		return dao.exists(name);
	}

	// Method to get all address book list
	public ArrayList<AddressBook> getAllAddressBooks() {
		return new ArrayList<>(dao.findAll());
	}

	// Method to delete address book
	public boolean removeAddressBook(String name) {
		return dao.delete(name);
	}

	// Method to count total number of address book
	public int getAddressBookCount() {
		return dao.count();
	}
}
