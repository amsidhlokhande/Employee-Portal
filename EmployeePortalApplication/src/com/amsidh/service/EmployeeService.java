package com.amsidh.service;

import java.util.List;

import com.amsidh.doms.EmployeeDom;
import com.amsidh.dtos.EmployeeDto;

public interface EmployeeService {
	public void createEmployee(EmployeeDto employee);

	public void removeEmployee(EmployeeDto employee);

	public EmployeeDto updateEmployee(EmployeeDto employee);

	public EmployeeDto searchEmployee(EmployeeDto employee);

	public List<EmployeeDto> getAllEmployee();
}
