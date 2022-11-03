package com.sb;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sb.controller.TouristController;
import com.sb.model.Tourist;

@SpringBootApplication
public class BootProj03MiniProjectAssignmentApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj03MiniProjectAssignmentApplication.class, args);
		//get controller class object
		TouristController tc = ctx.getBean("controller",TouristController.class);
		//gathered input from end user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First State :: ");
		String state1 = sc.next();
		System.out.println("Enter Second State :: ");
		String state2 = sc.next();
		System.out.println("Enter Third State ::");
		String state3 = sc.next();
		//invoke b.method
		try {
			List<Tourist> list = tc.showTouristDetails(state1, state2, state3);
			//System.out.println(list);
			for(Tourist ts : list) {
				System.out.println("for loop");
				System.out.println(ts);
			}//for
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method

}//class
