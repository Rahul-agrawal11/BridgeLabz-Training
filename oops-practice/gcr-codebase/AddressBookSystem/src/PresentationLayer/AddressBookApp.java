package PresentationLayer;

import java.util.List;
import java.util.Scanner;

import DAOLayer.AddressBookDAO;
import DAOLayer.ContactDAO;
import ModelLayer.AddressBook;
import ModelLayer.Contact;
import ServiceLayer.*;

public class AddressBookApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int choice;

		/* ===== DAO Layer ===== */
		AddressBookDAO addressBookDAO = new AddressBookDAO();
		ContactDAO contactDAO = new ContactDAO();

		/* ===== Service Layer ===== */
		AddressBookService abs = new AddressBookService(addressBookDAO);
		ContactService cs = new ContactService(contactDAO);
		SearchService ss = new SearchService();
		SortService sortService = new SortService();
		FileIOService fileIOService = new FileIOService();

		do {
			System.out.println("\n================ Welcome To ADDRESS BOOK =================");
			System.out.println("1. Create Address Book");
			System.out.println("2. Add Contact");
			System.out.println("3. Edit Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Search Person by City");
			System.out.println("6. Search Person by State");
			System.out.println("7. Count Contacts by City");
			System.out.println("8. Count Contacts by State");
			System.out.println("9. Sort Contacts by Name");
			System.out.println("10. Sort Contacts by City");
			System.out.println("11. Sort Contacts by State");
			System.out.println("12. Sort Contacts by Zip");

			/* ************************************************
			 * UC-13 & UC-14
			 ************************************************ */
			System.out.println("13. Write AddressBook to Text File");
			System.out.println("14. Read AddressBook from Text File");
			System.out.println("15. Write AddressBook to CSV File");
			System.out.println("16. Read AddressBook from CSV File");

			System.out.println("0. Exit");
			System.out.println("==============================================");

			System.out.print("Enter Choice: ");
			choice = Integer.parseInt(input.nextLine());

			switch (choice) {

			case 1:
				System.out.print("Enter Address Book Name: ");
				String name = input.nextLine();
				if (abs.createAddressBook(name)) {
					System.out.println("Address Book created!");
				} else {
					System.out.println("Duplicate Name!");
				}
				break;

			case 2:
				System.out.print("Enter Address Book Name: ");
				String bookName = input.nextLine();
				AddressBook book = abs.getAddressBook(bookName);

				if (book == null) {
					System.out.println("Address Book not found!");
					break;
				}

				System.out.print("First Name: ");
				String fName = input.nextLine();

				System.out.print("Last Name: ");
				String lName = input.nextLine();

				System.out.print("Address: ");
				String address = input.nextLine();

				System.out.print("City: ");
				String city = input.nextLine();

				System.out.print("State: ");
				String state = input.nextLine();

				System.out.print("Zip Code: ");
				String zipCode = input.nextLine();

				System.out.print("Phone Number: ");
				String phoneNum = input.nextLine();

				System.out.print("Email: ");
				String email = input.nextLine();

				Contact contact = cs.createContact(fName, lName, address, city, state, zipCode, phoneNum, email);

				if (cs.addContact(book, contact)) {
					System.out.println("Contact added successfully!");
				} else {
					System.out.println("Duplicate contact!");
				}
				break;

			case 3:
				System.out.print("Enter Address Book Name: ");
				AddressBook editBook = abs.getAddressBook(input.nextLine());

				if (editBook == null) {
					System.out.println("Address Book not found!");
					break;
				}

				System.out.print("First Name to Edit: ");
				String ef = input.nextLine();

				System.out.print("Last Name to Edit: ");
				String el = input.nextLine();

				System.out.print("New Address: ");
				String na = input.nextLine();

				System.out.print("New City: ");
				String nc = input.nextLine();

				System.out.print("New State: ");
				String ns = input.nextLine();

				System.out.print("New Zip: ");
				String nz = input.nextLine();

				System.out.print("New Phone: ");
				String np = input.nextLine();

				System.out.print("New Email: ");
				String ne = input.nextLine();

				Contact updated = cs.createContact(ef, el, na, nc, ns, nz, np, ne);

				System.out.println(cs.editContact(editBook, ef, el, updated) ? "Contact updated!" : "Contact not found!");
				break;

			case 4:
				System.out.print("Enter Address Book Name: ");
				AddressBook delBook = abs.getAddressBook(input.nextLine());

				if (delBook == null) {
					System.out.println("Address Book not found!");
					break;
				}

				System.out.print("First Name: ");
				String df = input.nextLine();

				System.out.print("Last Name: ");
				String dl = input.nextLine();

				System.out.println(cs.deleteContact(delBook, df, dl) ? "Contact deleted!" : "Contact not found!");
				break;

			case 5:
				System.out.print("Enter City: ");
				ss.searchByCity(abs.getAllAddressBooks(), input.nextLine())
						.forEach(c -> System.out.println(c.getFirstName() + " " + c.getLastName()));
				break;

			case 6:
				System.out.print("Enter State: ");
				ss.searchByState(abs.getAllAddressBooks(), input.nextLine())
						.forEach(c -> System.out.println(c.getFirstName() + " " + c.getLastName()));
				break;

			case 7:
				System.out.print("Enter City: ");
				System.out.println("Count: " + ss.countByCity(abs.getAllAddressBooks(), input.nextLine()));
				break;

			case 8:
				System.out.print("Enter State: ");
				System.out.println("Count: " + ss.countByState(abs.getAllAddressBooks(), input.nextLine()));
				break;

			case 9:
				abs.getAllAddressBooks().forEach(b -> sortService.sortByName(b.getContacts()));
				System.out.println("Sorted by Name");
				break;

			case 10:
				abs.getAllAddressBooks().forEach(b -> sortService.sortByCity(b.getContacts()));
				System.out.println("Sorted by City");
				break;

			case 11:
				abs.getAllAddressBooks().forEach(b -> sortService.sortByState(b.getContacts()));
				System.out.println("Sorted by State");
				break;

			case 12:
				abs.getAllAddressBooks().forEach(b -> sortService.sortByZip(b.getContacts()));
				System.out.println("Sorted by Zip");
				break;

			/* ************************************************
			 * UC-13
			 * Write AddressBook to Text File
			 ************************************************ */
			case 13:
				System.out.print("Enter Address Book Name: ");
				AddressBook writeBook = abs.getAddressBook(input.nextLine());

				if (writeBook == null) {
					System.out.println("Address Book not found!");
					break;
				}

				System.out.print("Enter File Name (example: output.txt): ");
				String textFile = input.nextLine();

				System.out.println(fileIOService.writeToTextFile(writeBook, textFile) ? "Saved Successfully!"
						: "File Save Failed!");
				break;

			/* ************************************************
			 * UC-13
			 * Read AddressBook from Text File
			 ************************************************ */
			case 14:
				System.out.print("Enter File Name (example: output.txt): ");
				String readTextFile = input.nextLine();

				fileIOService.readFromTextFile(readTextFile);
				break;

			/* ************************************************
			 * UC-14
			 * Write AddressBook to CSV File
			 ************************************************ */
			case 15:
				System.out.print("Enter Address Book Name: ");
				AddressBook csvBook = abs.getAddressBook(input.nextLine());

				if (csvBook == null) {
					System.out.println("Address Book not found!");
					break;
				}

				System.out.print("Enter CSV File Name (example: output.csv): ");
				String csvFile = input.nextLine();

				System.out.println(fileIOService.writeToCSVFile(csvBook, csvFile) ? "CSV Saved Successfully!"
						: "CSV Save Failed!");
				break;

			/* ************************************************
			 * UC-14
			 * Read AddressBook from CSV File
			 ************************************************ */
			case 16:
				System.out.print("Enter CSV File Name (example: output.csv): ");
				String readCSVFile = input.nextLine();

				List<Contact> contacts = fileIOService.readFromCSVFile(readCSVFile);

				System.out.println("\n------ CSV FILE CONTACTS ------");
				for (Contact c : contacts) {
					System.out.println(c.toString());
				}
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);

		input.close();
	}
}
