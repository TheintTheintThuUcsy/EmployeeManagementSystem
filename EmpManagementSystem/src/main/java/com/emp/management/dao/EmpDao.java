package com.emp.management.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.management.bean.Employee;

@Repository
public class EmpDao {

	@Autowired
	JdbcTemplate template;

	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> employee = template.query("select * from employee",
				(result, rowNum) -> new Employee(result.getInt("id"), result.getString("name"), result.getInt("role"),
						result.getString("position"), result.getString("teamName"), result.getString("basicSalary"),
						result.getString("empId"), result.getString("password")));
		return employee;
	}

	public Employee getEmployeeByEmpId(String empId) throws SQLException {
		String sql = "select * from employee where empId = ?";
		return template.queryForObject(sql, new Object[] { empId },
				(result, rowNum) -> new Employee(result.getInt("id"), result.getString("name"), result.getInt("role"),
						result.getString("position"), result.getString("teamName"), result.getString("basicSalary"),
						result.getString("empId")));
	}

	public void insertEmployee(String empId, String name, int role, String position, String teamName,
			String basicSalary) {
		String defaultPassword = "123456";
		String sql = "INSERT INTO employee (empId, name, password, role, position, teamName, basicSalary) VALUES (?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, empId, name, defaultPassword, role, position, teamName, basicSalary);
	}

	public void update(int id, String position, int role, String teamName, String basicSalary) throws SQLException {
		String sql = "UPDATE employee SET position = ?,role = ?, teamName = ?, basicSalary = ? WHERE (id = ?)";
		template.update(sql, position, role, teamName, basicSalary, id);
	}

	public String getOldPassword(String loginEmpId) throws SQLException {
		String sql = "select password from employee where empId = ?";
		String dbOldPassword = (String) template.queryForObject(sql, new Object[] { loginEmpId }, String.class);
		return dbOldPassword;
	}
	
	public void updatePassword(String loginEmpId, String newPassword) throws SQLException {
		String sql = "UPDATE employee SET password = ? WHERE (empId = ?)";
		template.update(sql, newPassword, loginEmpId);
	}
}
