package com.vspl.service;

import java.util.List;

import com.vspl.entity.Tourist;
import com.vspl.exception.TouristNotFoundException;

public interface ITouristMgmtService {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer id)throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist)throws TouristNotFoundException;
	public String deleteTourist(Integer tid)throws TouristNotFoundException;
	public String updateTouristBudgetByIds(Integer id, Float hikePercent) throws TouristNotFoundException;
	
}
