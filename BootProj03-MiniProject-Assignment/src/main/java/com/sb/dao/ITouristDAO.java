package com.sb.dao;

import java.util.List;

import com.sb.model.Tourist;

public interface ITouristDAO {
	public List<Tourist> fetchTourByState(String state1, String state2, String state3) throws Exception; 
}
