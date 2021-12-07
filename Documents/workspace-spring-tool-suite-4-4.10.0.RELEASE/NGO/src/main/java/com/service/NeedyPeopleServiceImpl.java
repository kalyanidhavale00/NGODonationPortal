package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.NoSuchDonorException;
import com.exception.NoSuchNeedyPeopleException;
import com.model.Donor;
import com.model.NeedyPeople;
import com.repository.NeedyPeopleRepository;

@Service
public class NeedyPeopleServiceImpl implements INeedyPeopleService {

	@Autowired 
	NeedyPeopleRepository needyPeopleRepository;
	@Override
	public NeedyPeople registerNeedyPerson(NeedyPeople person) throws NoSuchNeedyPeopleException
	{
		NeedyPeople rn= needyPeopleRepository.findById(person.getNeedyPersonId()).orElse(null);
		if (rn != null)
			throw new NoSuchNeedyPeopleException("no such needyPeople ");
		else 
			rn = needyPeopleRepository.save(person);
		return rn;
		
		
	}

	@Override
	public boolean login(NeedyPeople person)throws NoSuchNeedyPeopleException{
		NeedyPeople needid=needyPeopleRepository.findById(person.getNeedyPersonId()).orElse(null);
		if(needid==null) {
			String NoSuhNeedyPeople="No such  person found by id"+person.getNeedyPersonId();
			throw new NoSuchNeedyPeopleException(NoSuhNeedyPeople); 
		}
		else {
			if(person.getNeedyPersonName().equals(needid.getNeedyPersonName())&& person.getPhone().equals(needid.getPhone())) {
				return true;
			}
			else {
				throw new NoSuchNeedyPeopleException("Invalid data");
			}
		}
	}

	@Override
	public boolean requestForHelp(NeedyPeople person) {
		return false;
	}

}
