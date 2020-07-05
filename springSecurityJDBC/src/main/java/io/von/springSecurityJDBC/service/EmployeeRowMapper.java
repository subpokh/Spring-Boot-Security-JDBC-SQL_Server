package io.von.springSecurityJDBC.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import io.von.springSecurityJDBC.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("empId"));
		employee.setEmpName(rs.getString("empName"));
		employee.setPosition(rs.getString("position"));
		employee.setDepartment(rs.getString("department"));
		employee.setSalary(rs.getInt("salary"));
		employee.setHiredDate(rs.getDate("hiredDate"));
		employee.setMgrId(rs.getInt("mgrId"));
		employee.setDeptId(rs.getInt("deptId"));
		return employee;
	}
	


}
