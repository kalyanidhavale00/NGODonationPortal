package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateDonorException;
import com.model.Donation;
import com.model.Donor;
import com.service.IDonorService;

@RestController
@RequestMapping(path="/donor")
public class DonorController {

	@Autowired
	IDonorService donorService;
	
	
	@PostMapping("/donorreg/add")
	public ResponseEntity<Donor>registerDonor(@RequestBody Donor donor) throws DuplicateDonorException{
		Donor resDonor=donorService.registerDonor(donor);
		return new ResponseEntity<Donor>(resDonor,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/donation/add")
	public ResponseEntity<Donation> donateToNGO(@RequestBody Donation donation){
		Donation addDonation =donorService.donateToNGO(donation);
		return new ResponseEntity<Donation>(addDonation,HttpStatus.CREATED);
	}
	
}
