package com.abc.mainapp;

import java.util.List;


import org.hibernate.Session;

import com.abc.pojo.Employee;
import com.abc.factory.HibernateUtil;

public class PersistanceOperation {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSession()) {

			String pkId = "10";
			List<Employee> employees = session.getNamedQuery("getAllEmployeesStoredProcedure").setParameter("eno", pkId)
					.getResultList();

			if (employees.isEmpty()) {
				System.out.println("Records not available for the give id:" + pkId);
			} else {
				employees.forEach(System.out::print);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
 Hibernate: call getAllEmployees(?)
[eno=10, ename=sachin, eage=48, eaddress=mumbai, esalary=50000]
*/