package io.von.springSecurityJDBC.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private int empId;
	private String empName;
	private String position;
	private String department;
	private int salary;
	private Date hiredDate;
	private int mgrId;
	private int deptId;
	
	// CREATE CORRESPONDING TABLE IN SQL SERVER AND POPULATE WITH DATAS
	
	public Employee() {
		
	}

	public Employee(int empId, String empName, String position, String department, int salary, Date hiredDate,
			int mgrId, int deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.position = position;
		this.department = department;
		this.salary = salary;
		this.hiredDate = hiredDate;
		this.mgrId = mgrId;
		this.deptId = deptId;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	
}
