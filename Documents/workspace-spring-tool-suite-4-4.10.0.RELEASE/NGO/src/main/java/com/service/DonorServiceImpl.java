package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.model.Donation;
import com.model.Donor;
import com.repository.DonationRepository;
import com.repository.DonorRepository;

@Service
public class DonorServiceImpl implements IDonorService {
	
	@Autowired
	DonorRepository donorRepository;
	
	@Autowired
	DonationRepository donationRepository;
	
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException {
		if(checkIfUserExist(donor.getDonorId())) {
			throw new DuplicateDonorException ("user is already exists for this email");
		}
		else {
			return donorRepository.save(donor);
		}	
	}

	@Override
	public Donor login(Donor donor) throws NoSuchDonorException {
		Donor doid=donorRepository.findById(donor.getDonorId()).orElse(null);
		if(doid==null) {
			String NoSuchDonor="No Donor found by the donor id"+donor.getDonorId();
			throw new  NoSuchDonorException(NoSuchDonor);
		}
		else {
			if(donor.getDonorUsername().equals(doid.getDonorUsername()) && donor.getDonorPassword().equals(doid.getDonorPassword())){
				return doid;
			}
			else {
				throw new NoSuchDonorException("Donor username and password are invalid");
			}
		}	
	}

	@Override
	public Donation donateToNGO(Donation donation) {
		return donationRepository.save(donation);	 
	}

	@Override
	public String sendThankyouMailToDonator(Donor donor) {
		return "Thank you for Donating!!!!!!!!!!";

	}

	@Override
	public String forgotPassword(String username) {
		return null;
	}

	@Override
	public String resetPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emailPasswordToDonor(String email) {
		return"click here for reset the password.....";

	}
	public boolean checkIfUserExist(int donorId ) {
		return donorRepository.findById(donorId)!= null ? true : false;
		
	}

}
