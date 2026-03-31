import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Contact {
    private String name;
    private String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }
}

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class ContactManager {

    static ArrayList<Contact> contacts = new ArrayList<>();

    // Phone number validation
    public static String validatePhoneNumber(String phoneNumber)
            throws InvalidPhoneNumberException {

        if (phoneNumber.length() != 10) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                throw new InvalidPhoneNumberException("Phone number must contain only digits");
            }
        }
        return phoneNumber;
    }

    // Check duplicate phone number
    public static boolean isDuplicate(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // Add contact
    public static boolean addContact(String name, String phoneNumber)
            throws InvalidPhoneNumberException {

        validatePhoneNumber(phoneNumber);

        if (isDuplicate(phoneNumber)) {
            System.out.println("Duplicate contact not allowed");
            return false;
        }

        contacts.add(new Contact(name, phoneNumber));
        return true;
    }

    // Search contact
    public static Contact searchByPhone(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return c;
            }
        }
        return null;
    }

    // Delete contact
    public static boolean deleteContact(String phoneNumber) {
        Contact c = searchByPhone(phoneNumber);
        if (c != null) {
            contacts.remove(c);
            return true;
        }
        return false;
    }
}

class PhoneContactOrganizer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            if (ContactManager.addContact(name, phone)) {
                System.out.println("Contact added successfully");
            }

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}