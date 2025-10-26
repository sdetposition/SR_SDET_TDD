package jsonUtils;

import java.util.List;

public class Person {

	public String firstName;
	public String lastName;
	public List<Address> address;

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

	public List<Address> getAddresses() {
		return address;
	}

	public void setAddresses(List<Address> address) {
		this.address = address;
	}

	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getAddresses();
	}
}
