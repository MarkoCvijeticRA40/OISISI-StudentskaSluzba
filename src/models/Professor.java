package models;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Professor implements Serializable {

	private static final long serialVersionUID = -1941362564588381766L;
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Address address;
	private String phoneNumber;
	private String email;
	private Address officeAddress;
	private int idCardNumber;
	private String title;
	private int yearsOfService;
	private List<Subject> subjects;
	
	public Professor(String firstName, String lastName, Date dateOfBirth, Address address, String phoneNumber,
			String email, Address officeAddress, int idCardNumber, String title, int yearsOfService) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.officeAddress = officeAddress;
		this.idCardNumber = idCardNumber;
		this.title = title;
		this.yearsOfService = yearsOfService;
		this.subjects = new LinkedList<>();
	}
	
	public Professor(String firstName, String lastName, String title, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.email = email;
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
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
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
	
	public Address getOfficeAddress() {
		return officeAddress;
	}
	
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public int getIdCardNumber() {
		return idCardNumber;
	}
	
	public void setIdCardNumber(int idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYearsOfService() {
		return yearsOfService;
	}
	
	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	
	public List<Subject> getSubjects() {
		return this.subjects;
	}

	@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", title=" + title
				+ "]";
	}
}
