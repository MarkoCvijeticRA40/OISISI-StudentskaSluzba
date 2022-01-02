package models;

import java.io.Serializable;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 4149277647796613283L;
	
	private String street;
	private int houseNumber;
	private String city;
	private String country;
	
	public Address(String street, int houseNumber, String city, String country) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
