package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.repository.AdminRepository;
import com.repository.EmployeeRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		int id = employee.getEmployeeId();
		if (id == 0) {
			throw new DuplicateEmployeeException();
		} else {
			Employee emp = empRepository.save(employee);
		}
		return employee;
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws Throwable {
		int id = employee.getEmployeeId();
		Supplier s1 = () -> new NoSuchEmployeeException("Employee Does not exist in the database");
		@SuppressWarnings("unchecked")
		Employee emp = empRepository.findById(id).orElseThrow(s1);

		emp.setEmployeeName(emp.getEmployeeName());
		emp.setPhone(emp.getPhone());
		empRepository.save(emp);

		return emp;

	}

	@Override
	public String removeEmployee(int employeeId) throws NoSuchEmployeeException {
		if (employeeId != 0)
			empRepository.deleteById(employeeId);

		else
			throw new NoSuchEmployeeException("Employee is not there in database");
		return "deleted";
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> optional = empRepository.findById(employeeId);
		Employee emp = optional.get();
		if (optional.isPresent()) {
			empRepository.getById(employeeId);
			return emp;
		} else
			throw new NoSuchEmployeeException("No Such Employee Found");
	}

	@Override
	public Employee findEmployeeByName(String name) throws NoSuchEmployeeException {
		Employee e=empRepository.findByEmployeeName(name);
		return e;
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> lc1 = empRepository.findAll();

		return lc1;
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println("donation was approved");
		return false;
	}

}
