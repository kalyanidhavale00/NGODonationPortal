package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.model.Donor;

public interface DonorRepository extends JpaRepository<Donor,Integer> {
	/*@Query("SELECT d FROM donar d WHERE d.donor_email = ?1")
    public Donor findByEmail(String email); 
     
    public Donor findByResetPasswordToken(String token);*/
}
