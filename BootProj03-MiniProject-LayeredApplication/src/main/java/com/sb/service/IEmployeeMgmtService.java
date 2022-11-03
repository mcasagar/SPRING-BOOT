package com.sb.service;

import java.util.List;

import com.sb.model.Employee;

public interface IEmployeeMgmtService {
	List<Employee> fetchEmpDetailsByDesg(String desg1, String desg2, String desg3) throws Exception;
}
