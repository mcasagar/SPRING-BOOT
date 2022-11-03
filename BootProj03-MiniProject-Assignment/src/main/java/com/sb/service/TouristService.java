package com.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.ITouristDAO;
import com.sb.model.Tourist;

@Service("touristService")
public class TouristService implements ITouristService {
	@Autowired
	private ITouristDAO dao;
	
	@Override
	public List<Tourist> getTouristByState(String state1, String state2, String state3) throws Exception {
		//use dao
		List<Tourist> list = dao.fetchTourByState(state1, state2, state3);
		return list;
	}

}
