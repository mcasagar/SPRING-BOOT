package com.sb.dao;

import java.util.List;

import com.sb.model.Employee;

public interface IEmployeeDAO {
	public  List<Employee> getEmpByDesgs(String desg1, String desg2, String desg3) throws Exception;
}
