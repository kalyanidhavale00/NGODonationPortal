package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Donation;
import com.model.Donor;
import com.service.IDonorService;

@RestController
@RequestMapping(path="/donor")
public class DonorController {

	@Autowired
	IDonorService donorService;
	
	@PostMapping("/donation/add")
	public ResponseEntity<?> donateToNGO(Donation donation){
		Donation addDonation =donorService.donateToNGO(donation);
		return new ResponseEntity<Donation>(addDonation,HttpStatus.CREATED);
	}
}
