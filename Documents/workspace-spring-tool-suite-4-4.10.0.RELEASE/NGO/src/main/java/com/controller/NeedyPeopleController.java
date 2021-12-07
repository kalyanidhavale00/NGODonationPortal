package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.Donor;
import com.model.NeedyPeople;
import com.service.INeedyPeopleService;
import com.service.NeedyPeopleServiceImpl;

@RestController
@RequestMapping(path="/needyPeople")
public class NeedyPeopleController {

	@Autowired
	INeedyPeopleService needyPeopleService;
	
	@PostMapping("/reg/add")
    public  ResponseEntity<NeedyPeople> registerNeedyPerson(@RequestBody NeedyPeople person) throws NoSuchNeedyPeopleException{
		NeedyPeople p = needyPeopleService.registerNeedyPerson(person);
        return new ResponseEntity<NeedyPeople>(person,HttpStatus.CREATED);
    }
	
	
}
