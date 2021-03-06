package com.service;

import java.sql.SQLException;
import java.util.List;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;

public interface IAdminService {
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException,SQLException;
	public Employee modifyEmployee(Employee employee) throws Throwable;
	public String removeEmployee(int employeeId) throws NoSuchEmployeeException;
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException;
	public Employee findEmployeeByName(String name) throws NoSuchEmployeeException;
	public List<Employee> findAllEmployee();
	public boolean approveDonation(DonationDistribution distribution);
}
