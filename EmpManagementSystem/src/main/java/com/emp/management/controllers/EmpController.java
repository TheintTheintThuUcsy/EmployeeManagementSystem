package com.emp.management.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emp.management.bean.Employee;
import com.emp.management.bean.MessageList;
import com.emp.management.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired
	EmpDao dao;

	MessageList msgList = new MessageList();

	@RequestMapping("/")
	public String showLoginForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("empId") String empId, @RequestParam("password") String password)
			throws SQLException {
		boolean error = false;
		ModelAndView modelAndView = new ModelAndView("loginForm");
		if (empId.isEmpty()) {
			modelAndView.addObject("errEmpId", msgList.getInfo001());
			error = true;
		}
		if (password.isEmpty()) {
			modelAndView.addObject("errPassword", msgList.getInfo002());
			error = true;
		}
		if (!empId.isEmpty() && !password.isEmpty()) {
			List<Employee> empList = dao.getAllEmployee();
			for (Employee employee : empList) {
				// employee id and password are correct to db data , move next page according to
				// role
				if (employee.getEmpId().equals(empId) && employee.getPassword().equals(password)) {
					String loginEmpId = empId;
					// if employee login, show self data
					if (employee.getRole() == 0) {
						Employee emp = dao.getEmployeeByEmpId(empId);
						ModelAndView modelAndView2 = new ModelAndView("showEmpDataById");
						modelAndView2.addObject("emp", emp);
						modelAndView2.addObject("loginEmpId", loginEmpId);
						modelAndView2.addObject("loginRole",0);
						return modelAndView2;
					}
					// if admin login, show all emp data
					else if (employee.getRole() == 1) {
						ModelAndView modelAndView3 = new ModelAndView("showAllEmpData");
						modelAndView3.addObject("empList", empList);
						modelAndView3.addObject("loginEmpId", loginEmpId);
						return modelAndView3;
					}
					break;
				}
				// employee id and password are not correct to db data , stay login form again
				else {
					modelAndView.addObject("msg", msgList.getErr001());
					error = true;
				}
			}
		}
		// user inserted data have error, return user inputed data
		if (error) {
			modelAndView.addObject("empId", empId);
			modelAndView.addObject("password", password);
		}
		return modelAndView;
	}

	@RequestMapping("/showEmpData/{empId}")
	public ModelAndView showEmpDataById(@PathVariable String empId) throws SQLException {
		Employee emp = dao.getEmployeeByEmpId(empId);
		ModelAndView modelAndView = new ModelAndView("showEmpDataById");
		modelAndView.addObject("emp", emp);
		return modelAndView;
	}

	@RequestMapping("/showAddNewEmplyeePage")
	public ModelAndView addNewEmployee() throws SQLException {
		return new ModelAndView("addNewEmployee");
	}

	@RequestMapping("/insertEmployee")
	public ModelAndView insertNewEmpData(@RequestParam("empId") String empId, @RequestParam("name") String name,
			@RequestParam("position") String position, @RequestParam("role") String role,
			@RequestParam("teamName") String teamName, @RequestParam("basicSalary") String basicSalary)
			throws SQLException {
		boolean error = false;
		ModelAndView modelAndView = new ModelAndView("addNewEmployee");
		// if user did not fill employee id , show error message
		if (empId.isEmpty()) {
			modelAndView.addObject("errEmpId", msgList.getInfo001());
			error = true;
		}
		// if employee id does not match formal style like emp001, show error message
		else if (!empId.matches("^emp[0-9]{3}$")) {
			modelAndView.addObject("errEmpId", msgList.getErr003());
			error = true;
		}
		// if inputed employee id is duplicate to id in DB , show error message
		else {
			List<Employee> empList = dao.getAllEmployee();
			for (Employee employee : empList) {
				// if user inputed EmpId is duplicate to id in db, show error message
				if (empId.equals(employee.getEmpId())) {
					modelAndView.addObject("errEmpId", msgList.getErr002());
					error = true;
					break;
				}
			}
		}
		// if user did not fill employee name , show error message
		if (name.isEmpty()) {
			modelAndView.addObject("errEmpName", msgList.getInfo003());
			error = true;
		}
		// if user did not fill position , show error message
		if (position.isEmpty()) {
			modelAndView.addObject("errPosition", msgList.getInfo004());
			error = true;
		}
		// if user did not fill team name , show error message
		if (teamName.isEmpty()) {
			modelAndView.addObject("errTeamName", msgList.getInfo005());
			error = true;
		}
		// if user did not fill basicSalary , show error message
		if (basicSalary.isEmpty()) {
			modelAndView.addObject("errBasicSalary", msgList.getInfo006());
			error = true;
		}
		// if inputed data is not number, show error message
		else if (basicSalary.matches("^[^\\d].*")) {
			modelAndView.addObject("errBasicSalary", msgList.getErr004());
			error = true;
		}
		// if inputed salary is less than 150000 , show error message
		else if (Integer.parseInt(basicSalary) < 150000) {
			modelAndView.addObject("errBasicSalary", msgList.getInfo007());
			error = true;
		}
		// if inputed datas have error, show addNewEmployee Form again
		if (error) {
			modelAndView.addObject("userInputedID", empId);
			modelAndView.addObject("userInputedName", name);
			modelAndView.addObject("userInputedPosition", position);
			modelAndView.addObject("userSelectedRole", role);
			modelAndView.addObject("userInputedTeamName", teamName);
			modelAndView.addObject("userInputedBasicSalary", basicSalary);
			return modelAndView;
		}
		// no error , go to showAllEmpData Form
		else {
			int empRole = 0;
			if (role.equals("Admin"))
				empRole = 1;
			dao.insertEmployee(empId, name, empRole, position, teamName, basicSalary);
			List<Employee> empList = dao.getAllEmployee();
			ModelAndView modelAndView2 = new ModelAndView("showAllEmpData");
			modelAndView2.addObject("empList", empList);
			return modelAndView2;
		}
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editEmpData(@PathVariable int id, @RequestParam("empId") String empId,
			@RequestParam("name") String name, @RequestParam("position") String position,
			@RequestParam("role") String role, @RequestParam("teamName") String teamName,
			@RequestParam("basicSalary") String basicSalary, Model model) throws SQLException {
		boolean error = false;
		ModelAndView modelAndView = new ModelAndView("showEmpDataById");
		// if user did not fill position , show error message
		if (position.isEmpty()) {
			modelAndView.addObject("errPosition", msgList.getInfo004());
			error = true;
		}
		// if user did not fill team name , show error message
		if (teamName.isEmpty()) {
			modelAndView.addObject("errTeamName", msgList.getInfo005());
			error = true;
		}
		// if user did not fill basicSalary , show error message
		if (basicSalary.isEmpty()) {
			modelAndView.addObject("errBasicSalary", msgList.getInfo006());
			error = true;
		}
		// if inputed data is not number, show error message
		else if (basicSalary.matches("^[^\\d].*")) {
			modelAndView.addObject("errBasicSalary", msgList.getErr004());
			error = true;
		}
		// if inputed salary is less than 150000 , show error message
		else if (Integer.parseInt(basicSalary) < 150000) {
			modelAndView.addObject("errBasicSalary", msgList.getInfo007());
			error = true;
		}
		int empRole = 0;
		if (role.equals("Admin")) {
			empRole = 1;
		}
		// if inputed datas have error, show showEmpDataById Form again
		if (error) {
			Employee e = new Employee(id, name, empRole, position, teamName, basicSalary, empId);
			modelAndView.addObject("emp", e);
			return modelAndView;
		} else {
			dao.update(id, position, empRole, teamName, basicSalary);
			List<Employee> empList = dao.getAllEmployee();
			ModelAndView modelAndView2 = new ModelAndView("showAllEmpData");
			modelAndView2.addObject("empList", empList);
			return modelAndView2;
		}
	}

	@RequestMapping("/showChangePasswordPage/{loginEmpId}")
	public ModelAndView showChangePasswordPage(@PathVariable String loginEmpId) {
		ModelAndView modelAndView = new ModelAndView("changePassword");
		modelAndView.addObject("loginEmpId", loginEmpId);
		return modelAndView;
	}

	@RequestMapping("/changePassword/{loginEmpId}")
	public ModelAndView changePassword(@PathVariable String loginEmpId, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmNewPassword") String confirmNewPassword) throws SQLException {
		ModelAndView modelAndView = new ModelAndView("changePassword");
		String dbOldPassword = dao.getOldPassword(loginEmpId);
		boolean error = false;
		if (oldPassword.isEmpty()) {
			modelAndView.addObject("errOldPassword", msgList.getInfo013());
			error = true;
		} else {
			if (!oldPassword.equals(dbOldPassword)) {
				modelAndView.addObject("errOldPassword", msgList.getErr005());
				error = true;
			}
		}
		if (newPassword.isEmpty()) {
			modelAndView.addObject("errNewPassword", msgList.getInfo014());
			error = true;
		} else if (newPassword.length() != 6) {
			modelAndView.addObject("errNewPassword", msgList.getInfo010());
			error = true;
		} else if (newPassword.equals(dbOldPassword)) {
			modelAndView.addObject("errNewPassword", msgList.getErr006());
			error = true;
		}
		if (confirmNewPassword.isEmpty()) {
			modelAndView.addObject("errConfirmNewPassword", msgList.getInfo015());
			error = true;
		} else if (confirmNewPassword.length() != 6) {
			modelAndView.addObject("errConfirmNewPassword", msgList.getInfo010());
			error = true;
		} else if (confirmNewPassword.equals(dbOldPassword)) {
			modelAndView.addObject("errConfirmNewPassword", msgList.getErr006());
			error = true;
		}

		if (newPassword.length() == 6 && confirmNewPassword.length() == 6 && !newPassword.equals(confirmNewPassword)) {
			modelAndView.addObject("msg", msgList.getInfo011());
			error = true;
		}

		if (error) {
			modelAndView.addObject("oldPassword", oldPassword);
			modelAndView.addObject("newPassword", newPassword);
			modelAndView.addObject("confirmNewPassword", confirmNewPassword);
			return modelAndView;
		} else {
			dao.updatePassword(loginEmpId, newPassword);
			ModelAndView modelAndView2 = new ModelAndView("loginForm");
			modelAndView2.addObject("msg",msgList.getInfo012());
			return modelAndView2;
		}
	}

}
