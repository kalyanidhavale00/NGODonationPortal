package com.service;

import java.util.List;

import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

public interface IEmployeeService {

	public boolean login(Employee employee)throws NoSuchEmployeeException;
	public boolean addNeedyPerson(NeedyPeople person);
	public boolean removeNeedyPerson(NeedyPeople person);
	public NeedyPeople findNeedyPeopleById(int id);
	public List<NeedyPeople> findNeedyPeopleByName(String name);
	public List<NeedyPeople> findAllNeedyPeople();
	public String helpNeedyPerson(DonationDistribution distribute);
}
