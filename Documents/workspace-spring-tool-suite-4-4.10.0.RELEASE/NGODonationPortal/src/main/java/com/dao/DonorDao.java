package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Donor;

public interface DonorDao extends JpaRepository<Donor, Integer> {

}
