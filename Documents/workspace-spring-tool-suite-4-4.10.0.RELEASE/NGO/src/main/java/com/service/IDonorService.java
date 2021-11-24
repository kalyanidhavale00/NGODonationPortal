package com.service;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

public interface IDonorService {
	public Donor registerDonor(Donor donor) throws DuplicateDonorException;
	public Donor login(Donor donor) throws NoSuchDonorException;
	public Donation donateToNGO(Donation donation);
	public String sendThankyouMailToDonator(Donor donor);
	public String forgotPassword(String username);
	public String resetPassword(String username);
	public String emailPasswordToDonor(String email);
}
