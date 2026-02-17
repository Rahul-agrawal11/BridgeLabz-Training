package ModelLayer;

/*
 * Model class for Contact
 * UC-1: Ability to create a Contact
 */

public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String email;

	public Contact(String firstName, String lastName, String address, String city, String state, String zipCode,
			String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	// Getters & Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/* ************************************************
	 * UC-7
	 * Override equals method for duplicate check
	 ************************************************ */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Contact other = (Contact) obj;

		return this.firstName.equalsIgnoreCase(other.firstName)
				&& this.lastName.equalsIgnoreCase(other.lastName);
	}

	/* ************************************************
	 * UC-7
	 * Override hashCode method (Required with equals)
	 ************************************************ */
	@Override
	public int hashCode() {
		return (firstName.toLowerCase() + lastName.toLowerCase()).hashCode();
	}

	/* ************************************************
	 * UC-11
	 * Override toString method to print contact details
	 ************************************************ */
	@Override
	public String toString() {
		return firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zipCode + " | "
				+ phoneNumber + " | " + email;
	}
}
