package com.vspl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vspl.entity.Tourist;
import com.vspl.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	
	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
			//use service
			String resultMsg = service.registerTourist(tourist);
			HttpStatus status = HttpStatus.CREATED; //201 - Content created successfully
			return new ResponseEntity<String>(resultMsg,status);
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in tourist enrollment",HttpStatus.INTERNAL_SERVER_ERROR); //500 error 
		}//catch
	}//method
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourist(){
		try {
			List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching tourist",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}//method
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id){
		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Tourist Not Found :: "+id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		try {
			String msg = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method()
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id){
		try {
			//use service
			String msg = service.deleteTourist(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); // 404 error
		}
		
	}//method()
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer id,
																													@PathVariable("hike") Float hikePercent){
		try {
			//use service
			String msg = service.updateTouristBudgetByIds(id, hikePercent);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); //304 not modify
		}
	}
}//class
