package com.amsidh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.doms.EmployeeDom;
import com.amsidh.dtos.EmployeeDto;
import com.amsidh.util.DomDaoCreatorUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public EmployeeDaoImpl()
	{
		System.out.println("!!!!!Loading EmployeeDaoImpl !!!!!!!");
	}
	
	public void createEmployee(EmployeeDto employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(DomDaoCreatorUtil.getEmployeeDom(employee));
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public void removeEmployee(EmployeeDto employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.delete(DomDaoCreatorUtil.getEmployeeDom(employee));
		} catch (HibernateException hex) {
			System.out.println("No Record found :" + hex.getLocalizedMessage());
		}
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

	public EmployeeDto updateEmployee(EmployeeDto employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(DomDaoCreatorUtil.getEmployeeDom(employee));
		session.flush();
		session.getTransaction().commit();
		session.close();

		return employee;
	}

	public EmployeeDto searchEmployee(EmployeeDto employee) {
		EmployeeDto employeeDto = null;
		List<EmployeeDto> listOfemployeDto = new ArrayList<EmployeeDto>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from EmployeeDom where empId="
				+ employee.getEmpId() + " or empName like '"
				+ employee.getEmpName() + "' or companyName like '"
				+ employee.getCompanyName() + "' or " + "joiningDate ="
				+ employee.getJoiningDate() + " or mobileNumber="
				+ employee.getMobileNumber() + " or emailId like '"
				+ employee.getEmailId() + "' or address like '"
				+ employee.getAddress() + "'");

		/*
		 * Query query = session .createQuery(
		 * "from EmployeeDom where empId=:empId or empName like :empName or companyName like :companyName or "
		 * +
		 * "joiningDate =:joiningDate or mobileNumber=:mobileNumber or emailId like :emailId or address like :address "
		 * );
		 * 
		 * query.setInteger("empId", employee.getEmpId());
		 * query.setString("empName", employee.getEmpName());
		 * query.setString("companyName", employee.getCompanyName());
		 * query.setDate("joiningDate", employee.getJoiningDate());
		 * query.setLong("mobileNumber", employee.getMobileNumber());
		 * query.setString("emailId", employee.getEmailId());
		 * query.setString("address", employee.getAddress());
		 */
		listOfemployeDto = DomDaoCreatorUtil
				.getEmployeeDtos((List<EmployeeDom>) query.list());

		if (!listOfemployeDto.isEmpty()) {
			employeeDto = listOfemployeDto.get(0);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();

		return employeeDto;

	}

	public List<EmployeeDto> getAllEmployee() {

		List<EmployeeDto> listOfemployeDto = new ArrayList<EmployeeDto>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		listOfemployeDto = DomDaoCreatorUtil
				.getEmployeeDtos((List<EmployeeDom>) session.createQuery(
						"from EmployeeDom").list());
		session.flush();
		session.getTransaction().commit();
		session.close();
		return listOfemployeDto;
	}

}
