package ServiceLayer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import ModelLayer.AddressBook;
import ModelLayer.Contact;

public class FileIOService {

	/* ************************************************
	 * UC-13
	 * Write AddressBook contacts into a text file
	 ************************************************ */
	public boolean writeToTextFile(AddressBook book, String filePath) {

		if (book == null)
			return false;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

			bw.write("ADDRESS_BOOK=" + book.getAddressBookName());
			bw.newLine();

			for (Contact c : book.getContacts()) {

				bw.write("FirstName: " + c.getFirstName());
				bw.newLine();

				bw.write("LastName: " + c.getLastName());
				bw.newLine();

				bw.write("Address: " + c.getAddress());
				bw.newLine();

				bw.write("City: " + c.getCity());
				bw.newLine();

				bw.write("State: " + c.getState());
				bw.newLine();

				bw.write("Zip: " + c.getZipCode());
				bw.newLine();

				bw.write("Phone: " + c.getPhoneNumber());
				bw.newLine();

				bw.write("Email: " + c.getEmail());
				bw.newLine();

				bw.write("-----------------------------------");
				bw.newLine();
			}

			return true;

		} catch (Exception e) {
			System.out.println("Text File Write Error: " + e.getMessage());
			return false;
		}
	}

	/* ************************************************
	 * UC-13
	 * Read AddressBook contacts from a text file
	 * (This method prints file content)
	 ************************************************ */
	public boolean readFromTextFile(String filePath) {

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;

			System.out.println("\n------ TEXT FILE CONTENT ------");

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			return true;

		} catch (Exception e) {
			System.out.println("Text File Read Error: " + e.getMessage());
			return false;
		}
	}

	/* ************************************************
	 * UC-14
	 * Write AddressBook contacts into a CSV file
	 ************************************************ */
	public boolean writeToCSVFile(AddressBook book, String filePath) {

		if (book == null)
			return false;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

			bw.write("FirstName,LastName,Address,City,State,Zip,Phone,Email");
			bw.newLine();

			for (Contact c : book.getContacts()) {

				bw.write(c.getFirstName() + "," + c.getLastName() + "," + c.getAddress() + "," + c.getCity() + ","
						+ c.getState() + "," + c.getZipCode() + "," + c.getPhoneNumber() + "," + c.getEmail());

				bw.newLine();
			}

			return true;

		} catch (Exception e) {
			System.out.println("CSV File Write Error: " + e.getMessage());
			return false;
		}
	}

	/* ************************************************
	 * UC-14
	 * Read AddressBook contacts from a CSV file
	 ************************************************ */
	public List<Contact> readFromCSVFile(String filePath) {

		List<Contact> contacts = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;

			// Skip header line
			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				if (data.length == 8) {

					Contact c = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);

					contacts.add(c);
				}
			}

		} catch (Exception e) {
			System.out.println("CSV File Read Error: " + e.getMessage());
		}

		return contacts;
	}
}
