package com.cg.onlineadvapi.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * This class is the the model/POJO/domain class for address object
 * This class attributes will be embedded in User Entity table
 * @author rupesh singh
 *
 */
@Embeddable
public class Address {
	
	@NotBlank(message="Room No cannot be left empty")
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
	private String roomNo;
	@NotBlank(message="Street cannot be left empty")
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$")
	private String street;
	@NotBlank(message="City cannot be left empty")
	@Pattern(regexp = "^[a-zA-Z ]*$")
	private String city;
	@NotNull(message="Street cannot be left empty")
	@Pattern(regexp = "^[0-9]*$")
	private Integer pincode;
	
	public Address() {
		super();
	}


	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	
}