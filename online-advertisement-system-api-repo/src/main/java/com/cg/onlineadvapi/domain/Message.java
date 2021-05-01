package com.cg.onlineadvapi.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Class is a Model Class for Message Entity Table
 * @author mohdansa
 */
@Entity
@Table(name = "messages")
public class Message {

	/**
	 * This field is used to identify Message : Auto Generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer messageId;
	/**
	 * This field is used to identify Advertise
	 */
	private Integer advertiseId;
	/**
	 * This field is used to identify Sender User
	 */
	private Integer senderId;
	/**
	 * This field is used to identify Reciever User
	 */
	private Integer recieverId;
	/**
	 * This field is used to identify Sender User Name
	 */
	private String senderUserName;
	/**
	 * This field to get Message 
	 */
	@NotBlank(message = "Message should not be Blank")
	@Size(min=1 , max=160,message = "Message Should be between 1 to 160 character")
	private String message;
	/**
	 * This field is used to get send date
	 */
	@JsonFormat(pattern="HH:mm dd-MM-yyyy")
	private Date send_At;
	/**
	 * This field is used to get seen date
	 */
	@JsonFormat(pattern="HH:mm dd-MM-yyyy")
	private Date seen_At;
	
	/**
	 * Constructor without parameter
	 */
	public Message() {
		super();
	}
	
	/**
	 * Getters and Setters
	 */
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getAdvertiseId() {
		return advertiseId;
	}
	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId= senderId;
	}
	public Integer getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(Integer recieverId) {
		this.recieverId = recieverId;
	}
	public String getSenderUserName() {
		return senderUserName;
	}
	public void setSenderUserName(String senderUserName) {
		this.senderUserName = senderUserName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSend_At() {
		return send_At;
	}
	public void setSend_At(Date send_At) {
		this.send_At = send_At;
	}
	public Date getSeen_At() {
		return seen_At;
	}
	public void setSeen_At(Date seen_At) {
		this.seen_At = seen_At;
	}
	
	@PrePersist
	protected void sendOn() {
		this.send_At = new Date();
	}

	@PreUpdate
	protected void seenOn() {
		this.seen_At = new Date();
	}
	
}
