package com.service;

import com.exception.NoSuchNeedyPeopleException;
import com.model.NeedyPeople;

public interface INeedyPeopleService {
	public NeedyPeople registerNeedyPerson(NeedyPeople person)throws NoSuchNeedyPeopleException;
	public boolean login(NeedyPeople person)throws NoSuchNeedyPeopleException;
	public boolean requestForHelp(NeedyPeople person);
}
