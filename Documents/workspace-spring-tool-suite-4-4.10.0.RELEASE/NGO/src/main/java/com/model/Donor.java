package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Donor {
	@Id
	@GeneratedValue
	private int donorId;
	private String donorName;
	private String donorEmail;
	private String donorPhone;
	private String donorUsername;
	private String donorPassword;
	
	/*
	 * adding a new column to store a random token key which is used to protect the reset password
	 * update the corresponding entity class, by declaring a new field named resetPasswordToken
	 * */
	// private String resetPasswordToken;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	public Donor() {}
	
	public Donor(String donorUsername, String donorPassword) {
		super();
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
	}
	
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorEmail() {
		return donorEmail;
	}
	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}
	public String getDonorPhone() {
		return donorPhone;
	}
	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}
	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}
	public String getDonorPassword() {
		return donorPassword;
	}
	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	/*public String getResetPasswordToken() {
		return resetPasswordToken;
	}
	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}*/
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorEmail=" + donorEmail + ", donorPhone="
				+ donorPhone + ", donorUsername=" + donorUsername + ", donorPassword=" + donorPassword + ", address="
				+ address + "]";
	}
	

	

}
