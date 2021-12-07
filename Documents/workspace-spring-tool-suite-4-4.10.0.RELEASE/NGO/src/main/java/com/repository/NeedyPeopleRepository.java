package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.NeedyPeople;

public interface NeedyPeopleRepository extends JpaRepository<NeedyPeople, Integer> {

	NeedyPeople findByNeedyPersonName(String name);


}
