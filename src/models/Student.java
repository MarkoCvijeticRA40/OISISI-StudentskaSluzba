package models;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Student implements Serializable {
	
	private static final long serialVersionUID = 5563052622475592202L;
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Address address;
	private String phoneNumber;
	private String email;
	private String indexNumber;
	private int enrollmentYear;
	private int currentStudiesYear;
	private Status financingStatus;
	private double rating;
	private List<ExamGrade> passedExams;
	private List<Subject> notPassedExams;
	
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
	
	public List<ExamGrade> getPassedExams() {
		return this.passedExams;
	}
	
	public List<Subject> getNotPassedExams() { 
		return this.notPassedExams;
	}
}
