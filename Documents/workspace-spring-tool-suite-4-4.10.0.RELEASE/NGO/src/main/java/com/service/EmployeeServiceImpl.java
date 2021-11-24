package com.service;

import java.util.List;

import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public boolean login(Employee employee) throws NoSuchEmployeeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNeedyPerson(NeedyPeople person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helpNeedyPerson(DonationDistribution distribute) {
		// TODO Auto-generated method stub
		return null;
	}

}
