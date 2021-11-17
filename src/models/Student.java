package models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

enum Status {B, S}

public class Student {
	
	public String firstName;
	public String lastName;
	public Date dateOfBirth;
	public Address address;
	public String phoneNumber;
	public String email;
	public String indexNumber;
	public int enrollmentYear;
	public int currentStudiesYear;
	public Status financingStatus;
	public double rating;
	public List<Ocena> passedExams;
	public List<Predmet> notPassedExams;
	
	public Student(String firstName, String lastName, Date dateOfBirth, Address address, String phoneNumber,
			String email, String indexNumber, int enrollmentYear, int currentStudiesYear, Status financingStatus,
			double rating) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.indexNumber = indexNumber;
		this.enrollmentYear = enrollmentYear;
		this.currentStudiesYear = currentStudiesYear;
		this.financingStatus = financingStatus;
		this.rating = rating;
		this.passedExams = new LinkedList<>();
		this.notPassedExams = new LinkedList<>();
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

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(int enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public int getCurrentStudiesYear() {
		return currentStudiesYear;
	}

	public void setCurrentStudiesYear(int currentStudiesYear) {
		this.currentStudiesYear = currentStudiesYear;
	}

	public Status getFinancingStatus() {
		return financingStatus;
	}

	public void setFinancingStatus(Status financingStatus) {
		this.financingStatus = financingStatus;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
