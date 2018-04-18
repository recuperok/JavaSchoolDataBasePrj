package holders;

import java.io.Serializable;
//import instances.BagInstance;

@SuppressWarnings("serial")
public class Person implements Serializable {
	protected String firstName;
	protected String lastName;
	protected String id;
	protected String address;
	protected String phone;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String id, String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.phone = phone;
		this.address = address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
	
	public String getId() {
		return id;
	}
	
	public String getPhone() {
		return phone;
	}


	
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "; ID #:" + id + "; Address:" + address
				+ "; Phone: " + phone + " ";
	}

	@SuppressWarnings("static-access")
	public void setId(String id) {
		this.id = id;
	}
}
