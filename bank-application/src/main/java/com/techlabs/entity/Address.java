package com.techlabs.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private String addressId;
	private String street;
	private String city;
	private String district;
	private String state;
	private int zipcode;

	public Address() {
		System.out.println("Addess-constr");
	}

	public Address(String street, String city, String district, 
			       String state, int zipcode) {
		super();

		UUID uuid = UUID.randomUUID();
		this.addressId = uuid.toString().replace("-", "");

		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
		this.zipcode = zipcode;
		System.out.println("Address-para_constr");
	}

	public String getAddressId() {
		return addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
