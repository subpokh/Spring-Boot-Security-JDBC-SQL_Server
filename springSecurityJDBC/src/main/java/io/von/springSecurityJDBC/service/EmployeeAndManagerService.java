package io.von.springSecurityJDBC.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import io.von.springSecurityJDBC.model.Employee;
import io.von.springSecurityJDBC.model.Manager;

@Service
public class EmployeeAndManagerService {

		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		    public List<Object> getAllEmployeesInfo(int mgrId){
		    String query1 = "SELECT * FROM MANAGER WHERE mgrId = "+ mgrId;
		    String query2 = "SELECT * FROM EMPLOYEE WHERE mgrId = "+ mgrId;
	    	List<Manager> manager = jdbcTemplate.query(query1,new ManagerRowMapper());
	    	List<Employee> employee = jdbcTemplate.query(query2,new EmployeeRowMapper());
	    	List<Object> allEmployees = Stream.concat(manager.stream(), employee.stream()).collect(Collectors.toList());
	    	return allEmployees;	    	
	        
		    }
		    
		    public Employee getEmployeeInfo(int empId){
		    	return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE empId ="+ empId, new EmployeeRowMapper());
		    }
		    
		    public List<Object> getEmployeesByDept(int deptId){
		     String query1 = "SELECT * FROM MANAGER WHERE deptId = "+ deptId;
			 String query2 = "SELECT empId, empName, position, department FROM EMPLOYEE WHERE deptId = "+ deptId;
			 List<Manager> manager = jdbcTemplate.query(query1,new ManagerRowMapper());
			 List<Employee> employee = jdbcTemplate.query(query2,new ViewEmployeeRowMapper());
			 List<Object> allEmployees = Stream.concat(manager.stream(), employee.stream()).collect(Collectors.toList());
			 return allEmployees;	    	
			        
		    }
			
	}



