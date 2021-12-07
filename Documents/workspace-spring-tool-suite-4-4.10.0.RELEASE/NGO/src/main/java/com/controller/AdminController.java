package com.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Employee;
import com.service.IAdminService;
import com.service.IEmployeeService;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
	
	@Autowired
	IEmployeeService empService;
	
	@Autowired
	IAdminService adminService;
	
	@RequestMapping("/Hello")
	public String helloAdmin() {
		String msg = "Welcome to Admin services";
		return msg;
	}
	
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee)throws SQLException, DuplicateEmployeeException {
		Employee emp = adminService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/employee/update")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee) throws Throwable {
		Employee e1 = adminService.modifyEmployee(employee);

		ResponseEntity<Employee> re = new ResponseEntity<Employee>(e1, HttpStatus.OK);
		return re;
	}
	@DeleteMapping(path = "/employee/remove/{eid}")
	public ResponseEntity<Employee> removeEmployee(@PathVariable int eid) throws NoSuchEmployeeException {
		adminService.removeEmployee(eid);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.OK);
		return re;
	}
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int employeeId) throws NoSuchEmployeeException {
		Employee lc = adminService.findEmployeeById(employeeId);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(lc, HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/employee/{employeeName}")
	public ResponseEntity<Employee> findEmployeeByName(@PathVariable String employeeName)
			throws NoSuchEmployeeException {
		Employee lc = adminService.findEmployeeByName(employeeName);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(lc, HttpStatus.OK);
		return re;
	}
	@GetMapping("/employee/get")
	public ResponseEntity<List<Employee>> findAllEmployee() {
		List<Employee> lcl = adminService.findAllEmployee();
		ResponseEntity<List<Employee>> re = new ResponseEntity<List<Employee>>(lcl, HttpStatus.OK);
		return re;
	}
}
