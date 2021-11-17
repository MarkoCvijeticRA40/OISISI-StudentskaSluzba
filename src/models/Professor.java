package models;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Professor {

	public String firstName;
	public String lastName;
	public LocalDate dateOfBirth;
	public Address address;
	public String phoneNumber;
	public String email;
	public Address officeAddress;
	public int idCardNumber;
	public String title;
	public int yearsOfService;
	public List<Predmet> subjects;
	
	public Professor(String firstName, String lastName, LocalDate dateOfBirth, Address address, String phoneNumber,
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
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
}
