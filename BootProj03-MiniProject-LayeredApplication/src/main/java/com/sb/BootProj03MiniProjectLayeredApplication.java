package com.sb;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.controller.PayrollSystemController;
import com.sb.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectLayeredApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj03MiniProjectLayeredApplication.class, args);
		//get Controller class object
		PayrollSystemController controller = ctx.getBean("controller",PayrollSystemController.class);
		//gather inputs from end user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Desg1 :: ");
		String desg1 = sc.next().toUpperCase();
		System.out.println("Enter Desg2 ::");
		String desg2 = sc.next().toUpperCase();
		System.out.println("Enter Desg3 :: ");
		String desg3 = sc.next().toUpperCase();
		//invoke method
		try {
			List<Employee> listEmps = controller.showEmpsDetailsByDesgs(desg1, desg2, desg3);
			//System.out.println(listEmps);
			for(Employee e : listEmps) {
				System.out.println(e);
			}//for
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
