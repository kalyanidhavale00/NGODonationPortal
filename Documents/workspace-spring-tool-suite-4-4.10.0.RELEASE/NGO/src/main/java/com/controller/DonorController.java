
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.Donation;
import com.model.Donor;
import com.model.NeedyPeople;
import com.service.DonorServiceImpl;
import com.service.IDonorService;

@RestController
@RequestMapping(path = "/donor")
public class DonorController {

	@Autowired
	DonorServiceImpl donorService;

	@PostMapping("/login/add")
	public ResponseEntity<Donor> registerDonor(@RequestBody Donor donor) throws DuplicateDonorException {
		Donor p = donorService.registerDonor(donor);
		return new ResponseEntity<Donor>(p, HttpStatus.CREATED);
	}

	@GetMapping("/login/{donorUsername}/{donorPassword}")
	public ResponseEntity<Donor> login(@PathVariable("donorUsername") String donorUsername,
			@PathVariable("donorPassword") String donorPassword) throws NoSuchDonorException {
		Donor user1 = new Donor(donorUsername, donorPassword);
		Donor user = donorService.login(user1);
		System.out.println("your login is completed");
		return new ResponseEntity<Donor>(user, HttpStatus.ACCEPTED);
	}

	@PostMapping("/donation/add")
	public ResponseEntity<?> donateToNGO(Donation donation) {
		Donation addDonation = donorService.donateToNGO(donation);
		return new ResponseEntity<Donation>(addDonation, HttpStatus.CREATED);
	}

}