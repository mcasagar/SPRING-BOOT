package com.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.IEmployeeDAO;
import com.sb.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public List<Employee> fetchEmpDetailsByDesg(String desg1, String desg2, String desg3) throws Exception {
		//use DAO
		List<Employee> listEmps = dao.getEmpByDesgs(desg1, desg2, desg3);
		return listEmps;
	}

}
