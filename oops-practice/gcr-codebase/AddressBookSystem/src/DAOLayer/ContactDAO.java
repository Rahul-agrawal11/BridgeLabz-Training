package DAOLayer;

import ModelLayer.AddressBook;
import ModelLayer.Contact;
import java.util.List;

public class ContactDAO {

    public List<Contact> getAll(AddressBook book) {
        return book.getContacts();
    }
    
    // UC2 - To add a new contact to the address book
    public void add(AddressBook book, Contact contact) {
        book.getContacts().add(contact);
    }
    
    // UC4 - To delete a contact from address book
    public boolean remove(AddressBook book, Contact contact) {
        return book.getContacts().remove(contact);
    }
}
