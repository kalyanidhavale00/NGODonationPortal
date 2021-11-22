package com.service;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;

public class DonorServiceImpl implements IDonorService {

	@Override
	public boolean registerDonor(Donor donor) throws DuplicateDonorException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(Donor donor) throws NoSuchDonorException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Donation donateToNGO(Donation donation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendThankyouMailToDonator(Donor donor) {
		// TODO Auto-generated method stub

	}

	@Override
	public String forgotPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void emailPasswordToDonor(String email) {
		// TODO Auto-generated method stub

	}

}
