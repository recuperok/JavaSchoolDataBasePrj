package holders;

import java.io.Serializable;
import instances.BagInstance;

@SuppressWarnings("serial")
public class Person implements Serializable {
	private  String firstName;
	private String lastName;
	private String id;
	private String phone;
	
	public Person(String firstName, String lastName, String id, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
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
		return "First Name: " + firstName + ". LastName: " + lastName + ". ID: " + id + ". Phone #: " + phone + ".";
	}

	@SuppressWarnings("static-access")
	public void setId(String id) {
		this.id = String.valueOf(BagInstance.bb.getNElements()).format("%05s", 1);
	}
}
