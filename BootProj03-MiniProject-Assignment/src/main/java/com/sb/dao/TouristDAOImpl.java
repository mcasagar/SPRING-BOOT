package com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.model.Tourist;

@Repository("touristDAO")
public class TouristDAOImpl implements ITouristDAO {
	//Write SQL Query to get data
	private static final String GET_TOURIST_BY_STATE = "SELECT TID,TNAME,TCITY,TSTATE FROM TOURIST WHERE TSTATE IN(?,?,?) ORDER BY TSTATE";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Tourist> fetchTourByState(String state1, String state2, String state3) throws Exception {
		List<Tourist> list = null;
		//get pooled JDBC connection object
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_TOURIST_BY_STATE) ){
				
				//set Query param values
			ps.setString(1, state1);
			ps.setString(2, state2);
			ps.setString(3, state3);
			
			//execute the query
			try(ResultSet rs = ps.executeQuery()){
				//copy Employee class object to list collection as Employee class object
				list = new ArrayList();
				while(rs.next()) {
					Tourist ts = new Tourist();
					ts.setTid(rs.getInt(1));
					ts.setTname(rs.getString(2));
					ts.setTcity(rs.getString(3));
					ts.setTstate(rs.getString(4));
					list.add(ts);
				}//while
				//System.out.println(list);
			}//inner try
		}//outer try
		catch(SQLException se) {
			se.printStackTrace();
			throw se; //rethrowing exception
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; // rethrowing exception
		}
		return list;
	}//method()

}//class
