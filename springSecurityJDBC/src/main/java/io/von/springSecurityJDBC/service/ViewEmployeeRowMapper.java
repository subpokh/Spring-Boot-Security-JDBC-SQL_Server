package io.von.springSecurityJDBC.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.von.springSecurityJDBC.model.Employee;

public class ViewEmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();	
		employee.setEmpId(rs.getInt("empId"));
		employee.setEmpName(rs.getString("empName"));
		employee.setPosition(rs.getString("position"));
		employee.setDepartment(rs.getString("department"));
		return employee;
	}

}
