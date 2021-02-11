package com.abc.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.abc.factory.HibernateUtil;
import com.abc.model.Employee;

public class EmployeeService {
	Session session = null;
	Query<Employee> query = null;

	public EmployeeService() {

		try {

			session = HibernateUtil.getSession();
			query = session.createQuery("from Employee", Employee.class);
			query.setMaxResults(3);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Employee> getEmployeeDetails(int label) {

		if (label == 1) {
			query.setFirstResult(0);
		}
		if (label == 2) {
			query.setFirstResult(3);
		}
		if (label == 3) {
			query.setFirstResult(6);
		}

		List<Employee> employees = query.getResultList();
		return employees;

	}

}
