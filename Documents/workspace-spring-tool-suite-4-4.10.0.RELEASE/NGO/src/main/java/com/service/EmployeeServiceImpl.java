package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;
import com.repository.EmployeeRepository;
import com.repository.NeedyPeopleRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	NeedyPeopleRepository needyPeople;
	
	@Override
	public boolean login(Employee employee) throws NoSuchEmployeeException {

		return false;
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		needyPeople.save(person);
		return person;
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		needyPeople.delete(person);
		return true;
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		NeedyPeople n=needyPeople.findById(id).get();
		return n;
	}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		
		return null;
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		return needyPeople.findAll();
	}

	@Override
	public String helpNeedyPerson(DonationDistribution distribute) {
		return null;
	}

}
