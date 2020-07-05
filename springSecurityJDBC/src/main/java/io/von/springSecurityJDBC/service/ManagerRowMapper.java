package io.von.springSecurityJDBC.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.von.springSecurityJDBC.model.Manager;


public class ManagerRowMapper implements RowMapper<Manager> {

		@Override
		public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
			Manager manager = new Manager();
			manager.setMgrId(rs.getInt("mgrId"));
			manager.setMgrName(rs.getString("mgrName"));
			manager.setDepartment(rs.getString("department"));
			manager.setDeptId(rs.getInt("deptId"));
			return manager;
		}
}
