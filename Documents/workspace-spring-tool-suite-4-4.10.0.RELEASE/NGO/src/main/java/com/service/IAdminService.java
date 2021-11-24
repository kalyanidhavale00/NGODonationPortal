package com.service;

import java.util.List;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

public interface IAdminService {
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException;
	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException;
	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException;
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException;
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException;
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException;
	public boolean approveDonation(DonationDistribution distribution);
}
