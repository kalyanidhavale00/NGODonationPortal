package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.NeedyPeople;

public interface NeedyPeopleDao extends JpaRepository<NeedyPeople, Integer> {

}
