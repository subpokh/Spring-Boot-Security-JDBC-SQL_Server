package io.von.springSecurityJDBC.model;

import org.springframework.stereotype.Component;

@Component
public class Manager {
	
	private int mgrId;
	private String mgrName;
	private String department;
	private int deptId;
	
	// CREATE CORRESPONDING TABLE IN SQL SERVER AND POPULATE WITH DATAS
	public Manager() {
		
	}
	public Manager(int mgrId, String mgrName, String department, int deptId) {
		super();
		this.mgrId = mgrId;
		this.mgrName = mgrName;
		this.department = department;
		this.deptId = deptId;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	

}
