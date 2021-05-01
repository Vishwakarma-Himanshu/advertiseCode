package com.cg.onlineadvapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

/**
 * Advertise Table created
 * @author hvishwak
 *
 */
@Entity
@Table(name = "advertises")
public class Advertise {

	/**
	 * Primary key of advertise which is auto generating
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer advertiseId;
	/**
	 * Advertise title 
	 * @NotBlank used to give required error message if field is empty
	 */
	@NotBlank(message = "Title is required")
	@Pattern(regexp = "[A-Za-z0-9_.]*",message = "Advertise title cannot contain special chracters")
	private String advertiseTitle;
	/**
	 * Advertise category this define the type of advertise 
	 * @NotBlank used to give required error message if field is empty
	 * @column used with attribute updatable with false value this field cannot be modified
	 * Regex Pattern is also used with error message
	 */
	@NotBlank(message = "Category is required")
	@Column(updatable = false)
	@Pattern(regexp = "[a-zA-Z_.]*",message = "Category cannot contain special characters or number")
	private String category;
	/**
	 * Advertise Price it should not be empty
	 * @DecimalMin denotes it takes numbers only that also 1 or more than 1
	 */
	@NotNull(message = "It cannot be empty")
	@DecimalMin(value = "0", inclusive = false,message="Product Price should be greater than or equal to 1")	
	private Double price;
	/**
	 * Advertise description 
	 * It can be set empty
	 */
	private String description;
	/**
	 * Advertise status
	 * Denote the status of advertise posted
	 * default value is NEW 
	 */
	private String status;
	/**
	 * Advertise class default constructor
	 */
	public Advertise() {
		super();
	}

	public Advertise(
			@NotBlank(message = "Title is required") @Pattern(regexp = "[A-Za-z0-9_.]*", message = "Advertise title cannot contain special chracters") String advertiseTitle,
			@NotBlank(message = "Category is required") @Pattern(regexp = "[a-zA-Z_.]*", message = "Category cannot contain special characters or number") String category,
			@NotNull(message = "It cannot be empty") @DecimalMin(value = "0", inclusive = false, message = "Product Price should be greater than or equal to 1") Double price,
			String description, String status) {
		super();
		this.advertiseTitle = advertiseTitle;
		this.category = category;
		this.price = price;
		this.description = description;
		this.status = status;
	}

	
//	public Advertise(Integer advertiseId,
//			@NotBlank(message = "Title is required") @Pattern(regexp = "[A-Za-z0-9_.]*", message = "Advertise title cannot contain special chracters") String advertiseTitle,
//			@NotBlank(message = "Category is required") @Pattern(regexp = "[a-zA-Z_.]*", message = "Category cannot contain special characters or number") String category,
//			@NotNull(message = "It cannot be empty") @DecimalMin(value = "0", inclusive = false, message = "Product Price should be greater than or equal to 1") Double price,
//			String description, String status) {
//		super();
//		this.advertiseId = advertiseId;
//		this.advertiseTitle = advertiseTitle;
//		this.category = category;
//		this.price = price;
//		this.description = description;
//		this.status = status;
//	}

	/**
	 * getter and setter of above fields
	 * @return
	 */
	public Integer getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}

	public String getAdvertiseTitle() {
		return advertiseTitle;
	}

	public void setAdvertiseTitle(String advertiseTitle) {
		this.advertiseTitle = advertiseTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
