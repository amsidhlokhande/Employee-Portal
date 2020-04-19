package com.amsidh.controller;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.amsidh.dtos.EmployeeDto;
import com.amsidh.service.EmployeeService;

@Controller
@RequestMapping("VIEW")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController()
	{
		System.out.println("!!!!!Loading EmployeeController !!!!!!!");
	}

	@RenderMapping
	public ModelAndView mainPage(RenderRequest request,
			RenderResponse response,PortletSession session,@ModelAttribute("employee") EmployeeDto employee,ModelAndView model) {
		System.out.println("!!!!!!Default render method called!!!!");
		model.addObject("employee", new EmployeeDto());	
		model.addObject("employeeList", employeeService.getAllEmployee());
		model.setViewName("employee");
		return model;
	}

	@ActionMapping("employee_crud")
	public void addEmployee(RenderRequest request, RenderResponse response,
			@ModelAttribute("employee") EmployeeDto employee,
			@RequestParam("action") String action,PortletSession session,
			BindingResult bindingResult) {
        String message=null;
		
		if (action.equals("add")) {
			employeeService.createEmployee(employee);
			message="Employee added successfully.";
		}
		if (action.equals("update")) {
			employeeService.updateEmployee(employee);
			message="Employee updated successfully.";
		}
		if (action.equals("delete")) {
			employeeService.removeEmployee(employee);
			message="Employee removed successfully.";
		}
		if (action.equals("search")) {
			EmployeeDto searchEmployee = employeeService
					.searchEmployee(employee);
			if(searchEmployee!=null){
			  message="Employee found.";
			  employee.setAddress(searchEmployee.getAddress());
			  employee.setCompanyName(searchEmployee.getCompanyName());
			  employee.setEmailId(searchEmployee.getEmailId());
			  employee.setEmpId(searchEmployee.getEmpId());
			  employee.setEmpName(searchEmployee.getEmpName());
			  employee.setJoiningDate(searchEmployee.getJoiningDate());
			  employee.setMobileNumber(searchEmployee.getMobileNumber());
			}else
			{
				message="Employee not exists with these details.Please try with different details.";
			}
		}
		request.setAttribute("message", message);
	}

}
