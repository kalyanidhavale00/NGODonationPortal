package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
