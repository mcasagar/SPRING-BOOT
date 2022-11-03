package com.sb.service;

import java.util.List;

import com.sb.model.Tourist;

public interface ITouristService {
	public List<Tourist> getTouristByState(String state1, String state2, String state3)throws Exception;
}
