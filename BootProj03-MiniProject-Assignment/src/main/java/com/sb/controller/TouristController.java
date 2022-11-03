package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sb.model.Tourist;
import com.sb.service.ITouristService;

@Controller("controller")
public class TouristController {
	@Autowired
	private ITouristService service;
	
	public List<Tourist> showTouristDetails(String state1, String state2, String state3)throws Exception{
		List<Tourist> list = service.getTouristByState(state1, state2, state3);
		return list;
	}
}
