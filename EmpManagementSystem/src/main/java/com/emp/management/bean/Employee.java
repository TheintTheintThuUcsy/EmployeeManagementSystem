package com.emp.management.bean;

public class Employee {

	private int id;
	private String name;
	private String password;
	private int role;
	private String position;
	private String teamName;
	private String basicSalary;
	private String empId;

	public Employee(int id, String name, int role, String position, String teamName, String basicSalary, String empId) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.position = position;
		this.teamName = teamName;
		this.basicSalary = basicSalary;
		this.empId = empId;
	}

	public Employee(int id, String name, int role, String position, String teamName, String basicSalary, String empId,
			String password) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.position = position;
		this.teamName = teamName;
		this.basicSalary = basicSalary;
		this.empId = empId;
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public String getPosition() {
		return position;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public String getEmpId() {
		return empId;
	}
}
