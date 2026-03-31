package DAOLayer;

import ModelLayer.AddressBook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * DAO Layer
 * UC-6: Store AddressBooks uniquely
 */

public class AddressBookDAO {

	// In-memory data storage for AddressBook objects.
	// The key is the AddressBook name, and the value is the AddressBook itself.
	private Map<String, AddressBook> addressBooks = new HashMap<>();

	// Saves a new AddressBook.
	public boolean save(AddressBook book) {
		if (addressBooks.containsKey(book.getAddressBookName())) {
			return false;
		}
		addressBooks.put(book.getAddressBookName(), book);
		return true;
	}

	// Finds an AddressBook by its name.
	public AddressBook findByName(String name) {
		return addressBooks.get(name);
	}

	// Checks whether an AddressBook exists with the given name.
	public boolean exists(String name) {
		return addressBooks.containsKey(name);
	}

	// Deletes an AddressBook by its name.
	public boolean delete(String name) {
		return addressBooks.remove(name) != null;
	}

	// Retrieves all stored AddressBooks.
	public List<AddressBook> findAll() {
		return new ArrayList<>(addressBooks.values());
	}

	// Returns the total number of AddressBooks stored.
	public int count() {
		return addressBooks.size();
	}
}
