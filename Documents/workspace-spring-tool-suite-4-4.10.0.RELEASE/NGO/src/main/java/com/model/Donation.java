package com.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Donation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int donationId;
	private double donationAmount;
	private Date donationDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="donor_id")
	private Donor donor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_id")
	private DonationItem item;
	
	
	public int getDonationId() {
		return donationId;
	}
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public DonationItem getItem() {
		return item;
	}
	public void setItem(DonationItem item) {
		this.item = item;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donationAmount=" + donationAmount + ", donationDate="
				+ donationDate + ", donor=" + donor + ", item=" + item + "]";
	}

}
