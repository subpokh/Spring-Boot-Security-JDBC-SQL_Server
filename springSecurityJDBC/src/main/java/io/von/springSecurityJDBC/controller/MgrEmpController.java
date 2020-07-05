package io.von.springSecurityJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.von.springSecurityJDBC.model.Employee;
import io.von.springSecurityJDBC.service.EmployeeAndManagerService;

@RestController
@RequestMapping("/api")
public class MgrEmpController {
	
	@Autowired
	private EmployeeAndManagerService emservice;
	//	AFTER ENTERING localhost:portno/api/mgr/* ,ACCESS TO ONLY user: manager with admin roles 
	@GetMapping("/mgr")
	public String welcomeManager() {
		return "HELLO MANAGER";
	}

	@GetMapping("/mgr/{mgrId}")
	public List<Object> getAllEmployeesInfoForManager(@PathVariable("mgrId")int mgrId){
		return emservice.getAllEmployeesInfo(mgrId);
	}
	//	AFTER ENTERING localhost:portno/api/emp/* ,ACCESS TO both user:manager and user:employee with both admin and user roles 
	@GetMapping("/emp")
	public String welcomeEmployee() {
		return "HELLO EMPLOYEE";
	}
	
	@GetMapping("/emp/{empId}")
	public Employee getEmployeeDetail(@PathVariable("empId")int empId){
		return emservice.getEmployeeInfo(empId);
	}
	//	AFTER ENTERING localhost:portno/api/all/* ,ACCESS TO ALL ROLES AND USERS
	@GetMapping("/all")
	public String welcomeAll() {
		return "HELLO ALL";
	}
	@GetMapping("/all/{deptId}")
	public List<Object> getAllEmployeeByDepartment(@PathVariable("deptId")int deptId){
		return emservice.getEmployeesByDept(deptId);
	}

}
